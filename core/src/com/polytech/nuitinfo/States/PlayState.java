package com.polytech.nuitinfo.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.game.Plateau;
import com.polytech.nuitinfo.game.Character;
import com.polytech.nuitinfo.game.Trait;
import com.polytech.nuitinfo.miniMain;
import com.polytech.nuitinfo.game.Character;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class PlayState extends State {
    private Plateau plateau;
    private Character character;

    protected PlayState(GameStateManager gsm) {
        super(gsm);
        plateau = new Plateau(1);
        character = new Character(plateau.getFirstTrait(), "Carre", 15);
        cam.setToOrtho(false, miniMain.WIDTH, miniMain.HEIGHT);
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched()){
            plateau.addIntersection(Gdx.input.getY());
        }
    }

    @Override
    public void update(float dt) {
        character.update(plateau, dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        plateau.render(sb);
        character.render(sb);

    }

    private boolean isTheEnd(Plateau plateau){
        if(plateau.getSlowerCharacter().getPosition() == Trait.LONGUEUR){
            gsm.set(new MenuState(gsm));
            return true;
        }
        return false;
    }

    public boolean doIWin(){
        if(isTheEnd(plateau)){

        }
        return false;
    }
}
