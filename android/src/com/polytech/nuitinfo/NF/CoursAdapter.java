package com.polytech.nuitinfo.NF;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.polytech.nuitinfo.R;

/**
 * Created by AlexandreH on 08/12/2017.
 */

public class CoursAdapter extends BaseAdapter {
    private ListCours mListC;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public CoursAdapter(Context context, ListCours aListC) {
        mContext = context;
        mListC = aListC;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListC.size();
    }

    public Object getItem(int position) {
        return mListC.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.layout_cours, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView courstxt = (TextView)layoutItem.findViewById(R.id.coursLibelle);
        ImageView imgcours = (ImageView)layoutItem.findViewById(R.id.coursImg);


        //(3) : Renseignement des valeurs
        courstxt.setText(mListC.get(position).getCours());
        imgcours.setImageResource(mListC.get(position).getImg());


        //On retourne l'item créé.
        return layoutItem;
    }
}
