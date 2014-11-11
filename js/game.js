'use strict';

// Initialize Quintus
var Q = window.Q = new Quintus({
    audioSupported: ['ogg']
}).include(['Sprites', 'Scenes', 'Input', 'Touch', '2D', 'UI', 'Anim', 'Audio']).setup({
    maximize: true
}).setup().touch().enableSound();

// Timer
var time;

// Global side-scrolling camera
var camera;

// Edge of camera
var screenEdge;

// Level generation information
var levelWidth;
var levelHeight;
var levelEnd;

// Add controls
Q.input.keyboardControls({
    // Spacebar
    32: 'up',
    // A
    65: 'left',
    // D
    68: 'right'
});

var Level = function () {
    // Generates a new levelmap
    this.generate = function (width, height, start, end) {
        // Tiles enum
        var TILES = Object.freeze({
            AIR: 0,
            BLOCK: 1,
            LAVA: 2
        });

        // Blank levelmap
        var map = [];

        // Define default start point, if not provided
        start = start || {
            x: 0,
            y: height - 2
        };

        // Define default end point, if not provided
        end = end || {};

        // Generate rows of the levelmap
        for (var row = 0; row < height; row++) {
            // Make array 2-dimensional
            map[row] = [];

            // Generate columns of the levelmap
            for (var col = 0; col < width; col++) {
                // Fill with empty (air) tiles
                map[row][col] = TILES.AIR;
            }
        }

        // Initialize starting elevation and last elevation
        var currElevation = Math.floor(Math.random() * height);
        var lastElevation = 0;

        // Iterate through levelmap columns
        for (var col = 0; col < width; col++) {
            // Set the last elevation value
            lastElevation = currElevation;

            // Create next elevation
            currElevation = this.createElevation(height, lastElevation);

            // Iteratve over levels of elevation
            for (var e = 0; e < currElevation; e++) {
                // Fill with block tile
                map[height - e - 1][col] = TILES.BLOCK;
            }

            // Create row of blocks at bottom of levelmap
            map[height - 1][col] = TILES.BLOCK;
        }

        // Check levelmap validity
        var isValid = this.validate(map, start, end);

        // If the levelmap is valid
        if (isValid) {
            // Return the levelmap
            return map;
        }

        // Generate new levelmap
        return this.generate(width, height);
    };

    // Validates a given levelmap
    this.validate = function (map, start, end) {
        return true;
    };

    // Creates an elevation value that is within a given distance of the last one
    this.createElevation = function (max, last) {
        // Define the difference interval
        var difference = 2;

        // Generate a new elevation value
        var elevation = Math.floor(Math.random() * max);

        // If the elevation value is too large
        if (Math.abs(elevation - last) > difference) {
            // Generate a new elevation value
            return this.createElevation(max, last);
        }

        // Return the elevation value
        return elevation;
    };
};

// Player object
Q.Sprite.extend('Player', {
    init: function (p) {
        this._super(p, {
            sprite: 'player',
            sheet: 'player',
            standingPoints: [
                [-9, 15],
                [-12, 5],
                [-10, -10],
                [10, -10],
                [12, 5],
                [9, 15]
            ],
            x: 15,
            y: Q.height / 2,
            jumpSpeed: -400
        });

        this.p.points = this.p.standingPoints;

        this.add(['2d', 'platformerControls', 'animation', 'tween']);
    },
    step: function (dt) {
        // If player falls behind scrolling camera
        if (this.p.x < screenEdge) {
            // Lose the game
            Q.clearStages();
            Q.stageScene('lose');
        }

        // If player falls of the screen vertically
        if (this.p.y > Q.height) {
            // Lose the game
            Q.clearStages();
            Q.stageScene('lose');
        }

        // If the 'right' key is held down
        if (Q.inputs.right) {
            // If player is on the ground
            if (this.p.landed > 0) {
                // Play right run animation
                this.play('run_right');
            } else { // If player is in the air
                // Play right jump animation
                this.play('jump_right');
            }
        } else if (Q.inputs.left) { // If the 'left' key is held down
            // If player is on the ground
            if (this.p.landed > 0) {
                // Play left run animation
                this.play('run_left');
            } else { // If the player is in the air
                // Play left jump animation
                this.play('jump_left');
            }
        } else { // If neither are held down
            // If 'jump' key is held down
            if (Q.inputs.up) {
                // Play jump animation for current direction
                this.play('jump_' + this.p.direction);
            } else { // If 'jump' key is not held down
                // Play idle animation for current direction
                this.play('idle_' + this.p.direction);
            }
        }

        // Update time counter
        time += dt;
        Q.state.set('time', time);
    }
});

// Enemy object
Q.Sprite.extend('Enemy', {
    init: function (p) {
        this._super(p, {
            sheet: 'enemy',
            vx: 100
        });

        this.add(['2d', 'aiBounce']);

        this.on('bump.left,bump.right,bump.bottom', function (collision) {
            if (collision.obj.isA('Player')) {
                Q.stageScene('endGame', 1, {
                    label: 'You Died'
                });
                collision.obj.destroy();
            }
        });

        this.on('bump.top', function (collision) {
            if (collision.obj.isA('Player')) {
                this.destroy();
                collision.obj.p.vy = -300;
            }
        });
    }
});

// Time HUD element
Q.UI.Text.extend('Time', {
    init: function (p) {
        this._super({
            label: 'Time: 0:00',
            align: 'left',
            x: Q.width - 80,
            y: 30,
            font: 'monospace',
            weight: 'normal',
            color: 'white',
            size: 20
        });

        Q.state.on('change.time', this, 'time');
    },
    time: function (time) {
        // Update time display
        this.p.label = 'Time: ' + time.toFixed(2);

        // Update screen edge (for lose state)
        screenEdge = time * 32;

        // Scroll the camera
        camera.moveTo(screenEdge, levelHeight * -6.4);
    }
});

// Menu screen
Q.scene('menu', function (stage) {
    // Add container
    var container = stage.insert(new Q.UI.Container({
        x: Q.width / 2,
        y: Q.height / 4,
        fill: '#000'
    }));

    // Add game title
    container.insert(new Q.UI.Text({
        label: 'SPRINTf',
        color: '#fff',
        x: 0,
        y: 0
    }));

    // Add start button
    container.insert(new Q.UI.Button({
        label: 'Start',
        fill: '#fff',
        x: 0,
        y: 70,
        w: 100
    }, function () {
        // Reset game values
        time = 0;
        screenEdge = 0;

        // Play audio
        Q.audio.play('game.ogg', {
            loop: true
        });

        // Stage game and HUD
        Q.stageScene('game');
        Q.stageScene('hud');
    }));
});

// HUD overlay
Q.scene('hud', function (stage) {
    // Add timer display
    stage.insert(new Q.Time());
}, {
    stage: 1
});

// Game screen
Q.scene('game', function (stage) {
    Q.scene('level', function (stage) {
        // Tile background
        stage.insert(new Q.Repeater({
            asset: 'background-wall.png',
            speedX: 0.5,
            speedY: 0.5
        }));

        // Add level generator
        var l = new Level();

        // Set level values
        levelWidth = 100000;
        levelHeight = 20;

        // Generate a new levelmap
        var map = l.generate(levelWidth, levelHeight);

        // Set the end value of the level
        levelEnd = levelWidth * 32;

        // Generate collision layer from levelmap
        stage.collisionLayer(new Q.TileLayer({
            tiles: map,
            sheet: 'tiles'
        }));

        // Add the player
        var player = stage.insert(new Q.Player({
            x: 64,
            y: 14
            // y: l.map[[][0]].height
        }));

        // Add the scrolling camera
        camera = stage.add('viewport');
    });

    // Stage the level
    Q.stageScene('level');
});

// Lose screen
Q.scene('lose', function (stage) {
    // Add container
    var container = stage.insert(new Q.UI.Container({
        x: Q.width / 2,
        y: Q.height / 4,
        fill: '#000'
    }));

    // Add death message
    container.insert(new Q.UI.Text({
        label: 'You Died!',
        color: '#fff',
        x: 0,
        y: 0
    }));

    // Display time survived
    container.insert(new Q.UI.Text({
        label: 'You lasted ' + Q.state.get('time').toFixed(2) + ' seconds.',
        color: '#fff',
        x: 0,
        y: 70
    }));

    // Add button to return to menu
    container.insert(new Q.UI.Button({
        label: 'Menu',
        fill: '#fff',
        x: 0,
        y: 140,
        w: 100
    }, function () {
        // Return to the menu
        Q.stageScene('menu');
    }));
});

// Set canvas clear color
Q.clearColor = '#000';

// Load assets
Q.load(['sprites.png', 'sprites.json', 'tiles.png', 'player.png', 'player.json', 'background-wall.png', 'game.ogg'], function () {
    // Initialize tile sprites
    Q.sheet('tiles', 'tiles.png', {
        tilew: 32,
        tileh: 32
    });

    // Compile spritesheets
    Q.compileSheets('sprites.png', 'sprites.json');
    Q.compileSheets('player.png', 'player.json');

    // Define player animations
    Q.animations('player', {
        idle_right: {
            frames: [0],
            rate: 1 / 5,
            flip: false,
            loop: true
        },
        idle_left: {
            frames: [0],
            rate: 1 / 5,
            flip: 'x',
            loop: true
        },
        run_right: {
            frames: [1, 2, 1, 4, 3, 4],
            rate: 1 / 2,
            flip: false,
            loop: true
        },
        run_left: {
            frames: [1, 2, 3, 4],
            rate: 1 / 2,
            flip: 'x',
            loop: true
        },
        jump_right: {
            frames: [5],
            rate: 1 / 2,
            flip: false,
            loop: true
        },
        jump_left: {
            frames: [5],
            rate: 1 / 2,
            flip: 'x',
            loop: true
        }
    });

    // Stage the menu screen when complete
    Q.stageScene('menu');
});