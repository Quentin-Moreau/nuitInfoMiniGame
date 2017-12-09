package com.polytech.nuitinfo;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * Created by Howard Alexandre and Tua Mathieu and Munier Rémy on 16/03/2017.
 */

public class transitionCorrection extends AppCompatActivity {
    private AnimationDrawable anim;
    private Animation animTvOff;
    private MediaPlayer applause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition_correction);

        final int extra = this.getIntent().getIntExtra("notation",10);

        applause=MediaPlayer.create(transitionCorrection.this,R.raw.applaudissement);
        applause.start();

        final ImageView img= (ImageView)findViewById(R.id.bravoVictoire);
        img.setBackgroundResource(R.drawable.bravo);
        anim=(AnimationDrawable)img.getBackground();
        anim.start();


        animTvOff = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.tvoff);
        animTvOff.setDuration(300);

        animTvOff.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                applause.reset();
                applause.stop();
                Intent intent=new Intent(transitionCorrection.this,ExerciceCorrection.class);
                intent.putExtra("notation",extra);
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                img.startAnimation(animTvOff);
            }
        }, 4000);


    }
}
