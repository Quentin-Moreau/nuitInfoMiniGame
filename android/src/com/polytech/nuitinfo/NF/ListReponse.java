package com.polytech.nuitinfo.NF;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class ListReponse {
    ArrayList<Reponse> listReponse;

    public ListReponse(){
        listReponse = new ArrayList<Reponse>();
    }

    public int size(){
        return listReponse.size();
    }

    public Reponse get(int pos){
        return listReponse.get(pos);
    }

    public void add(Reponse reponseCorrect){
        this.listReponse.add(reponseCorrect);
    }

    public void construireListe(Question qCourante){

        Reponse reponsecorrect=qCourante.getReponse();
        GestionnaireReponse gp = GestionnaireReponse.getInstance();
        //on prend deja trois reponses random sauf la bonne
        ArrayList<Reponse> reponsePossible = gp.getReponsesRandom(reponsecorrect,3);;
        reponsePossible.add(reponsecorrect);

        //on mélange
        Collections.shuffle(reponsePossible);
        this.listReponse=reponsePossible;
    }
}
