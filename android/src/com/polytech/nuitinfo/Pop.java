package com.polytech.nuitinfo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by theos on 08/12/2017.
 */

public class Pop extends Activity{
    private Button ok;
    private TextView tw;
    private ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String s = intent.getStringExtra("score");
        int score=0;
        if( s != null){
            score = Integer.parseInt(intent.getStringExtra("score"));
        }

        setContentView(R.layout.popupwindows);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width  = dm.widthPixels;
        int height  = dm.heightPixels;

        //getWindow().setLayout((int)(width*0.5),(int) (height*0.8));

        ok = findViewById(R.id.button);
        tw = findViewById(R.id.messagePopup);
        image = findViewById(R.id.image);


        if(score < 5){
            tw.setText("Tu comptais vraiment prendre la voiture dans cet état là ?");
            image.setImageResource(R.drawable.bourre);
        }else{
            tw.setText("Tu as réussi le test ! ");
            image.setImageResource(R.drawable.smile);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
                /*
                Intent intent = new Intent(Pop.this, Accueil.class);
                startActivity(intent);*/
            }
        });
    }

}
