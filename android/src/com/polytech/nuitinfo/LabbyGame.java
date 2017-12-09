package com.polytech.nuitinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by theos on 07/12/2017.
 */

public class LabbyGame extends Activity {
    private int nbcaseByRow = 8;
    private int nbRow = 10;
    private int scoreInt = 0;
    private boolean terminated = false;

    private Integer[] graphique = new Integer[nbcaseByRow*nbRow];
    private boolean[] goodPos = new boolean[nbcaseByRow*nbRow];

    private GridView myGridView;
    private TextView timer;
    private TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labbygame);

        myGridView = (GridView) findViewById(R.id.gridView);
        score =(TextView) findViewById(R.id.Score);
        timer = (TextView) findViewById(R.id.Timer);

        new CountDownTimer(10000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000+"");
            }

            public void onFinish() {
                timer.setText("done!");
                terminated = true;
                Intent intent = new Intent(LabbyGame.this,Pop.class);
                intent.putExtra("score",scoreInt);
                startActivity(intent);
                finish();
            }
        }.start();

        generateLabby();
        myGridView.setPadding(0, 0, 0, 0);
        myGridView.setAdapter(new ImageAdapter(this,graphique));

        myGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(!terminated) {
                    if (goodPos[position]) {
                        scoreInt++;
                        score.setText(scoreInt + "");

                        generateLabby();
                        myGridView.setPadding(0, 0, 0, 0);
                        myGridView.setAdapter(new ImageAdapter(LabbyGame.this, graphique));
                    } else
                        scoreInt--;
                }
            }
        });
    }

    private void generateLabby(){
        int randInt = new Random().nextInt(graphique.length);
        for(int i=0; i<graphique.length; i++){
            if(i==randInt){
                goodPos[i] = true;
                graphique[i] = R.drawable.vertical;
            }else {
                goodPos[i] = false;
                graphique[i] = R.drawable.vide;
            }
        }
    }
}

