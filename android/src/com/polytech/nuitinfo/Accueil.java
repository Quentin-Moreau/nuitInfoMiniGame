package com.polytech.nuitinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.polytech.nuitinfo.NF.NumeroCourant;

/**
 * Created by Howard Alexandre and Tua Mathieu and Munier Rémy on 16/03/2017.
 */

public class Accueil extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Button cmpt1 =(Button)findViewById(R.id.tipsCours);
        cmpt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,TipsEtCours.class);
                startActivity(intent);
                finish();
            }
        });

        Button cmpt2 =(Button)findViewById(R.id.activites);
        cmpt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,ActiviteEtJeux.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton traducteur =(ImageButton)findViewById(R.id.btnNews); //TODO : news
        traducteur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Translator.class);
                startActivity(intent);
                finish();
            }
        });

        Button wiwi =(Button)findViewById(R.id.urgenceCall);
        wiwi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t=Toast.makeText(getApplicationContext(),NumeroCourant.getInstance().affichNum(),Toast.LENGTH_LONG);
                t.show();

            }
        });

        ImageButton nununu =(ImageButton)findViewById(R.id.buttonNumeros);
        nununu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,AnnuaireNumeros.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton zbra =(ImageButton)findViewById(R.id.buttonCalendarKdo);
        zbra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Accueil.this,Calendar.class);
                startActivity(intent);
                finish();
            }
        });


    }


}
