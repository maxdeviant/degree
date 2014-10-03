'use strict';

var canvas = document.getElementById('game');
var ctx = canvas.getContext('2d');

var STATES = Object.freeze({
    MENU: 'menuState',
    GAME: 'gameState',
    WIN: 'winState'
});

var currentState = STATES.MENU;

var KEYS = Object.freeze({
    13: 'ENTER',
    37: 'L_ARR',
    39: 'R_ARR',
    65: 'A',
    68: 'D'
});

var pressed = {};

window.addEventListener('keydown', function (e) {
    if (KEYS[e.keyCode]) {
        e.preventDefault();
        pressed[KEYS[e.keyCode]] = true;
    }
}, false);

window.addEventListener('keyup', function (e) {
    if (KEYS[e.keyCode]) {
        e.preventDefault();
        pressed[KEYS[e.keyCode]] = false;
    }
}, false);

var Menu = function () {
    this.init = function () {

    };

    this.step = function () {
        if (pressed.ENTER) {
            reset();
        }
    };

    this.draw = function () {
        if (currentState === STATES.MENU) {
            ctx.save();

            ctx.font = 'bold 40px arial';
            ctx.fillStyle = '#fff';
            ctx.textAlign = 'center';

            ctx.fillText('PONG', canvas.width / 2, canvas.height / 2);

            ctx.font = 'bold 18px arial';

            ctx.fillText('Press ENTER to play', canvas.width / 2, canvas.height / 2 + 40);

            ctx.restore();
        } else if (currentState === STATES.WIN) {
            ctx.save();

            ctx.font = 'bold 40px arial';
            ctx.fillStyle = '#fff';
            ctx.textAlign = 'center';

            var winText = (playerOne.score > playerTwo.score ? 'P1' : 'P2') + ' WINS!';

            ctx.fillText(winText, canvas.width / 2, canvas.height / 2);

            ctx.font = 'bold 18px arial';

            ctx.fillText('Press ENTER to restart', canvas.width / 2, canvas.height / 2 + 40);

            ctx.restore();
        }
    };
};

var Player = function (x, y, CONTROLS) {
    this.init = function (x, y) {
        this.width = 100;
        this.height = 20;
        this.x = x || canvas.width / 2 - this.width / 2;
        this.y = y || 10;
        this.speed = 10;
        this.score = 0;
    };

    this.step = function (dt) {
        if (pressed[CONTROLS.LEFT]) {
            this.vx = -this.speed;
        } else if (pressed[CONTROLS.RIGHT]) {
            this.vx = this.speed;
        } else {
            this.vx = 0;
        }

        this.x += this.vx;

        if (this.x < 0) {
            this.x = 0;
        } else if (this.x > canvas.width - this.width) { 
            this.x = canvas.width - this.width;
        }
    };

    this.draw = function () {
        ctx.fillStyle = '#fff';
        ctx.fillRect(this.x, this.y, this.width, this.height);
    };

    this.init(x, y);
};

var Ball = function () {
    this.init = function () {
        this.width = this.height = 10;
        this.x = canvas.width / 2;
        this.y = canvas.height / 2;
        this.speed = 5;

        this.vx = 0;
        this.vy = this.speed * (Math.round(Math.random()) * 2 - 1); 
    };

    this.step = function () {
        if (this.collide()) {
            this.vx = 8 * (Math.round(Math.random()) * 2 - 1);
            this.vy = -this.vy;
        }

        this.x += this.vx;
        this.y += this.vy;

        if (this.x < 0) {
            this.x = 0;
            this.vx = -this.vx;
        } else if (this.x > canvas.width - this.width) {
            this.x = canvas.width - this.width;
            this.vx = -this.vx;
        }

        if (this.y < 0) {
            playerOne.score++;

            this.init();
        } else if (this.y > canvas.height - this.height) {
            playerTwo.score++;

            this.init();
        }
    };

    this.draw = function () {
        ctx.fillStyle = '#f00';
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.width, 0, 2 * Math.PI, false);
        ctx.fill();
    };

    this.collide = function () {
        var collidePlayerOne = this.y > playerOne.y - this.height && (this.x > playerOne.x && this.x < playerOne.x + playerOne.width);
        var collidePlayerTwo = this.y - this.height < playerTwo.y + playerTwo.height && (this.x > playerTwo.x && this.x < playerTwo.x + playerTwo.width);

        return collidePlayerOne || collidePlayerTwo;
    };

    this.init();
};

var CONTROLS = Object.freeze({
    PLAYER_ONE: {
        LEFT: 'A',
        RIGHT: 'D'
    },
    PLAYER_TWO: {
        LEFT: 'L_ARR',
        RIGHT: 'R_ARR'
    }
});

var entities = [];

var playerOne,
    playerTwo,
    ball;

var init = function () {
    entities.push(new Menu());
};

var reset = function () {
    currentState = STATES.GAME;

    entities = [];

    playerOne = new Player(null, canvas.height - 30, CONTROLS.PLAYER_ONE);
    playerTwo = new Player(null, 10, CONTROLS.PLAYER_TWO);
    ball = new Ball();

    entities.push(playerOne);
    entities.push(playerTwo);
    entities.push(ball);
};

var update = function (dt) {
    for (var i in entities) {
        entities[i].step(dt);
        entities[i].draw();
    }

    if (currentState === STATES.GAME) {
        checkWin();

        ctx.font = 'bold 18px arial';
        ctx.fillStyle = '#fff';
        ctx.fillText('P1: ' + playerOne.score, 20, canvas.height / 2);
        ctx.fillText('P2: ' + playerTwo.score, canvas.width - 60, canvas.height / 2);   
    }
};

var loop = function () {
    var now = Date.now();
    var delta = now - then;

    ctx.clearRect(0, 0, canvas.width, canvas.height);

    update(delta / 1000);

    requestAnimationFrame(loop);
};

var checkWin = function () {
    if (playerOne.score > 9 || playerTwo.score > 9) {
        currentState = STATES.WIN;

        entities = [new Menu()];
    }
};

var then = Date.now();

var requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame || window.mozRequestAnimationFrame;

init();
loop();