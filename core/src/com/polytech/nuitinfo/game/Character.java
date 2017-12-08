package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.polytech.nuitinfo.miniMain;

import java.util.ArrayList;


/**
 * Created by Barnabé on 12/7/2017.
 */

public class Character {
    private Trait trait;
    private String type;
    private Texture characterSkin;
    private float position;
    private Vector2 vitesse;

    /**
     * Constructeur
     * @param trait
     * @param type
     */
    public Character(Trait trait, String type, int vitesse, int position){
        this.trait = trait;
        this.type = type;
        this.characterSkin = new Texture("character.png");
        this.vitesse = new Vector2(0, vitesse);
        this.position = position;
    }

    public void setTrait(Trait trait){
        this.trait = trait;
    }

    public float getPosition(){
        return position+25;
    }

    public void setPosition(float position){
        this.position = position;
    }

    public Vector2 getVitesse(){
        return vitesse;
    }

    public Trait getTrait(){
        return this.trait;
    }

    /**
     * Fait tomber le personnage le long des traits verticaux
     */
    public void update(Plateau plateau, float deltaTime){
        vitesse.scl(deltaTime);
        position -= vitesse.y;
        vitesse.scl(1 / deltaTime);
        ArrayList<Intersection> temp = trait.getListeIntersectionsAPartirDe(plateau, (int) position);
        if (temp.size() > 0) {
            if (position == temp.get(0).getPosition()){
                if (trait != trait.getListeIntersectionsAPartirDe(plateau, (int) position).get(0).getTrait1())
                    setTrait(trait.getListeIntersectionsAPartirDe(plateau, (int) position).get(0).getTrait1());
                else
                    setTrait(trait.getListeIntersectionsAPartirDe(plateau, (int) position).get(0).getTrait2());
            }
        }
    }

    public void render(SpriteBatch sb){
        sb.begin();
        sb.draw(this.characterSkin, trait.getPositionX()-25, position, 50, 50);
        sb.end();
    }

    public Texture getTexture(){
        return this.characterSkin;
    }




}
