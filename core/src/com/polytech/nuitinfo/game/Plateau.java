package com.polytech.nuitinfo.game;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class Plateau {
    private ArrayList<Trait> listeTraits;
    private ArrayList<Intersection> listeIntersections;

    private Character character;
    private int difficulte;

    public Plateau(int difficulte){
        for(int i = 0; i < 3; i++){
            listeTraits.add(new Trait());
        }
    }

    /**
     * Retourne la liste des intersections qui se trouvent en dessous de la position entrée en paramètre*
     * @param positionFrom
     * @return listeIntersectionsAPartirDe
     */
    public ArrayList<Intersection> getListeToutesIntersectionsAPartirDe(int positionFrom){
        ArrayList<Intersection> listeIntersectionsAPartirDe = listeIntersections;
        for(Intersection i: listeIntersections){
            if (i.getPosition() < positionFrom) {
                listeIntersectionsAPartirDe.remove(i);
            }
        }
        return listeIntersectionsAPartirDe;
    }

    public ArrayList<Intersection> getListeIntersections(){
        return this.listeIntersections;
    }


}
