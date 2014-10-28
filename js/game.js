'use strict';

var Q = new Quintus().include('Sprites, Scenes, Input, 2D, UI').setup();

Q.scene("testRoom", function (stage) {
 Q.stageTMX("test.tmx", stage)

});

Q.clearColor = '#000';

Q.loadTMX("test.tmx",
    Q.stageScene("testRoom")
);