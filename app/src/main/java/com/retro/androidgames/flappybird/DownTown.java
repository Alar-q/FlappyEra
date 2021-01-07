package com.retro.androidgames.flappybird;

import com.retro.androidgames.framework.gamedev.DynamicGameObject;
import com.retro.androidgames.framework.impl.GLGraphics;
import com.retro.androidgames.opengl.SpriteBatcher;

public class DownTown {
    static float WORLD_WIDTH = GameScreen.WORLD_WIDTH;
    static float WORLD_HEIGHT = GameScreen.WORLD_HEIGHT;


    static DynamicGameObject bc1;
    static DynamicGameObject bc2;

    static final float BACKGROUND_VELOCITY = -4.5f;

    public static void load(GLGraphics glGraphics){

        bc1 = new DynamicGameObject(0,0, WORLD_WIDTH, 2);
        bc1.velocity.set(BACKGROUND_VELOCITY, 0);

        bc2 = new DynamicGameObject(WORLD_WIDTH, 0, WORLD_WIDTH, 2);
        bc2.velocity.set(BACKGROUND_VELOCITY, 0);
        //bird.state = Bird.BIRD_FALL;
    }

    public static void update(float deltaTime){

        bc1.position.add(bc1.velocity.x*deltaTime, 0);
        if(bc1.position.x < 0-WORLD_WIDTH/2){
            bc1.position.x = 1.5f * WORLD_WIDTH;
        }

        bc2.position.add(bc2.velocity.x*deltaTime, 0);
        if(bc2.position.x < 0-WORLD_WIDTH/2){
            bc2.position.x = 1.5f * WORLD_WIDTH;
        }
    }

    public static void present(SpriteBatcher batcher){
        batcher.drawSprite(bc2.position.x, bc2.position.y, WORLD_WIDTH+0.2f,2, Assets.down);
        batcher.drawSprite(bc1.position.x, bc1.position.y, WORLD_WIDTH, 2, Assets.down);
    }
}
