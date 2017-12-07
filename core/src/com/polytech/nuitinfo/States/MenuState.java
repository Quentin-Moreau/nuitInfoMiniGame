package com.polytech.nuitinfo.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.miniMain;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class MenuState extends State{
    private Texture background;
    private Texture pb;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        pb = new Texture("pb.png");
        cam.setToOrtho(false, miniMain.WIDTH, miniMain.HEIGHT);
        background = new Texture("background.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm));
            dispose();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(this.background, 0, 0, miniMain.WIDTH, miniMain.HEIGHT);
        sb.draw(this.pb, miniMain.WIDTH/2-50, miniMain.HEIGHT/2-50, 100, 100);
        sb.end();
    }

    public void dispose(){
        background.dispose();
        pb.dispose();
    }
}
