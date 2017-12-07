package com.polytech.nuitinfo.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.miniMain;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class PlayState extends State {
    private Texture character;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        character = new Texture("character.png");
        cam.setToOrtho(false, miniMain.WIDTH, miniMain.HEIGHT);
    }

    @Override
    protected void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(character, 50, 50, 50, 50);
        sb.end();
    }
}
