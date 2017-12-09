package com.polytech.nuitinfo.NF;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class GestionnaireReponse {
    private ArrayList<Reponse> reponses;
    private static GestionnaireReponse gestionnaireReponse = new GestionnaireReponse();

    private GestionnaireReponse(){
        this.reponses=new ArrayList<Reponse>();
    }

    public static GestionnaireReponse getInstance(){
        return gestionnaireReponse;
    }

    public void addReponse(Reponse r){
        this.reponses.add(r);
    }

    public ArrayList<Reponse> getReponses(){
        return this.reponses;
    }

    //selection d'un nombre n de reponses fauses aléatoirement differente de except qui serait la bonne réponse
    public ArrayList<Reponse> getReponsesRandom(Reponse except, int howMany){
        ArrayList<Reponse> allReponses = this.getReponses();
        ArrayList<Reponse> reponsesRandom = new ArrayList<Reponse>();
        Random rand=new Random();
        ArrayList<Integer> listIndexRand=new ArrayList<Integer>();

        int i=0;
        int indexRand;
        while(i<howMany){
            indexRand=rand.nextInt(allReponses.size());
            if(!((allReponses.get(indexRand).getReponse()).equals(except.getReponse())) && !(listIndexRand.contains(indexRand))){
                listIndexRand.add(indexRand);
                i++;
            }
        }
        for(int index : listIndexRand){
            reponsesRandom.add(allReponses.get(index));
        }

        return reponsesRandom;

        //autre version pour tirer les randoms
        /*int index1;
        int index2;
        int index3;

        do{
            index1=rand.nextInt(reponses.size());
        }while (reponses.get(index1)==except);

        do{
            index2=rand.nextInt(reponses.size());
        }while (reponses.get(index2)==except || index1==index2);

        do{
            index3=rand.nextInt(reponses.size());
        }while (reponses.get(index3)==except || index1==index3 || index3==index2);*/
    }
}
