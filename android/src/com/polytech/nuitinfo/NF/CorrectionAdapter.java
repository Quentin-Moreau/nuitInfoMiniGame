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

public class CorrectionAdapter extends BaseAdapter{
    private ListCorrection mListC;

    //Le contexte dans lequel est présent notre adapter
    private Context mContext;

    //Un mécanisme pour gérer l'affichage graphique depuis un layout XML
    private LayoutInflater mInflater;


    public CorrectionAdapter(Context context, ListCorrection aListC) {
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
            layoutItem = (LinearLayout) mInflater.inflate(R.layout.layout_correction, parent, false);
        } else {
            layoutItem = (LinearLayout) convertView;
        }

        //(2) : Récupération des TextView de notre layout
        TextView correctionQ = (TextView)layoutItem.findViewById(R.id.correctionQuestion);
        TextView correctionRDonnee = (TextView)layoutItem.findViewById(R.id.correctionRepDonnee);
        TextView correctionExpli = (TextView)layoutItem.findViewById(R.id.correctionExplication);
        TextView correctionBR =(TextView)layoutItem.findViewById(R.id.correctionBonneReponse);


        //(3) : Renseignement des valeurs
        correctionQ.setText("Correction de la question: "+mListC.get(position).getQuestionACorriger().getQuestion());
        correctionRDonnee.setText("Vous avez repondu: "+mListC.get(position).getReponseFausseDonnee().getReponse());
        correctionBR.setText("La bonne réponse était: "+mListC.get(position).getQuestionACorriger().getReponse().getReponse());
        correctionExpli.setText("En effet: "+mListC.get(position).getQuestionACorriger().getReponse().getExplication());
        //On retourne l'item créé.
        return layoutItem;
    }
}
