package com.polytech.nuitinfo.NF;

import com.polytech.nuitinfo.R;

import java.util.ArrayList;

/**
 * Created by Alexandre H on 08/12/2017.
 */

public class GestionnaireNumero {
    private ArrayList<Numero> nums=new ArrayList<Numero>();

    private static final GestionnaireNumero gestionnaireNums = new GestionnaireNumero();

    private GestionnaireNumero(){
        this.construireSeriesNumero();
    }

    //TODO : vrais num
    private void construireSeriesNumero(){
        this.nums.add(new Numero("+336 33 33 33 33","pers1"));
        this.nums.add(new Numero("+336 66 66 66 66","pers2"));
        this.nums.add(new Numero("+336 33 33 33 33","pers3"));
        this.nums.add(new Numero("+336 66 66 66 66","pers4"));
        this.nums.add(new Numero("+336 33 33 33 33","pers5"));
        this.nums.add(new Numero("+336 66 66 66 66","pers6"));
        this.nums.add(new Numero("+336 33 33 33 33","pers7"));
        this.nums.add(new Numero("+336 66 66 66 66","pers8"));
        this.nums.add(new Numero("+336 33 33 33 33","pers9"));
        this.nums.add(new Numero("+336 66 66 66 66","pers10"));
        this.nums.add(new Numero("+336 33 33 33 33","pers11"));
    }

    public static GestionnaireNumero getInstance(){
        return gestionnaireNums;
    }

    public ArrayList<Numero> getNums() {
        return nums;
    }

    public void add(Numero n){
        this.nums.add(n);
    }
}
