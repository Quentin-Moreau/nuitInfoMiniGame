package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class Intersection {
    private Trait trait1;
    private Trait trait2;
    private int position;
    private Texture texture;
    private ArrayList<Character> crossed;

    public Intersection(Trait trait1, Trait trait2, int position) {
        this.trait1 = trait1;
        this.trait2 = trait2;
        this.position = position;
        this.texture = new Texture("background.png");
        crossed = new ArrayList<Character>();
    }

    //TODO Interdir la création d'intersections au dessus de la position de la dernière intersection posée

    public Trait oppositeTrait(Trait t){
        if(t.equals(trait1)){
            return trait2;
        }else{
            return trait1;
        }
    }
    public int getPosition() {
        return position;
    }

    public Trait getTrait1() {
        return trait1;
    }

    public Trait getTrait2() {
        return trait2;
    }

    public boolean contains(Trait t){
        return t.equals(trait1) || t.equals(trait2);
    }

    public void addChar(Character c){
        crossed.add(c);
    }

    public boolean contains(Character c){
        return crossed.contains(c);
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
        sb.draw(texture, lowerTrait().getPositionX(), position, Math.abs(trait1.getPositionX()-trait2.getPositionX()), 10);
        sb.end();
    }

}
