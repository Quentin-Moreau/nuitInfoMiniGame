package com.polytech.nuitinfo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.polytech.nuitinfo.NF.CoursAdapter;
import com.polytech.nuitinfo.NF.GestionnaireNumero;
import com.polytech.nuitinfo.NF.ListCours;
import com.polytech.nuitinfo.NF.ListNumero;
import com.polytech.nuitinfo.NF.Numero;
import com.polytech.nuitinfo.NF.NumeroAdapter;
import com.polytech.nuitinfo.NF.NumeroCourant;
import com.polytech.nuitinfo.NF.Reponse;


public class AnnuaireNumeros extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annuaire_numeros);
        ListView listViewNum = (ListView)findViewById(R.id.numsAnnu);


        ListNumero listN=new ListNumero();
        NumeroAdapter adapterN=new NumeroAdapter(this, listN);
        listViewNum.setAdapter(adapterN);

        listViewNum.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Numero numSelected=(Numero) parent.getItemAtPosition(position);
                NumeroCourant.getInstance().setNum(numSelected);
            }
        });

        ImageButton ib = (ImageButton)findViewById(R.id.backAnnuaire);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AnnuaireNumeros.this,Accueil.class);
                startActivity(intent);
                finish();
            }
        });

        //TODO : persistence du num ajoute
        ImageButton iAdd = (ImageButton)findViewById(R.id.numAddButton);
        iAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText input = (EditText)findViewById(R.id.numAdd);
                String res = input.getText().toString();
                String[] split = res.split(":");
                if(split.length==2){
                    Numero n = new Numero(split[1].replaceAll(" ",""),split[0].replaceAll(" ",""));
                    GestionnaireNumero.getInstance().add(n);
                    Intent intent = new Intent(AnnuaireNumeros.this,AnnuaireNumeros.class);
                    startActivity(intent);
                    finish();
                }

            }
        });
    }
}
