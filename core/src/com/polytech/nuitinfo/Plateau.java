package com.polytech.nuitinfo;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class Plateau {
    private ArrayList<Trait> listeTraits;
    private ArrayList<Intersection> listeIntersection;

    private Forme character;
    private int difficulte;

    public Plateau(int difficulte){
        for(int i = 0; i < 3; i++){
            listeTraits.add(new Trait());
        }
    }


}
