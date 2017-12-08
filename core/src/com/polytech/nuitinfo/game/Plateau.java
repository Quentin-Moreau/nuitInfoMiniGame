package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class Plateau {
    private ArrayList<Trait> listeTraits;
    private ArrayList<Intersection> listeIntersections;

    private ArrayList<Character> listCharacter;
    private int difficulte;

    public Plateau(int difficulte){
        listeIntersections = new ArrayList<Intersection>();
        listeTraits = new ArrayList<Trait>();
        for(int i = 1; i < 4; i++){
            listeTraits.add(new Trait(i*100));
        }
    }

    public Character getSlowerCharacter(){
        Character slowerCharacter = listCharacter.get(0);
        for(int i = 1; i < listCharacter.size(); i++){
            if(listCharacter.get(i).getVitesse() < slowerCharacter.getVitesse())
                slowerCharacter = listCharacter.get(i);
        }
        return slowerCharacter;
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

    public void render(SpriteBatch sb){
        for(Trait t: listeTraits){
            t.render(sb);
        }
    }

    public Trait getFirstTrait(){
        return listeTraits.get(0);
    }

    public void addIntersection(int x, int y) {
        Trait[] temp = getCloserTraits(x);
        this.listeIntersections.add(new Intersection(temp[0], temp[1], y));
    }

    public Trait[] getCloserTraits(int positionX){
        ArrayList<Integer> distances = new ArrayList<Integer>();
        for(int i = 0; i < listeTraits.size(); i++){
            distances.add(Math.abs(listeTraits.get(i).getPositionX()-positionX));
        }
        /*for(int i = 0; i < distances.size(); i++){
            if()
        }*/
        return null;
    }

}
