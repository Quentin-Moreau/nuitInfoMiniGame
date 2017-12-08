package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;


/**
 * Created by Barnabé on 12/7/2017.
 */

public class Character {
    private Trait trait;
    private String type;
    private Texture characterSkin;
    private float position;
    private float positionY;
    private Vector2 storedSpeed;
    private Vector2 vitesse;
    private int size = 100;

    /**
     * Constructeur
     * @param trait
     * @param type
     */
    public Character(Trait trait, String type, int vitesse, int position){
        this.trait = trait;
        this.type = type;
        if(type.equals("player")){
            this.size = 50;
            this.characterSkin = new Texture(type + ".png");
            this.type = "carre";
        }
        if(type.equals("policeman")){
            this.size=50;
            this.type = "cercle";
            this.characterSkin = new Texture(this.type + ".png");
        }else {
            this.characterSkin = new Texture(type + ".png");
        }
        this.storedSpeed = new Vector2(0, vitesse);
        this.vitesse = new Vector2(0, vitesse);
        this.position = position;
        this.positionY = trait.getPositionX();
    }

    public void setTrait(Trait trait){
        this.trait = trait;
    }

    public float getPosition(){
        return position+(size/2);
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

    public String getForm(){
        return type;
    }

    public float getPositionY(){return positionY;}

    public void setPositionY(float k){this.positionY = k;}

    /**
     * Fait tomber le personnage le long des traits verticaux
     */
    public void update(Plateau plateau, float deltaTime){
        vitesse.scl(deltaTime);
        position -= vitesse.y;
        positionY += vitesse.x;
        System.out.println(positionY + ", " + vitesse.x);
        vitesse.scl(1 / deltaTime);
        ArrayList<Intersection> temp = trait.getListeIntersectionsAPartirDe(plateau, (int) position);
        /*if (temp.size() > 0) {
            if (position == temp.get(0).getPosition()){
                if (trait != trait.getListeIntersectionsAPartirDe(plateau, (int) position).get(0).getTrait1())
                    setTrait(trait.getListeIntersectionsAPartirDe(plateau, (int) position).get(0).getTrait1());
                else
                    setTrait(trait.getListeIntersectionsAPartirDe(plateau, (int) position).get(0).getTrait2());
            }
        }*/
    }

    public void transition(int multiplicateur){
            this.vitesse.x = multiplicateur * this.storedSpeed.y;
            this.vitesse.y = 0;
    }

    public void resetTransition(){
        this.vitesse.x = 0;
        this.vitesse.y = this.storedSpeed.y;
    }

    public void render(SpriteBatch sb){
        sb.begin();
        sb.draw(this.characterSkin, positionY-(size/2), position, size, size);
        sb.end();
    }

    public Texture getTexture(){
        return this.characterSkin;
    }




}
