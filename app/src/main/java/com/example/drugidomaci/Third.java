package com.example.drugidomaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.drugidomaci.model.Lenght;

import java.util.Arrays;
import java.util.List;

public class Third extends AppCompatActivity {
    Spinner spinnerfrom;
    Spinner spinnerto;
    EditText numberFrom;
    EditText numberTo;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        spinnerfrom=findViewById(R.id.spinner2);
        spinnerto=findViewById(R.id.spinner4);
        numberFrom=findViewById(R.id.editText3);
        numberTo=findViewById(R.id.editText4);
        button= findViewById(R.id.button4);
        List<Lenght> duzine= Arrays.asList(Lenght.class.getEnumConstants());
        ArrayAdapter<Lenght> adapter1= new ArrayAdapter<Lenght>(this,android.R.layout.simple_spinner_dropdown_item,duzine);
        spinnerfrom.setAdapter(adapter1);
        spinnerto.setAdapter(adapter1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                metoda();
            }
        });
    }

    private void metoda() {
            double broj=1;
            try {
                broj = Double.valueOf(numberFrom.getText().toString());
            }
            catch (NumberFormatException e){
                numberFrom.setText(String.valueOf(1));
            }
            Lenght curr= (Lenght) spinnerfrom.getSelectedItem();
            Lenght to= (Lenght) spinnerto.getSelectedItem();

            numberTo.setText(String.valueOf(broj*to.value()/curr.value()));


        }

}
