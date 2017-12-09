package com.polytech.nuitinfo.NF;

import java.util.ArrayList;

/**
 * Created by Alexandre H on 08/12/2017.
 */

public class ListNumero {
    ArrayList<Numero> listNums;

    public ListNumero(){
        listNums = GestionnaireNumero.getInstance().getNums();
    }

    public int size(){
        return listNums.size();
    }

    public Numero get(int pos){
        return listNums.get(pos);
    }

    public void add(Numero tips){
        this.listNums.add(tips);
    }
}
