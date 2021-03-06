'use strict';

$(function () {
    var Q = window.Q = new Quintus({
        audioSupported: ['ogg']
    }).include('Input, Sprites, Scenes, UI, Touch, Audio').setup().touch().enableSound();;

    Q.input.keyboardControls();
    Q.input.touchControls({
        controls: [
            ['left', '<'],
            [],
            [],
            [],
            ['right', '>']
        ]
    });

    var lives = 3;
    var score = 0;

    Q.UI.Text.extend('Score', {
        init: function (p) {
            this._super({
                label: 'Score: 0',
                align: 'left',
                x: 50,
                y: Q.height - 10,
                weight: 'normal',
                color: 'white',
                size: 15
            });

            Q.state.on('change.score', this, 'score');
        },
        score: function (score) {
            this.p.label = 'Score: ' + score;
        }
    });

    Q.UI.Text.extend('Lives', {
        init: function (p) {
            this._super({
                label: 'Lives: 3',
                align: 'right',
                x: Q.width - 40,
                y: Q.height - 10,
                weight: 'normal',
                color: 'white',
                size: 15
            });

            Q.state.on('change.lives', this, 'lives');
        },
        lives: function (lives) {
            this.p.label = 'Lives: ' + lives;
        }
    });

    Q.Sprite.extend('Paddle', {
        init: function (p) {
            this._super(p, {
                sheet: 'paddle',
                speed: 200,
                x: 0,
            });

            this.p.x = Q.width / 2 - this.p.w / 2;
            this.p.y = Q.height - this.p.h;

            if (Q.input.keypad.size) {
                this.p.y -= Q.input.keypad.size + this.p.h;
            }
        },
        step: function (dt) {
            if (Q.inputs.left) {
                this.p.x -= dt * this.p.speed;
            } else if (Q.inputs.right) {
                this.p.x += dt * this.p.speed;
            }

            if (this.p.x < this.p.w / 2) {
                this.p.x = this.p.w / 2;
            } else if (this.p.x > Q.width - this.p.w / 2) {
                this.p.x = Q.width - this.p.w / 2;
            }
        }
    });

    Q.Sprite.extend('Ball', {
        init: function () {
            this._super({
                sheet: 'ball',
                speed: 200,
                dx: Math.random() < 0.5 ? 1 : -1,
                dy: -1,
            });

            this.p.y = Q.height / 2 - this.p.h;
            this.p.x = Q.width / 2 + this.p.w / 2;

            this.on('hit', this, 'collision');

            this.on('step', function (dt) {
                var p = this.p;

                Q.stage().collide(this);

                p.x += p.dx * p.speed * dt;
                p.y += p.dy * p.speed * dt;

                if (p.x < 0) {
                    Q.audio.play('hit-wall.ogg');

                    p.x = 0;
                    p.dx = 1;
                } else if (p.x > Q.width) {
                    Q.audio.play('hit-wall.ogg');

                    p.dx = -1;
                    p.x = Q.width;
                }

                if (p.y < 0) {
                    Q.audio.play('hit-wall.ogg');

                    p.y = 0;
                    p.dy = 1;
                } else if (p.y > Q.height) {
                    Q.state.set('lives', --lives);

                    if (lives > 0) {
                        Q.audio.play('lose-life.ogg');

                        this.p.y = Q.height / 2 - this.p.h;
                        this.p.x = Q.width / 2 + this.p.w / 2;
                        this.p.dx = Math.random() < 0.5 ? 1 : -1;
                        this.p.dy = -1;
                    } else {
                        Q.stageScene('lose');
                    }
                }
            });
        },
        collision: function (col) {
            if (col.obj.isA('Paddle')) {
                Q.audio.play('hit-paddle.ogg');

                this.p.dy = -1;
            } else if (col.obj.isA('Block')) {
                Q.audio.play('hit-block.ogg');

                Q.state.set('score', score += col.obj.points);

                col.obj.destroy();
                this.p.dy *= -1;
                Q.stage().trigger('removeBlock');
            }
        }
    });

    Q.Sprite.extend('Block', {
        init: function (props) {
            this._super(_(props).extend({
                sheet: 'block'
            }));

            this.points = 1;

            this.on('collision', function (ball) {
                this.destroy();
                ball.p.dy *= -1;
                Q.stage().trigger('removeBlock');
            });
        }
    });

    Q.load(['blockbreak.png', 'blockbreak.json', 'hit-block.ogg', 'hit-wall.ogg', 'hit-paddle.ogg', 'lose-life.ogg', 'lose.ogg', 'win.ogg'], function () {
        Q.load(['blockbreak.png'], function () {
            Q.compileSheets('blockbreak.png', 'blockbreak.json');

            Q.sheet('ball', 'blockbreak.png', {
                tilew: 20,
                tileh: 20,
                sy: 0,
                sx: 0
            });

            Q.sheet('block', 'blockbreak.png', {
                tilew: 40,
                tileh: 20,
                sy: 20,
                sx: 0
            });

            Q.sheet('paddle', 'blockbreak.png', {
                tilew: 60,
                tileh: 20,
                sy: 40,
                sx: 0
            });

            Q.scene('game', new Q.Scene(function (stage) {
                lives = 3;
                score = 0;

                Q.stageScene('hud', 1);

                stage.insert(new Q.Paddle());
                stage.insert(new Q.Ball());

                var blockCount = 0;

                for (var x = 0; x < 6; x++) {
                    for (var y = 0; y < 5; y++) {
                        stage.insert(new Q.Block({
                            x: x * 50 + 35,
                            y: y * 30 + 15
                        }));
                        blockCount++;
                    }
                }

                stage.on('removeBlock', function () {
                    blockCount--;

                    if (blockCount === 0) {
                        Q.stageScene('win');
                    }
                });
            }));

            Q.scene('hud', function (stage) {
                stage.insert(new Q.Score());
                stage.insert(new Q.Lives());
            }, {
                stage: 1
            });

            Q.scene('title', new Q.Scene(function (stage) {
                var container = stage.insert(new Q.UI.Container({
                    x: Q.width / 2,
                    y: Q.height / 2.5,
                    fill: '#333'
                }));

                container.insert(new Q.UI.Text({
                    label: 'Block Break',
                    color: '#fff',
                    x: 0,
                    y: 0
                }));

                container.insert(new Q.UI.Button({
                    label: 'Play',
                    fill: '#fff',
                    x: 0,
                    y: 50,
                    w: 150
                }, function () {
                    Q.stageScene('game');
                }));

                container.insert(new Q.UI.Text({
                    label: 'Use arrow keys to move paddle',
                    color: '#fff',
                    x: 0,
                    y: 100,
                    size: 15
                }));

                container.fit(20);
            }));

            Q.scene('win', new Q.Scene(function (stage) {
                Q.audio.play('win.ogg');

                var container = stage.insert(new Q.UI.Container({
                    x: Q.width / 2,
                    y: Q.height / 2.5,
                    fill: '#333'
                }));

                container.insert(new Q.UI.Text({
                    label: 'You Win!',
                    color: '#fff',
                    x: 0,
                    y: 0
                }));

                container.insert(new Q.UI.Button({
                    label: 'Play Again',
                    fill: '#fff',
                    x: 0,
                    y: 50,
                    w: 150
                }, function () {
                    Q.stageScene('game');
                }));

                container.fit(20);
            }));

            Q.scene('lose', new Q.Scene(function (stage) {
                Q.audio.play('lose.ogg');

                var container = stage.insert(new Q.UI.Container({
                    x: Q.width / 2,
                    y: Q.height / 2.5,
                    fill: '#333'
                }));

                container.insert(new Q.UI.Text({
                    label: 'You Lose!',
                    color: '#fff',
                    x: 0,
                    y: 0
                }));

                container.insert(new Q.UI.Button({
                    label: 'Play Again',
                    fill: '#fff',
                    x: 0,
                    y: 50,
                    w: 150
                }, function () {
                    Q.stageScene('game');
                }));

                container.fit(20);
            }));

            Q.stageScene('title');
        });
    });
});