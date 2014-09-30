'use strict';

var canvas = document.getElementById('game');
var ctx = canvas.getContext('2d');

var STATES = Object.freeze({
    MENU: 'menuState',
    WIN: 'winState'
});

var KEYS = Object.freeze({
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

var Player = function (x, y, CONTROLS) {
    this.width = 100;
    this.height = 20;
    this.x = x || canvas.width / 2 - this.width / 2;
    this.y = y || 10;
    this.speed = 10;

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
};

var Ball = function () {
    this.x = canvas.width / 2;
    this.y = canvas.height / 2;
    this.speed = 5;

    this.step = function () {
        if (typeof this.vy === 'undefined') {
            this.vy = this.speed * (Math.round(Math.random()) * 2 - 1); 
        }

        this.y += this.vy;
    };

    this.draw = function () {
        ctx.fillStyle = '#fff';
        ctx.beginPath();
        ctx.arc(this.x, this.y, 5, 0, 2 * Math.PI, false);
        ctx.fill();
    };
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

var init = function () {
    var currentState = STATES.MENU;

    var playerOne = new Player(null, canvas.height - 30, CONTROLS.PLAYER_ONE);
    var playerTwo = new Player(null, 10, CONTROLS.PLAYER_TWO);

    var ball = new Ball();

    entities.push(playerOne);
    entities.push(playerTwo);
    entities.push(ball);
};

var update = function (dt) {
    for (var i in entities) {
        entities[i].step(dt);
        entities[i].draw();
    }
};

var loop = function () {
    var now = Date.now();
    var delta = now - then;

    ctx.clearRect(0, 0, canvas.width, canvas.height);

    update(delta / 1000);

    requestAnimationFrame(loop);
};

var then = Date.now();

var requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame || window.mozRequestAnimationFrame;

init();
loop();