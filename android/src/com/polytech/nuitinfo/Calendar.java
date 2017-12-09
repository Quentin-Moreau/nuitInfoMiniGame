package com.polytech.nuitinfo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;

/**
 * Created by user on 08/12/2017.
 */

public class Calendar extends AppCompatActivity {

    static int idGlobal;

    public static int getIdGlobal() {
        return idGlobal;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int day = sdf.getCalendar().getTime().getDate();
        int month = sdf.getCalendar().getTime().getMonth() + 1;
        CharSequence date = day + "/" + month;
        TextView tv1 = findViewById(R.id.dateAjD);
        tv1.setText("Date d'aujourd'hui : " + date);
    }

    public void CheckTime(View view) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        int day = sdf.getCalendar().getTime().getDate();
        int month = sdf.getCalendar().getTime().getMonth() + 1;
        Intent intent = new Intent(Calendar.this, Fact.class);

        idGlobal = view.getId();
        switch (view.getId()){
            case R.id.img1:
                if (day >= 1 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img2:
                if (day >= 2 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img3:
                if (day >= 3 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img4:
                if (day >= 4 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img5:
                if (day >= 5 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img6:
                if (day >= 6 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img7:
                if (day >= 7 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img8:
                if (day >= 8 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img9:
                if (day >= 9 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img10:
                if (day >= 10 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img11:
                if (day >= 11 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img12:
                if (day >= 12 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img13:
                if (day >= 13 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img14:
                if (day >= 14 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img15:
                if (day >= 15 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img16:
                if (day >= 16 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img17:
                if (day >= 17 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img18:
                if (day >= 18 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img19:
                if (day >= 19 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img20:
                if (day >= 20 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img21:
                if (day >= 21 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img22:
                if (day >= 22 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img23:
                if (day >= 23 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
            case R.id.img24:
                if (day >= 24 && month == 12){
                    startActivity(intent);
                }else{
                    pasMNT();
                }
                break;
        }
    }

    public void pasMNT(){
        Context context = getApplicationContext();
        CharSequence text = "Hey faut attendre un peu !";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public void back(View view) {
        Intent intent = new Intent(Calendar.this, Accueil.class);
        startActivity(intent);
    }

}
