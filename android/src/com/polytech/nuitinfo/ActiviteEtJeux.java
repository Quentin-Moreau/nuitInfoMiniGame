package com.polytech.nuitinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActiviteEtJeux extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activite_et_jeux);



        Button cmpt =(Button)findViewById(R.id.quizz);
        cmpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActiviteEtJeux.this,AccueilSeries.class);
                intent.putExtra("competence","competence1");
                startActivity(intent);
                finish();
            }
        });


        Button ethylojej =(Button)findViewById(R.id.ethyloJeu);
        ethylojej.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActiviteEtJeux.this,LabbyGame.class);
                startActivity(intent);
                finish();
            }
        });

        Button chemin =(Button)findViewById(R.id.bonChemin);
        chemin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActiviteEtJeux.this,AndroidLauncher.class); //TODO : chemin quentin
                startActivity(intent);
                finish();
            }
        });
    }
}
