package com.polytech.nuitinfo.NF;

/**
 * Created by AlexandreH on 08/12/2017.
 */

public class Cours {
    private String title;
    private String cours;
    private int img;

    public Cours(String t, String r, int img){
        this.title=t;
        this.cours=r;
        this.img=img;
    }

    public String getCours() {
        return this.title+"\n\n"+this.cours;
    }

    public int getImg() {
        return img;
    }
}
