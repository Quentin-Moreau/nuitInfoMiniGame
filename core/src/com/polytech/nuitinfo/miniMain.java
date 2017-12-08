package com.polytech.nuitinfo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.States.GameStateManager;
import com.polytech.nuitinfo.States.MenuState;
import com.polytech.nuitinfo.game.Plateau;

public class miniMain extends ApplicationAdapter {
    private Plateau plateau;
    public static final int WIDTH = 400;
    public static final int HEIGHT = 800;
    public static final String TITLE = "Game";

    private GameStateManager gsm;
    private SpriteBatch batch;

    @Override
    public void create () {
        gsm = new GameStateManager();
        batch = new SpriteBatch();
        gsm.push(new MenuState(gsm, 0));
        Gdx.gl.glClearColor(1, 0, 0, 1);

    }

    @Override
    public void render () {
        Gdx.gl.glClearColor(1, 0, 0, 1);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        gsm.update(Gdx.graphics.getDeltaTime());
        gsm.render(batch);


    }

    @Override
    public void dispose () {
        batch.dispose();
    }
}
