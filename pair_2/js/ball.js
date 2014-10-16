window.addEventListener('load', function () {

    var Q = window.Q = Quintus()
        .include('Sprites, Scenes')
        .setup({ width: 960, height: 640 });

    Q.MovingSprite.extend('Ball', {
        draw: function (ctx) {
            ctx.fillStyle = 'black';
            ctx.beginPath();
            ctx.arc(-this.p.cx, -this.p.cy, this.p.w / 2, 0, Math.PI * 2); 
            ctx.fill();
        }
    });

    Q.scene('main', function (stage) {
        var ball = stage.insert(new Q.Ball({ w: 20, h: 20, x: 30, y: 300, vx: 30, vy: -100, ax: 0, ay: 30 }));
        var ballTwo = stage.insert(new Q.Ball({ w: 30, h: 30, x: 100, y: 300, vx: 40, vy: -100, ax: 0, ay: 30 }));
        var ballThree = stage.insert(new Q.Ball({ w: 40, h: 40, x: 200, y: 300, vx: 50, vy: -100, ax: 0, ay: 30 }));

        var entities = [ball, ballTwo, ballThree];
    });

    Q.clearColor = 'green';

    Q.stageScene('main', 0);
});
