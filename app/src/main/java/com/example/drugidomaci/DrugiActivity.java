package com.example.drugidomaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.drugidomaci.model.Currency;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

import java.util.List;

public class DrugiActivity extends AppCompatActivity {
    Spinner spinnerfrom;
    Spinner spinnerto;
    EditText numberFrom;
    EditText numberTo;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerfrom=findViewById(R.id.spinner);
        spinnerto=findViewById(R.id.spinner3);
        numberFrom=findViewById(R.id.editText);
        numberTo=findViewById(R.id.editText2);
        button= findViewById(R.id.button);
        List<Currency> valute=Arrays.asList(Currency.class.getEnumConstants());
       ArrayAdapter<Currency>adapter= new ArrayAdapter<Currency>(this,android.R.layout.simple_spinner_dropdown_item,valute);
       spinnerfrom.setAdapter(adapter);
        spinnerto.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                metoda();
            }
        });

    }

    public void metoda(){
        int broj=1;
         try {
            broj = Integer.valueOf(numberFrom.getText().toString());
        }
        catch (NumberFormatException e){
        numberFrom.setText(String.valueOf(1));
        }
        Currency curr= (Currency)spinnerfrom.getSelectedItem();
        Currency to= (Currency) spinnerto.getSelectedItem();
        Vrati vrati= new Vrati(curr,to,broj);
        vrati.execute();


    }
    public class Vrati extends AsyncTask<String, Integer, JSONObject> {
        Currency c1;
        Currency c2;
        int broj;
        Vrati(Currency c1,Currency c2,int broj){
            this.c1=c1;
            this.c2=c2;
    this.broj=broj;

        }
        @Override
        protected JSONObject doInBackground(String... strings) {
            try {
                publishProgress(50);
                JSONObject json;

              URL url = new URL("https://free.currconv.com/api/v7/convert?q="+c1.name()+"_"+c2.name()+"&compact=ultra&apiKey=47508239836cd7e70e22");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    String line = bufferedReader.readLine();
                    json=new JSONObject(line);
                    return json;

                }
            } catch (ArrayIndexOutOfBoundsException e) {
              } catch (Exception ex) { }
            return null;
        }


        @Override
        protected void onPostExecute(final JSONObject jsonObjekat) {
            super.onPostExecute(jsonObjekat);
            double str= 0;
            try {
                str = jsonObjekat.getDouble(c1.name()+"_"+c2.name());
            } catch (JSONException e) {
                e.printStackTrace();
            }
            double numero=str*broj;
            numberTo.setText(String.valueOf(numero));

        }
    }

}
