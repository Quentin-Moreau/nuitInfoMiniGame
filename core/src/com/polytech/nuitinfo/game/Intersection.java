package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

class Intersection {
    private Trait trait1;
    private Trait trait2;
    private int position;
    private Texture texture;

    public Intersection(Trait trait1, Trait trait2, int position) {
        this.trait1 = trait1;
        this.trait2 = trait2;
        this.position = position;
        this.texture = new Texture("background.png");
    }

    //TODO Interdir la création d'intersections au dessus de la position de la dernière intersection posée

    int getPosition() {
        return position;
    }

    Trait getTrait1() {
        return trait1;
    }

    Trait getTrait2() {
        return trait2;
    }

    private Trait lowerTrait(){
        if(trait1.getPositionX() < trait2.getPositionX()){
            return trait1;
        }else{
            return trait2;
        }
    }

    public void render(SpriteBatch sb){
        sb.begin();
        sb.draw(texture, lowerTrait().getPositionX(), position, 100, 10);
        sb.end();
    }

}
