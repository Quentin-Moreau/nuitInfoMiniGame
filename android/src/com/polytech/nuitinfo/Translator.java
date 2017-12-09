package com.polytech.nuitinfo;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.polytech.nuitinfo.NF.HttpHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Howard Alexandre on 19/03/2017.
 */

public class Translator extends AppCompatActivity {
    private ProgressDialog pDialog;
    private Context c=this;
    private String TAG = Translator.class.getSimpleName();
    private Translator instance;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translator);
        instance=this;

        //init spinner
        final Spinner spinner = (Spinner) findViewById(R.id.choixLangue);
        List<String> list = new ArrayList<String>();
        list.add("French -> English");
        list.add("English -> French");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);


        Button traduire = (Button)findViewById(R.id.submitTranslate);
        final EditText aTraduire = (EditText)findViewById(R.id.phraseTanslator);


        traduire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //construction de l'url
                String langue = spinner.getSelectedItem().toString();
                String entreePhrase = aTraduire.getText().toString().replaceAll(" ","%20").toLowerCase();
                String urlTrad = "https://glosbe.com/gapi/translate?";
                if(langue.equals("English -> French")){
                    urlTrad+="from=eng&dest=fra&format=json&phrase="+entreePhrase;
                }else if(langue.equals("French -> English")){
                    urlTrad+="from=fra&dest=eng&format=json&phrase="+entreePhrase;
                }
                new GetTraduction(instance, urlTrad).execute();
            }
        });


        ImageView bouttonRetourTemp=(ImageView)findViewById(R.id.imageView5);
        bouttonRetourTemp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Translator.this,Accueil.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void setTextTraduction(String resultTrad){
        TextView result=(TextView)findViewById(R.id.resultTranslator);
        String texte ="Result: "+resultTrad;
        result.setText(texte);
    }

    private class GetTraduction extends AsyncTask<Void, Void, Void> {
        private String url;
        private Translator translator;
        private String traductionFinale="";

        public GetTraduction(Translator translator, String url){
            this.url=url;
            this.translator=translator;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(c);
            pDialog.setMessage("Traduction en cours...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        // appeler automatiquement après onPreExecute
        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();

            String jsonStr = sh.makeServiceCall(url);

            if (jsonStr != null) {
                try {

                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONArray listTrad = jsonObj.getJSONArray("tuc");
                    String traduction ="";
                    if(listTrad.length()==0){
                        traduction = jsonObj.getString("phrase");
                    }else{
                        JSONObject trad = listTrad.getJSONObject(0);
                        JSONObject phrase = trad.getJSONObject("phrase");
                        traduction=phrase.getString("text");
                    }
                    traductionFinale=traduction.substring(0,1).toUpperCase()+traduction.substring(1);

                } catch (final JSONException e) {
                    Log.e(TAG, "Erreur Json: " + e.getMessage());

                }
            } else {
                Log.e(TAG, "Pas de connexion.");
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (pDialog.isShowing()) {
                pDialog.dismiss();
            }
            translator.setTextTraduction(traductionFinale);
        }

    }
}
