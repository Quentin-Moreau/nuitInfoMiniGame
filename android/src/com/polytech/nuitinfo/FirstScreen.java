package com.polytech.nuitinfo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.HashMap;

public class FirstScreen extends AppCompatActivity {

    private static HashMap<String,Integer> konomikon = FirstScreen.createMap();
    private static HashMap<String,Integer> createMap(){
        HashMap<String,Integer> res = new HashMap<>();
        res.put("HAUT",0);
        res.put("BAS",0);
        res.put("DROITE",0);
        res.put("GAUCHE",0);
        return res;
    }
    public static HashMap<String,Integer> getKonomicon(){
        return FirstScreen.konomikon;
    }
    public static void resetKonomicon(){
        FirstScreen.konomikon=new HashMap<>();
        FirstScreen.konomikon.put("HAUT",0);
        FirstScreen.konomikon.put("BAS",0);
        FirstScreen.konomikon.put("DROITE",0);
        FirstScreen.konomikon.put("GAUCHE",0);
    }
    public static void incrKonomicon(String key){
        int tmp=0;
        tmp=FirstScreen.konomikon.getOrDefault(key,0)+1;
        FirstScreen.konomikon.put(key,tmp);
    }


    @SuppressLint("ClickableViewAccessibility") //TODO :find a fix using customView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);

        ImageView transiFirstScreen =(ImageView)findViewById(R.id.buttonTransiAcceuil);

        transiFirstScreen.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                float x1=0,x2=0;
                float y1=0,y2=0;
                switch(motionEvent.getAction())
                {
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        y1 = motionEvent.getY();
                        break;
                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();
                        y2 = motionEvent.getY();
                        float deltaX = x2 - x1;
                        float deltaY = y2 - y1;

                        if (Math.abs(deltaX) > 0 || Math.abs(deltaY) > 0)
                        {
                            HashMap<String,Integer> map = FirstScreen.getKonomicon();

                            if(deltaX>deltaY && (map.getOrDefault("HAUT",0)==2 && map.getOrDefault("BAS",0)==2)){ //horizontal
                                if(x2>x1){ //left to right

                                    if(map.getOrDefault("GAUCHE",0)==2 && map.getOrDefault("DROITE",0)==1){ //Konomikon completed
                                        //TODO : Hack Mode
                                        Toast toast=Toast.makeText(getApplicationContext(),"Konomicon !",Toast.LENGTH_LONG);
                                        toast.show();

                                        FirstScreen.resetKonomicon();
                                    }else if(map.getOrDefault("GAUCHE",0)==1 && map.getOrDefault("DROITE",0)==0){ //Ok
                                        FirstScreen.incrKonomicon("DROITE");
                                    }else{
                                        FirstScreen.resetKonomicon();
                                    }

                                }else{ //right to left

                                    if((map.getOrDefault("GAUCHE",0)==0 && map.getOrDefault("DROITE",0)==0) ||
                                            (map.getOrDefault("GAUCHE",0)==1 && map.getOrDefault("DROITE",0)==1)){ //ok
                                        FirstScreen.incrKonomicon("GAUCHE");
                                    }else{
                                        FirstScreen.resetKonomicon();
                                    }
                                }

                            }else if(deltaY>deltaX && (map.getOrDefault("DROITE",0)==0 && map.getOrDefault("GAUCHE",0)==0)){ //vertical
                                if(y2>y1){ //up

                                    if((map.getOrDefault("HAUT",0)==0 && map.getOrDefault("BAS",0)==0) ||
                                            (map.getOrDefault("HAUT",0)==1 && map.getOrDefault("BAS",0)==0)){ //ok
                                        FirstScreen.incrKonomicon("HAUT");
                                    }else{
                                        FirstScreen.resetKonomicon();
                                    }

                                }else{ //down

                                    if((map.getOrDefault("HAUT",0)==2 && map.getOrDefault("BAS",0)==0) ||
                                            (map.getOrDefault("HAUT",0)==2 && map.getOrDefault("BAS",0)==1)){ //ok
                                        FirstScreen.incrKonomicon("BAS");
                                    }else{
                                        FirstScreen.resetKonomicon();
                                    }
                                }

                            }else{ //diago parfaite
                                FirstScreen.resetKonomicon();
                            }

                        }
                        else
                        {
                            FirstScreen.resetKonomicon();
                            Intent intent = new Intent(FirstScreen.this,Accueil.class);
                            startActivity(intent);
                            finish();
                        }
                        break;
                }
                FirstScreen.resetKonomicon();
                return FirstScreen.super.onTouchEvent(motionEvent);

            }

        });


        transiFirstScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreen.this,Accueil.class);
                startActivity(intent);
                finish();
            }
        });

        //Alternatif
        transiFirstScreen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"Konomicon !",Toast.LENGTH_LONG);
                toast.show();
                return true;
            }
        });
    }


}
