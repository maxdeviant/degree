'use strict';

// Initialize canvas
var canvas = document.getElementById('game');
var ctx = canvas.getContext('2d');

// Initialize game states
var STATES = Object.freeze({
    MENU: 1,
    CONTROLS: 2,
    GAME: 4,
    WIN: 8
});

// Set the current state to the menu
var currentState = STATES.MENU;

// Initialize game keys
var KEYS = Object.freeze({
    13: 'ENTER',
    27: 'ESCAPE',
    32: 'SPACEBAR',
    37: 'L_ARR',
    39: 'R_ARR',
    65: 'A',
    68: 'D'
});

var pressed = {};

// Add input listeners
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

// Initialize difficulty step
var incDifficulty = 0.5;

// Menu object
var Menu = function () {
    this.init = function () {};

    this.step = function () {
        // If enter key is pressed
        if (pressed.ENTER) {
            // Reset the game (start)
            reset();
        } else if (pressed.SPACEBAR) { // If spacebar is pressed
            // Switch to the controls state
            currentState = STATES.CONTROLS;
        } else if (pressed.ESCAPE) { // If escape key is pressed
            // Switch to the menu state
            currentState = STATES.MENU;
        }
    };

    this.draw = function () {
        // If in the menu state
        if (currentState & STATES.MENU) {
            ctx.save();

            ctx.font = 'bold 40px arial';
            ctx.fillStyle = '#fff';
            ctx.textAlign = 'center';

            // Draw the title screen
            ctx.fillText('PONG', canvas.width / 2, canvas.height / 2);

            ctx.font = 'bold 18px arial';

            ctx.fillText('Press ENTER to play', canvas.width / 2, canvas.height / 2 + 40);

            ctx.fillText('Press SPACE to view controls', canvas.width / 2, canvas.height / 2 + 80);

            ctx.restore();
        } else if (currentState & STATES.CONTROLS) {
            ctx.save();

            ctx.font = 'bold 36px arial';
            ctx.fillStyle = '#fff';
            ctx.textAlign = 'center';
            ctx.fillText('CONTROLS', canvas.width / 2, 40);


            ctx.font = 'bold 18px arial';
            ctx.textAlign = 'left';

            ctx.fillText('P1: ', canvas.width / 4, 100);
            ctx.fillText('LEFT: A', canvas.width / 3, 100);
            ctx.fillText('RIGHT: D', canvas.width / 3, 120);

            ctx.fillText('P2: ', canvas.width / 4, 160);
            ctx.fillText('LEFT: LEFT ARROW', canvas.width / 3, 160);
            ctx.fillText('RIGHT: RIGHT ARROW', canvas.width / 3, 180);

            ctx.textAlign = 'center';

            ctx.fillText('Press ESCAPE to close.', canvas.width / 2, canvas.height - 40);

            ctx.restore();
        } else if (currentState & STATES.WIN) { // If in the win state
            ctx.save();

            ctx.font = 'bold 40px arial';
            ctx.fillStyle = '#fff';
            ctx.textAlign = 'center';

            // Generate win text
            var winText = (playerOne.score > playerTwo.score ? 'P1' : 'P2') + ' WINS!';

            // Draw the win screen
            ctx.fillText(winText, canvas.width / 2, canvas.height / 2);

            ctx.font = 'bold 18px arial';

            ctx.fillText('Press ENTER to restart', canvas.width / 2, canvas.height / 2 + 40);

            ctx.restore();
        }
    };

    // Initialize Menu
    this.init();
};

// Player object
var Player = function (x, y, CONTROLS) {
    this.init = function (x, y) {
        this.width = 100;
        this.height = 5;
        this.x = x || canvas.width / 2 - this.width / 2;
        this.y = y || 10;
        this.speed = 10;
        this.score = 0;
    };

    this.step = function (dt) {
        // If left button is pressed
        if (pressed[CONTROLS.LEFT]) {
            // Move the paddle left
            this.vx = -this.speed;
        } else if (pressed[CONTROLS.RIGHT]) { // If the right button is pressed
            // Move the paddle right
            this.vx = this.speed;
        } else { // If neither is pressed
            // Stop X velocity
            this.vx = 0;
        }

        // Move in X direction
        this.x += this.vx;

        // If at the left wall
        if (this.x < 0) {
            // Adjust position
            this.x = 0;
        } else if (this.x > canvas.width - this.width) { // If at the right wall
            // Adjust position
            this.x = canvas.width - this.width;
        }
    };

    this.draw = function () {
        ctx.fillStyle = '#fff';
        ctx.fillRect(this.x, this.y, this.width, this.height);
    };

    // Initialize Player
    this.init(x, y);
};

var Ball = function (color, direction) {
    this.init = function () {
        this.width = this.height = 7;
        this.x = canvas.width / 2;
        this.y = canvas.height / 2;
        this.color = color;
        this.speed = 4;
        this.difficulty = 1;

        this.vx = 0;
        this.vy = this.speed * direction || (Math.round(Math.random()) * 2 - 1);
    };

    this.step = function () {
        // If collided with player
        if (this.collide()) {
            // Adjust horizontal velocity
            this.vx = this.difficulty * (Math.round(Math.random()) * 2 - 1);

            // Reverse direction of the ball
            this.vy = -this.vy;

            // Increase ball's difficulty modifier
            this.difficulty += incDifficulty;
        }

        // Move in X and Y directions
        this.x += this.vx;
        this.y += this.vy;

        // If hit the left wall
        if (this.x < 0) {
            // Adjust position
            this.x = 0;

            // Reverse X direction
            this.vx = -this.vx;
        } else if (this.x > canvas.width - this.width) { // If hit the right wall
            // Adjust position
            this.x = canvas.width - this.width;

            // Reverse X direction
            this.vx = -this.vx;
        }

        // If player one score
        if (this.y < 0 - this.height) {
            // Increment player one's score
            playerOne.score++;

            // Halve the difficulty
            this.difficulty = this.difficulty / 2 > 1 ? this.difficulty / 2 : 1;

            // Reinitialize the ball
            this.init();
        } else if (this.y > canvas.height) { // If player two score
            // Increment player two's score
            playerTwo.score++;

            // Halve the difficulty
            this.difficulty = this.difficulty / 2 > 1 ? this.difficulty / 2 : 1;

            // Reinitialize the ball
            this.init();
        }
    };

    this.draw = function () {
        ctx.save();

        ctx.fillStyle = this.color || '#fff';
        ctx.beginPath();
        ctx.arc(this.x, this.y, this.width, 0, 2 * Math.PI, false);
        ctx.fill();

        ctx.restore();
    };

    // Checks for collision with player
    this.collide = function () {
        var collidePlayerOne = this.y > playerOne.y - this.height && (this.x > playerOne.x && this.x < playerOne.x + playerOne.width);
        var collidePlayerTwo = this.y - this.height < playerTwo.y + playerTwo.height && (this.x > playerTwo.x && this.x < playerTwo.x + playerTwo.width);

        // If collided with player one or two
        return collidePlayerOne || collidePlayerTwo;
    };

    // Initialize Ball
    this.init();
};

// Initialize control mappings
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

// Initialize directions
var DIRECTION = Object.freeze({
    UP: 1,
    DOWN: -1
});

var entities = [];

var playerOne, playerTwo, ball, ballTwo;

// Initialize the game
var init = function () {
    // Add the menu to the entities list
    entities.push(new Menu());

    // Run the game loop
    loop();
};

// Reset the game to defaults
var reset = function () {
    // Switch to the game state
    currentState = STATES.GAME;

    // Clear all entities
    entities = [];

    // Reset the players
    playerOne = new Player(null, canvas.height - 12, CONTROLS.PLAYER_ONE);
    playerTwo = new Player(null, 8, CONTROLS.PLAYER_TWO);

    // Reset the balls
    ball = new Ball('#f00', DIRECTION.UP);
    ballTwo = new Ball('#00f', DIRECTION.DOWN);

    // Add the entities to the list
    entities.push(playerOne);
    entities.push(playerTwo);
    entities.push(ball);
    entities.push(ballTwo);
};

// Game logic
var update = function (dt) {
    // Iterate over entities
    for (var i in entities) {
        // Perform step
        entities[i].step(dt);

        // Perform draw
        entities[i].draw();
    }

    // If in the game state
    if (currentState & STATES.GAME) {
        // Check for a win
        checkWin();

        // Draw the scoreboard
        ctx.font = 'bold 18px arial';
        ctx.fillStyle = '#fff';
        ctx.fillText('P1: ' + playerOne.score, 20, canvas.height / 2);
        ctx.fillText('P2: ' + playerTwo.score, canvas.width - 60, canvas.height / 2);
    }
};

// Game loop
var loop = function () {
    // Calculate time delta
    var now = Date.now();
    var delta = now - then;

    // Clear the screen
    ctx.clearRect(0, 0, canvas.width, canvas.height);

    // Call update function
    update(delta / 1000);

    // Call animations
    requestAnimationFrame(loop);
};

// Check if a player has won the game
var checkWin = function () {
    // If either player's score is 10
    if (playerOne.score > 9 || playerTwo.score > 9) {
        // Switch to the win state
        currentState = STATES.WIN;

        // Add the menu to the entities list
        entities = [new Menu()];
    }
};

var then = Date.now();

// Handle multiple browsers
var requestAnimationFrame = window.requestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame || window.mozRequestAnimationFrame;

// Initialize the game
init();