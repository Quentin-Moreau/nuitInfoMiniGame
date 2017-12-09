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
 * Created by Alexandre H on 08/12/2017.
 */

public class NumeroAdapter extends BaseAdapter{
    private ListNumero mListN;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public NumeroAdapter(Context context, ListNumero aListC) {
        mContext = context;
        mListN = aListC;
        mInflater = LayoutInflater.from(mContext);
    }

    public int getCount() {
        return mListN.size();
    }

    public Object getItem(int position) {
        return mListN.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout layoutItem;
        //(1) : Réutilisation des layouts
        if (convertView == null) {
            //Initialisation de notre item à partir du  layout XML "personne_layout.xml"
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.layout_numero, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView courstxt = (TextView)layoutItem.findViewById(R.id.numnum);


        //(3) : Renseignement des valeurs
        courstxt.setText(mListN.get(position).getNum());

        //On retourne l'item créé.
        return layoutItem;
    }
}
