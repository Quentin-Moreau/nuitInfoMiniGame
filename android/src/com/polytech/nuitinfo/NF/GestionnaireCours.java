package com.polytech.nuitinfo.NF;

import com.polytech.nuitinfo.R;

import java.util.ArrayList;

/**
 * Created by Alexandre H on 08/12/2017.
 */

public class GestionnaireCours {
    private ArrayList<Cours> coursTotaux=new ArrayList<Cours>();

    private static final GestionnaireCours gestionnaireCours = new GestionnaireCours();

    private GestionnaireCours(){
        this.construireSeriesCours();
    }

    //TODO : vrais cours
    private void construireSeriesCours(){
        this.coursTotaux.add(new Cours("Tips 1","Blablablablablablabalbalbalablablablablabalbalabl1", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 2","Blablablablablablabalbalbalablablablablabalbalabl2", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 3","Blablablablablablabalbalbalablablablablabalbalabl3", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 4","Blablablablablablabalbalbalablablablablabalbalabl4", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 5","Blablablablablablabalbalbalablablablablabalbalabl5", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 6","Blablablablablablabalbalbalablablablablabalbalabl6", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 7","Blablablablablablabalbalbalablablablablabalbalabl7", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 8","Blablablablablablabalbalbalablablablablabalbalabl8", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 9","Blablablablablablabalbalbalablablablablabalbalabl9", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 10","Blablablablablablabalbalbalablablablablabalbalabl10", R.drawable.tuture));
        this.coursTotaux.add(new Cours("Tips 11","Blablablablablablabalbalbalablablablablabalbalabl11", R.drawable.tuture));
    }

    public static GestionnaireCours getInstance(){
        return gestionnaireCours;
    }

    public ArrayList<Cours> getCoursTotaux() {
        return coursTotaux;
    }
}
