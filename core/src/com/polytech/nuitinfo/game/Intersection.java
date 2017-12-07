package com.polytech.nuitinfo.game;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

class Intersection {
    private Trait trait1;
    private Trait trait2;
    private int position;

    public Intersection(Trait trait1, Trait trait2, int position) {
        this.trait1 = trait1;
        this.trait2 = trait2;
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
}
