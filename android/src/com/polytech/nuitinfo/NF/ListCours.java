package com.polytech.nuitinfo.NF;

import java.util.ArrayList;

/**
 * Created by Alexandre H on 08/12/2017.
 */

public class ListCours {
    ArrayList<Cours> listCours;

    public ListCours(){
        listCours = GestionnaireCours.getInstance().getCoursTotaux();
    }

    public int size(){
        return listCours.size();
    }

    public Cours get(int pos){
        return listCours.get(pos);
    }

    public void add(Cours tips){
        this.listCours.add(tips);
    }

}
