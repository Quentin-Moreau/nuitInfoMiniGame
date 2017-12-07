package com.polytech.nuitinfo;

/**
 * Created by Barnabé on 12/7/2017.
 */

class Intersection {
    private Trait trait1;
    private Trait trait2;

    public Intersection(Trait trait1, Trait trait2){
        this.trait1 = trait1;
        this.trait2 = trait2;
    }

    private boolean checkIntersection(){
        for(Intersection i: listeIntersection){
            if(i.isCrossed()){
                character.setTrait(i.traitOppose(character.getTrait));
                return true;
            }
        }
        return false;
    }
}
