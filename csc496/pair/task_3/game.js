var sprites = {
    ship: {
        sx: 0,
        sy: 0,
        w: 37,
        h: 42,
        frames: 1
    },
    star_powerup: {
        sx: 12,
        sy: 44,
        w: 16,
        h: 17,
        frames: 1
    },
};

var enemies = {
    straight: {
        x: 0,
        y: -50,
        sprite: 'enemy_ship',
        health: 10,
        E: 100
    },
    ltr: {
        x: 0,
        y: -100,
        sprite: 'enemy_purple',
        health: 10,
        B: 75,
        C: 1,
        E: 100,
        missiles: 2
    },
    circle: {
        x: 250,
        y: -50,
        sprite: 'enemy_circle',
        health: 10,
        A: 0,
        B: -100,
        C: 1,
        E: 20,
        F: 100,
        G: 1,
        H: Math.PI / 2
    },
    wiggle: {
        x: 100,
        y: -50,
        sprite: 'enemy_bee',
        health: 20,
        B: 50,
        C: 4,
        E: 100,
        firePercentage: 0.001,
        missiles: 2
    },
    step: {
        x: 0,
        y: -50,
        sprite: 'enemy_circle',
        health: 10,
        B: 150,
        C: 1.2,
        E: 75
    },
    line: {
        x: -40,
        y: 50,
        sprite: 'enemy_line',
        health: 10,
        A: 50,
        B: 25
    }
};

var won = false;

var OBJECT_PLAYER = 1,
    OBJECT_PLAYER_PROJECTILE = 2,
    OBJECT_ENEMY = 4,
    OBJECT_ENEMY_PROJECTILE = 8,
    OBJECT_POWERUP = 16;

var startGame = function () {
    Game.setBoard(0, new Starfield(20, 0.4, 100, true));
    Game.setBoard(1, new Starfield(50, 0.6, 100));
    Game.setBoard(2, new Starfield(100, 1.0, 50));
    Game.setBoard(3, new TitleScreen('Alien Invasion', 'fire', 'Press fire to start playing', playGame, 'Marshall'));

    setTimeout(function () {
        if (!won) {
            loseGame();
        }

        Game.timer--;
    }, 30 * 1000);
};

var levels = {
    1: [
        // Start,   End, Gap,  Type,   Override
        // [ 0,      4000,  500, 'step' ],
        // [ 6000,   13000, 800, 'ltr' ],
        // [ 10000,  16000, 400, 'circle' ],
        // [ 12000,  17000, 1000, 'line' ],
        // [ 17800,  20000, 500, 'straight', { x: 50 } ],
        // [ 18200,  20000, 500, 'straight', { x: 90 } ],
        // [ 18200,  20000, 500, 'straight', { x: 10 } ],
        // [ 22000,  25000, 400, 'wiggle', { x: 150 }],
        // [ 22000,  25000, 400, 'wiggle', { x: 100 }]
    ],
    2: [
        // [ 0, 5000, 800, 'straight', { x: 25 } ],
        // [ 1000, 6000, 800, 'straight', { x: 250 } ],
        // [ 6000, 14000, 400, 'wiggle', { x: 150 }],
        // [ 14000, 16000, 1000, 'line' ],
        // [ 16000, 20000, 600, 'circle' ]
    ]
};

var invulnerability;

var playGame = function () {
    var board = new GameBoard();
    board.add(new PlayerShip());
    board.add(new Level(levels, winGame));
    Game.setBoard(3, board);
    Game.setBoard(4, new GamePoints(0));
    Game.setBoard(5, new LevelCounter());
    Game.shipCount = 2;
    invulnerability = 0;
};

var winGame = function () {
    won = true;
    Game.setBoard(3, new TitleScreen('You win!', 'restart', 'Press enter to play again', playGame));
};

var loseGame = function () {
    Game.setBoard(3, new TitleScreen('You lose!', 'restart', 'Press enter to play again', playGame));
};

window.addEventListener ('load', function () {
    Game.initialize('game', sprites, startGame);
});

var Starfield = function (speed, opacity, numStars, clear) {

    var stars = document.createElement('canvas');
    stars.width = Game.width; 
    stars.height = Game.height;
    var starCtx = stars.getContext('2d');

    var offset = 0;

    if (clear) {
        starCtx.fillStyle = '#000';
        starCtx.fillRect(0, 0, stars.width, stars.height);
    }

    starCtx.fillStyle = '#fff';
    starCtx.globalAlpha = opacity;
    for (var i = 0; i < numStars; i++) {
        starCtx.fillRect(Math.floor(Math.random() * stars.width), Math.floor(Math.random() * stars.height), 2, 2);
    }

    this.draw = function (ctx) {
        var intOffset = Math.floor(offset);
        var remaining = stars.height - intOffset;

        if (intOffset > 0) {
            ctx.drawImage(stars, 0, remaining, stars.width, intOffset, 0, 0, stars.width, intOffset);
        }

        if (remaining > 0) {
            ctx.drawImage(stars, 0, 0, stars.width, remaining, 0, intOffset, stars.width, remaining);
        }
    };

    this.step = function (dt) {
        offset += dt * speed;
        offset = offset % stars.height;
    };
};

var PlayerShip = function () { 
    this.setup('ship', {
        vx: 0,
        reloadTime: 0.25,
        maxVel: 200
    });

    this.reload = this.reloadTime;
    this.x = Game.width / 2 - this.w / 2 + 20;
    this.y = Game.height - Game.playerOffset - this.h;

    this.step = function (dt) {
        if (Game.keys['left']) {
            this.vx = -this.maxVel;
        } else if (Game.keys['right']) {
            this.vx = this.maxVel;
        } else {
            this.vx = 0;
        }

        // if (Game.keys['up']) {
        //     this.vy = -this.maxVel;
        // } else if (Game.keys['down']) {
        //     this.vy = this.maxVel;
        // } else {
        //     this.vy = 0;
        // }

        this.x += this.vx * dt;
        // this.y += this.vy * dt;

        if (this.x < 0) {
            this.x = 0;
        } else if (this.x > Game.width - this.w) { 
            this.x = Game.width - this.w;
        }

        if (this.y < 0) {
            this.y = 0;
        } else if (this.y > Game.height - this.h) {
            this.y = Game.height - this.h;
        }
    };
};

PlayerShip.prototype = new Sprite();
PlayerShip.prototype.type = OBJECT_PLAYER;

PlayerShip.prototype.hit = function (damage) {
    if (invulnerability > 0) {
        return;
    }

    if (this.board.remove(this)) {
        this.board.add(new Explosion(this.x + this.w / 2, this.y + this.h / 2));

        if (--Game.shipCount === 0) {
            loseGame();
        }
    }
};

var StarPowerup = function () {
    this.setup('star_powerup', {
        vy: 75,
        maxVel: 500,
        y: 0
    });

    this.x = Math.floor(Math.random() * (Game.width - this.w)) + 0;

    this.step = function (dt) {
        this.y += this.vy * dt;

        var collision = this.board.collide(this, OBJECT_PLAYER);

        if (collision) {
            Game.points++;
            this.board.remove(this);
        } else if (this.y > Game.height) {
            this.board.remove(this);
        }

        if (Game.points === 15) {
            winGame();
        }
    }
}

StarPowerup.prototype = new Sprite();
StarPowerup.prototype.type = OBJECT_POWERUP;
