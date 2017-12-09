package com.polytech.nuitinfo.NF;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.polytech.nuitinfo.R;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class ReponseAdapter extends BaseAdapter{
    private ListReponse mListR;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public ReponseAdapter(Context context, ListReponse aListR) {
        mContext = context;
        mListR = aListR;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListR.size();
    }

    public Object getItem(int position) {
        return mListR.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.layout_reponse, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView reponse = (TextView)layoutItem.findViewById(R.id.reponseLibelle);


        //(3) : Renseignement des valeurs
        reponse.setText(mListR.get(position).getReponse());


        //On retourne l'item créé.
        return layoutItem;
    }
}
