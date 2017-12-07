package com.polytech.nuitinfo.game;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

class Trait {
    public static final int LONGUEUR = 1000;
    private int positionX;

    public Trait(){
    }

    public ArrayList<Intersection> getListeIntersectionsAPartirDe(Plateau plateau, int positionFrom){
        //for ()
        ArrayList<Intersection> fullList = plateau.getListeIntersections();
        ArrayList<Intersection> sortedList = new ArrayList<Intersection>();
        if(fullList.size() > 0){
            for(Intersection i: fullList){
                if(i.getPosition() < positionFrom && i.getTrait1().equals(this) || i.getTrait2().equals(this)){
                    sortedList.add(i);
                }
            }
        }
        return sortedList;
    }

    public int getPositionX(){return positionX;}

    public boolean equals(Trait t){
        return this.positionX == t.getPositionX();
    }



}
