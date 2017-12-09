package com.polytech.nuitinfo.NF;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class Reponse {
    private String reponse;
    private String explication;

    public Reponse(String r, String expl){
        this.reponse=r;
        this.explication=expl;

        GestionnaireReponse gr = GestionnaireReponse.getInstance();
        gr.addReponse(this);
    }

    public String getReponse() {
        return reponse;
    }

    public String getExplication() {
        return explication;
    }
}
