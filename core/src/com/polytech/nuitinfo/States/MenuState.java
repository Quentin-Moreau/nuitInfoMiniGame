package com.polytech.nuitinfo.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.miniMain;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class MenuState extends State{
    private Texture background;
    private Texture pb;
    private int score;
    private BitmapFont font;

    public MenuState(GameStateManager gsm, int score) {
        super(gsm);
        this.score = score;
        pb = new Texture("pb.png");
        cam.setToOrtho(false, miniMain.WIDTH, miniMain.HEIGHT);
        background = new Texture("menu.png");
        font = new BitmapFont();
        font.setColor(Color.WHITE);

    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()){
            gsm.set(new PlayState(gsm, 0, 150));
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
        sb.draw(this.pb, miniMain.WIDTH/2-100, miniMain.HEIGHT-miniMain.HEIGHT/4, 200, 100);
        font.draw(sb, "Barnabéus a trop bu... Aidez-le à rentrer chez lui !", 50, miniMain.HEIGHT/4);
        font.draw(sb, "Vous ne pouvez déplacer Barnabéus que trois fois.", 50, miniMain.HEIGHT/4-20);
        font.draw(sb, "Votre score: "+ score, miniMain.WIDTH/2-50, miniMain.HEIGHT/4-100);
        sb.end();
    }

    public void dispose(){
        background.dispose();
        font.dispose();
        pb.dispose();
    }
}
