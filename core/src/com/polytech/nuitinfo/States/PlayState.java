package com.polytech.nuitinfo.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.game.Plateau;
import com.polytech.nuitinfo.game.Character;
import com.polytech.nuitinfo.game.Trait;
import com.polytech.nuitinfo.miniMain;
import com.polytech.nuitinfo.game.Intersection;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class PlayState extends State {
    private Plateau plateau;
    private int score;
    private Texture back;
    private Intersection intersectionCheck;
    private int dist;
    private Texture bottom;
    //private Character character;

    public PlayState(GameStateManager gsm, int score, int vitesse) {
        super(gsm);
        plateau = new Plateau(1, vitesse);
        back = new Texture("route.png");
        bottom = new Texture("bottom.png");
        this.score = score;
        //character = new Character(plateau.getFirstTrait(), "Carre", 50);
        cam.setToOrtho(false, miniMain.WIDTH, miniMain.HEIGHT);
        this.intersectionCheck = null;
        dist = 0;
    }

    @Override
    public void handleInput() {
        if (Gdx.input.justTouched()) {
            if (plateau.canAddIntersection()) {
                int x = Gdx.input.getX() * miniMain.WIDTH / Gdx.graphics.getWidth();
                int y = miniMain.HEIGHT - (Gdx.input.getY() * miniMain.HEIGHT / Gdx.graphics.getHeight());
                //System.out.println("" + x + ", " + y);
                plateau.addIntersection(x, y);
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        plateau.getSlowerCharacter().update(plateau, dt);
        //isTheEnd();
        Trait temp = plateau.checkFin();
        if(temp != null){
            if(plateau.checkWin(temp)) {
                gsm.set(new PlayState(gsm, score + 100, (int) plateau.getSlowerCharacter().getVitesse().y + 20));
                //reset();
            }else{
                gsm.set(new MenuState(gsm, score));
                dispose();
            }
            //gsm.set(new MenuState(gsm));
           // gsm.set(new MenuState(gsm));
        }
        if(plateau.checkEnemy()){
            gsm.set(new MenuState(gsm, score));
            dispose();
        }
        if(intersectionCheck == null) {
            intersectionCheck = plateau.checkIntersection();
        }else{
            if(dist == 0)
                dist = plateau.calculDist(intersectionCheck);
            if(plateau.travelIntersection(intersectionCheck, dist)){
                plateau.resetMove();
                intersectionCheck = null;
                dist = 0;
            }
        }
            //intersectionCheck = plateau.checkIntersection();

    }

    public void dispose(){
        back.dispose();
        bottom.dispose();
    }


    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        int pos = 0;
        int size =  plateau.getListeTraits().size();
        for(int i = 0; i <= size; i++){
            sb.draw(back, pos, 0, miniMain.WIDTH/(size+1), miniMain.HEIGHT);
            pos += 100;
        }
        sb.draw(bottom, 0, 0, miniMain.WIDTH, miniMain.HEIGHT-plateau.getListeTraits().get(0).LONGUEUR);
        //sb.draw(back, 0, 0, miniMain.WIDTH, miniMain.HEIGHT);
        sb.end();
        plateau.render(sb);
        plateau.getSlowerCharacter().render(sb);

    }
}
