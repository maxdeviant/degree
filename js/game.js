
var Q = new Quintus().include(['Sprites', 'Scenes', 'Input', 'Touch', '2D', 'UI', 'Anim']).setup({
    maximize: true
}).setup().touch();

var time = 0;

Q.input.keyboardControls({
    32: 'up',
    65: 'left',
    68: 'right'
});

var Level = function () {
    this.generate = function (width, height, start, end) {
        var TILES = Object.freeze({
            AIR: 0,
            BLOCK: 1
        });

        var map = [];

        start = start || {
            x: 0,
            y: height - 2
        };

        end = end || {};

        for (var row = 0; row < height; row++) {
            map[row] = [];

            for (var col = 0; col < width; col++) {
                map[row][col] = TILES.AIR;
            }
        }

        var currElevation = Math.floor(Math.random() * height);
        var lastElevation = 0;

        for (var col = 0; col < width; col++) {
            lastElevation = currElevation;
            currElevation = this.createElevation(height, lastElevation);

            for (var e = 0; e < currElevation; e++) {
                map[height - e - 1][col] = TILES.BLOCK;
            }

            map[height - 1][col] = TILES.BLOCK;
        }

        var isValid = this.validate(map, start, end);

        if (isValid) {
            return map;
        }

        return this.generate(width, height);
    };

    this.validate = function (map, start, end) {
        return Math.random() < 0.5;
    };

    this.createElevation = function (max, last) {
        var elevation = Math.floor(Math.random() * max);

        if (Math.abs(elevation - last) > 2) {
            return this.createElevation(max, last);
        }

        return elevation;
    };
};

Q.Sprite.extend('Player', {
    init: function (p) {
        this._super(p, {
            sprite: 'player',
            sheet: 'player',
            x: 15,
            y: Q.height + 5,
            jumpSpeed: -400
        });

        this.add(['2d', 'platformerControls', 'animation', 'tween']);
    },
    step: function (dt) {
        if (Q.inputs.right) {
            if (this.p.landed > 0) {
                this.play('run_right');
            } else {
                this.play('jump_right');
            }
        } else if (Q.inputs.left) {
            if (this.p.landed > 0) {
                this.play('run_left');
            } else {
                this.play('jump_left');
            }
        } else {
            if (Q.inputs.up) {
                this.play('jump_' + this.p.direction);
            } else {
                this.play('idle_' + this.p.direction);
            }
        }

        time += dt;
        Q.state.set('time', time);
    }
});

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
        this.p.label = 'Time: ' + time.toFixed(2);
    }
});

Q.scene('menu', function (stage) {
    var container = stage.insert(new Q.UI.Container({
        x: Q.width / 2,
        y: Q.height / 4,
        fill: '#000'
    }));

    container.insert(new Q.UI.Text({
        label: 'Project Two',
        color: '#fff',
        x: 0,
        y: 0
    }));

    container.insert(new Q.UI.Button({
        label: 'Start',
        fill: '#fff',
        x: 0,
        y: 70,
        w: 100
    }, function () {
        time = 0;

        Q.stageScene('game');
        Q.stageScene('hud');
    }));
});

Q.scene('hud', function (stage) {
    stage.insert(new Q.Time());
}, {
    stage: 1
});

Q.scene('game', function (stage) {
    var l = new Level();

    var map = l.generate(3000, 20);

    Q.scene('testLevel', function (stage) {
        stage.insert(new Q.Repeater({
            asset: 'background-wall.png',
            speedX: 0.5,
            speedY: 0.5
        }));

        stage.collisionLayer(new Q.TileLayer({
            tiles: map,
            sheet: 'tiles'
        }));

        var player = stage.insert(new Q.Player({
            y: ((Q.height / 2) + 3)
        }));

        stage.add('viewport').follow(player);
    });

    Q.stageScene('testLevel');
});

Q.clearColor = '#000';

Q.load(['sprites.png', 'sprites.json', 'tiles.png', 'player.png', 'player.json', 'background-wall.png'], function () {
    Q.sheet('tiles', 'tiles.png', {
        tilew: 32,
        tileh: 32
    });

    Q.compileSheets('sprites.png', 'sprites.json');
    Q.compileSheets('player.png', 'player.json');

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
            frames: [1, 2, 3, 4],
            rate: 1 / 5,
            flip: false,
            loop: true
        },
        run_left: {
            frames: [1, 2, 3, 4],
            rate: 1 / 5,
            flip: 'x',
            loop: true
        },
        jump_right: {
            frames: [5],
            rate: 1 / 5,
            flip: false,
            loop: true
        },
        jump_left: {
            frames: [5],
            rate: 1 / 5,
            flip: 'x',
            loop: true
        }
    });

    // Q.stageScene('menu');
    time = 0;

    Q.stageScene('game');
    Q.stageScene('hud');
});