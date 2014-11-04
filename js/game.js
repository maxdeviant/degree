'use strict';

var Q = new Quintus().include('Sprites, Scenes, Input, Touch, 2D, UI').setup().touch();

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

});

Q.clearColor = '#000';

Q.stageScene('menu', 0);