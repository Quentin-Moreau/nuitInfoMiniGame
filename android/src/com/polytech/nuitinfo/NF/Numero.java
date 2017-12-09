package com.polytech.nuitinfo.NF;

/**
 * Created by Alexandre H on 08/12/2017.
 */

public class Numero {
    private String num;
    private String pers;

    public Numero(String n, String p){
        this.num=n;
        this.pers=p;
    }

    public String getNum() {
        return this.pers+": "+this.num;
    }
}
