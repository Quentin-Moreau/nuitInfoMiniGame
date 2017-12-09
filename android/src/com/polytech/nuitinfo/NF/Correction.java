package com.polytech.nuitinfo.NF;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class Correction {
    private Question questionACorriger;
    private Reponse reponseFausseDonnee;

    public Correction(Question q, Reponse r){
        this.questionACorriger=q;
        this.reponseFausseDonnee=r;
    }


    public Question getQuestionACorriger() {
        return questionACorriger;
    }

    public Reponse getReponseFausseDonnee() {
        return reponseFausseDonnee;
    }
}
