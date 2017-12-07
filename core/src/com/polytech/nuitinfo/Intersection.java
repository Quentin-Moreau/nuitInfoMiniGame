package com.polytech.nuitinfo;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

class Intersection {
    private Trait trait1;
    private Trait trait2;
    private int position;

    public Intersection(Trait trait1, Trait trait2, int position){
        this.trait1 = trait1;
        this.trait2 = trait2;
    }

    /*private boolean checkIntersection(ArrayList<Intersection> listeIntersection, Character character){
        for(Intersection i: listeIntersection){
            if(i.isCrossed(position)){
                character.setTrait(i.traitOppose(character.getTrait()));
                return true;
            }
        }
        return false;
    }

    private Trait traitOppose(Trait t){
        if(t.equals(trait1)){return trait2;}
        if(t.equals(trait2)){return trait1;}
    }

    private boolean isCrossed(int position){

    }*/
}
