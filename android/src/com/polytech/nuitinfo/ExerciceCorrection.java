package com.polytech.nuitinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.polytech.nuitinfo.NF.CorrectionAdapter;
import com.polytech.nuitinfo.NF.GestionnaireQuestion;
import com.polytech.nuitinfo.NF.ListCorrection;


/**
 * Created by Howard Alexandre on 16/03/2017.
 */

public class ExerciceCorrection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice_correction);

        ListView listCorrection = (ListView)findViewById(R.id.corrections);
        final GestionnaireQuestion gq = GestionnaireQuestion.getInstance();

        ListCorrection listC=new ListCorrection();
        listC.construireListe();
        CorrectionAdapter adapterC=new CorrectionAdapter(this, listC);
        listCorrection.setAdapter(adapterC);

        //On lui met sa note au ptio'
        int notation = (int)this.getIntent().getIntExtra("notation",10);
        int note = notation-gq.getErreurs().size();
        TextView noteObtenue=(TextView)findViewById(R.id.note);
        noteObtenue.setText("Note : "+note+"/"+notation);

        ImageView bouttonRetourTemp=(ImageView)findViewById(R.id.imageView7);
        bouttonRetourTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gq.resetErreurs();
                Intent intent=new Intent(ExerciceCorrection.this,Accueil.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
