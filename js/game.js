'use strict';

var Q = new Quintus().include('Sprites, Scenes, Input, Touch, 2D, UI').setup({
    maximize: true
}).touch();

var Level = function () {
    this.generate = function (width, height, start, end) {
        var TILES = Object.freeze({
            AIR: 0,
            BLOCK: 1
        });

        var map = [];

        var start = start || {
            x: 0,
            y: height - 2
        };

        var end = end || {};

        for (var row = 0; row < height; row++) {
            map[row] = [];

            for (var col = 0; col < width; col++) {
                if (col === start.x && row === start.y) {
                    map[row][col] = TILES.AIR;
                    continue;
                }

                if (row < (height - 1)) {
                    map[row][col] = Math.random() < 0.2 ? TILES.BLOCK : TILES.AIR;
                    continue;
                }

                map[row][col] = TILES.BLOCK;
            }
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
};

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
        Q.stageScene('game');
    }));
});

Q.scene('game', function (stage) {
    var l = new Level();

    var map = l.generate(30, 20);

    Q.scene('testLevel', function (stage) {
        stage.collisionLayer(new Q.TileLayer({
            tiles: map,
            sheet: 'tiles'
        }));
    });

    Q.stageScene('testLevel');
});

Q.clearColor = '#000';

Q.load('tiles.png', function () {
    Q.sheet('tiles', 'tiles.png', {
        tilew: 32,
        tileh: 32
    });

    Q.stageScene('game', 0);
});