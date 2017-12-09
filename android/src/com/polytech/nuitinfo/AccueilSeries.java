package com.polytech.nuitinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Howard Alexandre and Tua Mathieu and Munier Rémy on 16/03/2017.
 */

public class AccueilSeries extends AppCompatActivity {
    private Button serie1;
    private Button serie2;
    private Button serie3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil_series);

        final String competence = this.getIntent().getStringExtra("competence");
        final Intent intent=new Intent(AccueilSeries.this,Exercice.class);
        final Bundle extras = new Bundle();
        extras.putString("competence",competence);

        serie1=(Button)findViewById(R.id.serie1);
        serie2=(Button)findViewById(R.id.serie2);
        serie3=(Button)findViewById(R.id.serie3);

        goodLibelleForButton(competence);


        serie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extras.putString("serie", "facile");
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });


        serie2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extras.putString("serie", "moyen");
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });


        serie3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                extras.putString("serie", "difficile");
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });

        ImageView bouttonRetourTemp=(ImageView)findViewById(R.id.imageView2);
        bouttonRetourTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AccueilSeries.this,Accueil.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void goodLibelleForButton(String cmpt){

        if(cmpt.equals("competence1")){
            serie1.setText("Série facile");
            serie2.setText("Série moyenne");
            serie3.setText("Série difficile");
        }
        else if(cmpt.equals("competence2")){
            serie1.setText("autre1");
            serie2.setText("autre2");
            serie3.setText("autre3");
        }
    }
}
