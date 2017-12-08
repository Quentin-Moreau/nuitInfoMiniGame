package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.miniMain;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

class Trait {
    public static final int LONGUEUR = miniMain.HEIGHT;
    private int positionX;
    private Texture texture;

    public Trait(int positionX){
        this.positionX = positionX;
        texture = new Texture("background.png");
    }

    public ArrayList<Intersection> getListeIntersectionsAPartirDe(Plateau plateau, int positionFrom){
        //for ()
        ArrayList<Intersection> fullList = plateau.getListeIntersections();
        ArrayList<Intersection> sortedList = new ArrayList<Intersection>();
        if(fullList.size() > 0){
            for(Intersection i: fullList){
                if(i.getPosition() < positionFrom && i.getTrait1().equals(this) || i.getTrait2().equals(this)){
                    sortedList.add(i);
                }
            }
        }
        return sortedList;
    }

    public int getPositionX(){return positionX;}

    public boolean equals(Trait t){
        return this.positionX == t.getPositionX();
    }

    public void render(SpriteBatch sb){
        sb.begin();
        sb.draw(texture, positionX-5, 0, 10, LONGUEUR);
        sb.end();
    }



}
