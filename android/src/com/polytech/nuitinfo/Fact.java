package com.polytech.nuitinfo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by user on 08/12/2017.
 */

public class Fact extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fact);

        TextView tv1 = findViewById(R.id.textFunF);
        TextView tv2 = findViewById(R.id.textMoinsFF);

        switch (Calendar.getIdGlobal()){
            case R.id.img1:
                tv1.setText("Elon Musk veut envoyer dans l'espace le modele decapotable de la tesla !");
                tv2.setText("La PREMIERE cause de mort chez les 17-25 ans est la mort au volant !");
                break;
            case R.id.img2:
                tv1.setText("En octobre 2017, le nombre de morts sur les routes de France est stable par rapport au mois d’octobre 2016. ");
                tv2.setText("25% des francais reconnaissent ne pas respecter les limitations de vitesses !");
                break;
            case R.id.img3:
                tv1.setText("Le 28 mai 2017, vers 20h, grâce à l’effet gyroscopique et à un formidable concours de circonstances, une Harley Davidson a pu effectivement circuler, sans conducteur, de Joinville-le-Pont jusqu’au quai de Bercy à Paris.");
                tv2.setText("Un choc a 130 km/h equivaut a tomber du 22eme etage d'un immeuble !");
                break;
            case R.id.img4:
                tv1.setText("Une mamie, qui s'était perdue avec son fauteuil roulant électrique sur une autoroute américaine, a été escortée par la police pour revenir chez elle. Un sacré périple à raison de 9 km/h.");
                tv2.setText("Pres de 10 personnes meurent d'un accident de la route par jour !");
                break;
            case R.id.img5:
                tv1.setText("Un homme, né en 1937, a emprunté à contresens la voie reliant Montluçon à Limoges.");
                tv2.setText("838 femmes sont mortes sur les routes");
                break;
            case R.id.img6:
                tv1.setText("...");
                tv2.setText("2639 hommes sont morts sur les routes");
                break;
            case R.id.img7:
                tv1.setText("...");
                tv2.setText("718 personnes ont été tuées dans un accident impliquant un conducteur novice (permis de moins de 2 ans)²");
                break;
            case R.id.img8:
                tv1.setText("...");
                tv2.setText("Plus de 700 personnes decedees étaient en deux-roues motorisé");
                break;
            case R.id.img9:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img11:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img12:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img13:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img14:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img15:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img16:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img17:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img18:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img19:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img20:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img21:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img22:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img23:
                tv1.setText("...");
                tv2.setText("...");
                break;
            case R.id.img24:
                tv1.setText("...");
                tv2.setText("...");
                break;
        }
    }

    public void back(View view) {

        Intent intent = new Intent(Fact.this, Calendar.class);
        startActivity(intent);

    }

}
