package com.polytech.nuitinfo.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.polytech.nuitinfo.miniMain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Barnabé on 12/7/2017.
 */

public class Plateau {
    private ArrayList<Trait> listeTraits;
    private ArrayList<Intersection> listeIntersections;

    private ArrayList<Character> listCharacter;
    private ArrayList<Character> enemyList;
    private int difficulte;

    public Plateau(int difficulte, int vitesse){
        listCharacter = new ArrayList<Character>();
        enemyList = new ArrayList<Character>();
        listeIntersections = new ArrayList<Intersection>();
        listeTraits = new ArrayList<Trait>();
        ArrayList<String> formes = new ArrayList<String>();
        formes.add("carre");
        formes.add("cercle");
        formes.add("triangle");
        //formes.add("etoile");
        Random r = new Random();
        for(int i = 1; i < 4; i++){
            listeTraits.add(new Trait(i*100, null));
        }

        for(int i = 0; i < listeTraits.size()/3; i++){
            int hauteur = miniMain.HEIGHT/8 + r.nextInt(miniMain.HEIGHT/2 - miniMain.HEIGHT/8);
            enemyList.add(new Character(getRandomTrait(), "policeman", 0, hauteur));
        }

        for(int i = 0; i < listeTraits.size(); i++){
            int k = r.nextInt(formes.size());
            String chosen = formes.get(k);
            listeTraits.get(i).setCharacter(new Character(listeTraits.get(i), chosen, 0, miniMain.HEIGHT-listeTraits.get(i).LONGUEUR-25));
            formes.remove(k);
        }

        listCharacter.add(new Character(this.getRandomTrait(), "player", vitesse, miniMain.HEIGHT-25));
    }

    public ArrayList<Trait> getListeTraits(){
        return this.listeTraits;
    }

    public Character getSlowerCharacter(){
        Character slowerCharacter = listCharacter.get(0);
        for(int i = 1; i < listCharacter.size(); i++){
            if(listCharacter.get(i).getVitesse().y < slowerCharacter.getVitesse().y)
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

    public boolean canAddIntersection(){
        return listeIntersections.size() < 3;
    }

    public Intersection checkIntersection(){
        for(Intersection i: listeIntersections){
            if(i.getPosition()-listCharacter.get(0).getPosition() < (listCharacter.get(0).getVitesse().y/100.0) && i.getPosition()-listCharacter.get(0).getPosition() > -(listCharacter.get(0).getVitesse().y/100.0)){
                if(i.contains(listCharacter.get(0).getTrait()) && !i.contains(listCharacter.get(0))){
                    //listCharacter.get(0).setTrait(i.oppositeTrait(listCharacter.get(0).getTrait()));
                    i.addChar(listCharacter.get(0));
                    return i;
                }
            }
        }
        return null;
    }

    public boolean travelIntersection(Intersection i, int travel){
        Character c = listCharacter.get(0);
        if(travel < 0){
            c.transition(1);
        }else{
            c.transition(-1);
        }

        float temp1 = i.oppositeTrait(c.getTrait()).getPositionX();
        if(temp1 - c.getPositionY() < Math.abs(c.getVitesse().x)/100.0 && temp1 - c.getPositionY() > -(Math.abs(c.getVitesse().x)/100.0)){
            c.setPositionY(i.oppositeTrait(c.getTrait()).getPositionX());
            c.setTrait(i.oppositeTrait(c.getTrait()));
            return true;
        }else{
            return false;
        }
    }

    public int calculDist(Intersection i){
        Character c = listCharacter.get(0);
        return c.getTrait().getPositionX()-i.oppositeTrait(c.getTrait()).getPositionX();
    }

    public void resetMove(){
        listCharacter.get(0).resetTransition();
    }


    public Trait checkFin(){
        for(Trait t: listeTraits){
            if(listCharacter.get(0).getPosition() <= t.getBottom().getPosition() && listCharacter.get(0).getTrait().getPositionX() == t.getPositionX()){
                return t;
            }
        }

        return null;
    }

    public boolean checkEnemy(){
        Character player = listCharacter.get(0);
        for(Character c: enemyList){
            if(player.getTrait().equals(c.getTrait())) {
                if (player.getPosition() < c.getPosition() + player.getVitesse().y / 100 && player.getPosition() > c.getPosition() - player.getVitesse().y / 100) {
                    return true;
                }
            }
        }
        return false;
    }

    public void render(SpriteBatch sb){
        //System.out.println(listeIntersections.size());
        for(Trait t: listeTraits){
            t.render(sb);
        }
        for(Intersection i: listeIntersections){
            i.render(sb);
        }
        for(Character c: enemyList){
            c.render(sb);
        }
    }

    public Trait getFirstTrait(){
        return listeTraits.get(0);
    }

    public Trait getRandomTrait(){
        Random r = new Random();
        if(listeTraits.size()>0) {
            int k = r.nextInt(listeTraits.size());
            return listeTraits.get(k);
        }
        return null;
    }
    public void addIntersection(int x, int y) {
        Trait[] temp = getCloserTraits(x);
        this.listeIntersections.add(new Intersection(temp[0], temp[1], y));
    }

    public Trait[] getCloserTraits(int positionX){
        ArrayList<Integer> distances = new ArrayList<Integer>();
        ArrayList<Trait> temp = new ArrayList<Trait>(listeTraits);
        for(int i = 0; i < temp.size(); i++){
            distances.add(Math.abs(listeTraits.get(i).getPositionX()-positionX));
        }
        int max = -100;
        int maxIndex = -10;
        for(int i = 0; i < distances.size(); i++){
            if(distances.get(i) > max){
                max = distances.get(i);
                maxIndex = i;
            }
        }
        //System.out.println(listeIntersections.size());

        if(maxIndex >= 0){
            temp.remove(maxIndex);
        }
        Trait[] fin = {temp.get(0), temp.get(1)};
        return fin;
    }

    public boolean checkWin(Trait t) {
        String s1 = t.getBottom().getForm();
        String s2 = listCharacter.get(0).getForm();
        boolean b1 = s1.equals(s2);
        return b1;
        //return t.getBottom().getForm().equals(listCharacter.get(0).getForm());
        /*if(t.getBottom().getForm().equals(listCharacter.get(0).getForm())){
            //System.out.println("prout");
            return true;
        }else{
            return false;
        }*/
    }
}
