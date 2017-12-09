package com.polytech.nuitinfo.NF;

/**
 * Created by Alexandre H on 08/12/2017.
 */

public class NumeroCourant {
    private static NumeroCourant nc;

    private Numero num;

    private NumeroCourant(){
        this.num=null;
    }

    public static NumeroCourant getInstance(){
        if(nc==null){
            nc=new NumeroCourant();
        }
        return nc;
    }

    public void setNum(Numero n){
        this.num=n;
    }

    public Numero getNum() {
        return num;
    }

    public String affichNum(){
        if(this.num==null){
            return "Pas de numero";
        }else{
            return this.num.getNum();
        }
    }
}
