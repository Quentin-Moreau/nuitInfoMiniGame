package com.polytech.nuitinfo.NF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class ListCorrection {
    private ArrayList<Correction> listCorrection = new ArrayList<Correction>();

    public ListCorrection (){
        this.listCorrection= new ArrayList<Correction> ();
    }

    public ArrayList<Correction> getListCorrection() {
        return listCorrection;
    }

    public int size(){
        return listCorrection.size();
    }

    public Correction get(int pos){
        return listCorrection.get(pos);
    }

    public void construireListe(){
        HashMap<Question, Reponse> erreurs = GestionnaireQuestion.getInstance().getErreurs();
        for(Map.Entry<Question, Reponse> entry : erreurs.entrySet()){
            this.listCorrection.add(new Correction(entry.getKey(),entry.getValue()));
        }
    }

}
