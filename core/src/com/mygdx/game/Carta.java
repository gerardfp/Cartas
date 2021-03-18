package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.utils.Align;

public class Carta extends Actor {

    Animation<TextureRegion> animation;
    float stateTime = 0;
    int player;

    Carta(int player, String card, float x, float y, GameMaster.GameMasterListener gameMasterListener){
        this.player = player;
        setSize(24*2,32*2);
        setOrigin(Align.center);
        setPosition(x, y);

        animation = Assets.getAnimation(card, 0.1f, Animation.PlayMode.NORMAL);

        addListener(new InputListener(){
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                gameMasterListener.touched(Carta.this);
                return false;
            }
        });
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        stateTime += delta;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(animation.getKeyFrame(stateTime), getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(), getRotation());
    }

    public void mueve(){
        addAction(
            Actions.sequence(
                Actions.parallel(
                        Actions.moveBy(80, 60, 4, Interpolation.elasticOut)
                )
            )
        );
    }
}