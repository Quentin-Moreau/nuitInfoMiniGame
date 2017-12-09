package com.polytech.nuitinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.polytech.nuitinfo.NF.GestionnaireQuestion;
import com.polytech.nuitinfo.NF.GestionnaireReponse;
import com.polytech.nuitinfo.NF.ListReponse;
import com.polytech.nuitinfo.NF.Question;
import com.polytech.nuitinfo.NF.Reponse;
import com.polytech.nuitinfo.NF.ReponseAdapter;

import java.util.ArrayList;

/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class Exercice extends AppCompatActivity {
    private static int indexQuestionCourante = 0;

    private GestionnaireQuestion gestionnaireQuestion=GestionnaireQuestion.getInstance();
    private GestionnaireReponse gestionnaireReponse=GestionnaireReponse.getInstance();
    private TextView questionTxt;
    //private ImageView questionImg;
    private ListView listViewReponses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice);

        questionTxt = (TextView)findViewById(R.id.questionExo);
        //questionImg = (ImageView)findViewById(R.id.imageQuestion);
        listViewReponses = (ListView)findViewById(R.id.reponses);

        Bundle extras = this.getIntent().getExtras();
        String competence= extras.getString("competence");
        String serie= extras.getString("serie");
        /*Log.d("competence", competence);
        Log.d("serie", serie);*/
        final ArrayList<Question> questionsExo=gestionnaireQuestion.getSerieQuestion(competence,serie);
        setTextQuestion(questionsExo.get(indexQuestionCourante));
        setAdapterListReponse(questionsExo.get(indexQuestionCourante));

        //event sur la reponse que donne l'eleve
        listViewReponses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Reponse reponseDonnee=(Reponse)parent.getItemAtPosition(position);
                //on garde l'erreur dans le gestionnaire
                if(!(reponseDonnee.getReponse().equals(questionsExo.get(indexQuestionCourante).getReponse().getReponse()))){
                    gestionnaireQuestion.addErreurs(questionsExo.get(indexQuestionCourante),reponseDonnee);
                }
                //on passe a la question suivante
                indexQuestionCourante++;
                //si on etait pas a la derniere question
                if(indexQuestionCourante<questionsExo.size()){
                    setTextQuestion(questionsExo.get(indexQuestionCourante));
                    setAdapterListReponse(questionsExo.get(indexQuestionCourante));
                }else{
                    indexQuestionCourante=0;
                    Intent intent=new Intent(Exercice.this,transitionCorrection.class);
                    intent.putExtra("notation",questionsExo.size());
                    startActivity(intent);
                    finish();
                }

            }
        });
    }

    public void setTextQuestion(Question questionCourant){
        questionTxt.setText(questionCourant.getQuestion());
        //questionImg.setImageResource(questionCourant.getImg());
    }
    public void setAdapterListReponse(Question questionCourant){
        ListReponse listR=new ListReponse();
        listR.construireListe(questionCourant);
        ReponseAdapter adapterR=new ReponseAdapter(this, listR);
        listViewReponses.setAdapter(adapterR);
    }
}
