'use strict';

var Q = new Quintus().include('Sprites, Scenes, Input, 2D, UI').setup();

Q.scene('menu', function (stage) {
    var container = stage.insert(new Q.UI.Container({
        x: Q.width / 2,
        y: Q.height / 4,
        fill: '#000'
    }));

    stage.insert(new Q.UI.Text({
        label: 'Project Two',
        color: '#fff',
        x: 0,
        y: 0
    }), container);

    stage.insert(new Q.UI.Button({
        label: 'Start',
        fill: '#fff',
        x: 0,
        y: 70,
        w: 100
    }), container);
});

Q.clearColor = '#000';

Q.stageScene('menu', 0);