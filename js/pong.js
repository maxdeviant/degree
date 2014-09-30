'use strict';

var canvas = document.getElementById('game');
var ctx = canvas.getContext('2d');

var STATES = Object.freeze({
    MENU: 'menuState',
    WIN: 'winState'
});

var currentState = STATES.MENU;

var KEYS = Object.freeze({
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

var update = function (dt) {

};

var loop = function () {
    var now = Date.now();
    var delta = now - then;

    update(delta / 1000);

    requestAnimationFrame(loop);
};

var then = Date.now();

var requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame || window.mozRequestAnimationFrame;

loop();