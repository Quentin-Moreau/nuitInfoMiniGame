package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;


/**
 * Created by Barnabé on 12/7/2017.
 */

class Character {
    private Trait trait;
    private String forme;
    private Texture characterSkin;
    private int position;
    private int vitesse;

    /**
     * Constructeur
     * @param trait
     * @param forme
     */
    public Character(Trait trait, String forme){
        this.trait = trait;
        this.forme = forme;
    }

    void setTrait(Trait trait){
        this.trait = trait;
    }

    /**
     * Fait tomber le personnage le long des traits verticaux
     */
    void tomber(){
        for(int i = 0; i < Trait.LONGUEUR; i++){
            position++;
            //if(position == Trait.getListeIntersectionsAPartirDe(position).get())
        }
    }

    /*private boolean checkIntersection(ArrayList<Intersection> listeIntersection){
        for(Intersection i: listeIntersection){
            if(i.isCrossed(position)){
                character.setTrait(i.traitOppose(character.getTrait()));
                return true;
            }
        }
        return false;
    }*/


}
