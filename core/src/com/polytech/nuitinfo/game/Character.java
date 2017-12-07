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
    public Character(Trait trait, String forme, int vitesse){
        this.trait = trait;
        this.forme = forme;
        this.vitesse = vitesse;
    }

    void setTrait(Trait trait){
        this.trait = trait;
    }

    /**
     * Fait tomber le personnage le long des traits verticaux
     */
    void update(Plateau plateau, float deltaTime){
        for(int i = 0; i < Trait.LONGUEUR; i++){
            position += vitesse;
            if(position == trait.getListeIntersectionsAPartirDe(plateau, position).get(0).getPosition()){
                if (trait != trait.getListeIntersectionsAPartirDe(plateau, position).get(0).getTrait1()) setTrait(trait.getListeIntersectionsAPartirDe(plateau, position).get(0).getTrait1());
                else setTrait(trait.getListeIntersectionsAPartirDe(plateau, position).get(0).getTrait2());
            }
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
