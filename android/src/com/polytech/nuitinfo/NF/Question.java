package com.polytech.nuitinfo.NF;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class Question {
    private String question;
    private Reponse reponse;
    private Boolean correct;
    private int img;

    public Question(String q, Reponse r){
        this.question=q;
        this.reponse=r;
        //this.img=img;
    }


    public int getImg() {
        return img;
    }

    public Reponse getReponse() {
        return reponse;
    }

    public String getQuestion() {
        return question;
    }

    public Boolean getCorrect() {
        return correct;
    }

    public void setCorrect(Boolean correct) {
        this.correct = correct;
    }
}
