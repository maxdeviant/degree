window.addEventListener("load",function() {

        var Q = window.Q = Quintus()
        .include("Sprites, Scenes, Input, 2D, Anim, Touch, UI, TMX")
        
        .setup({ maximize: true })
        
        .controls().touch()

        Q.Sprite.extend("Player",
        {
            init: function(properties)
            {
                this._super(properties, [
                    sheet: "sprites_wallace_.png",
                    jumpSpeed: -400,
                    speed: 300,
                    type: Q.SPRITE_PLAYER,
                    ]);
                this.add('2d, platformerControls, animation, tween');

                this.on("jump");
                this.on('jumped');

                jump: function(obj) {
                    if (!obj.properties.playedJump) {
                        obj.properties.playedJump = true;
                    }
                },

                jumped: function(obj) {
                    obj.properties.playedJump = false;
                },

                continueOverSensor: function(){
                    this.properties.vy = 0;
                    if (this.properties.vx != 0) {
                        this.play("walk_" + this.properties.direction);
                    }
                },

                if(!processed){
                    this.properties.gravity = 1;
                    if(this.properties.vx > 0) {
                        if(this.properties.landed > 0){
                            this.play("walk_right");
                        } else {
                            this.play("jump_right");
                        }
                        this.properties.direction = "right";
                    } else if(this.properties.vx < 0) {
                        if(this.properties.landed > 0) {
                            this.play("walk_left");
                        } else {
                            this.play("jump_left");
                        }
                        this.properties.direction = "left";
                    } else {
                        this.play("stand_" + this.properties.direction);
                    }
                }

            });
// ## Create test scene

Q.scene("levelTest",function(stage) {
    Q.stageTMX("test.tmx",stage);
    stage.add("viewport").follow(Q("Player").first());

});



// Load test scene and assets
Q.loadTMX("test.tmx", function() {
    Q.stageScene("levelTest");
    Q.animations("player", {
      walk_right: { frames: [0,1,2,3,4,5,6,7,8,9,10], rate: 1/15, flip: false, loop: true },
      walk_left: { frames:  [0,1,2,3,4,5,6,7,8,9,10], rate: 1/15, flip:"x", loop: true },
      jump_right: { frames: [13], rate: 1/10, flip: false },
      jump_left: { frames:  [13], rate: 1/10, flip: "x" },
      stand_right: { frames:[14], rate: 1/10, flip: false },
      stand_left: { frames: [14], rate: 1/10, flip:"x" },
    });
});

});