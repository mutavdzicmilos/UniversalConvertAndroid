package com.example.drugidomaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.drugidomaci.model.Lenght;
import com.example.drugidomaci.model.Weight;

import java.util.Arrays;
import java.util.List;

public class Forth extends AppCompatActivity {
    Spinner spinnerfrom;
    Spinner spinnerto;
    EditText numberFrom;
    EditText numberTo;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forth2);
        spinnerfrom=findViewById(R.id.spinner2);
        spinnerto=findViewById(R.id.spinner4);
        numberFrom=findViewById(R.id.editText3);
        numberTo=findViewById(R.id.editText4);
        button= findViewById(R.id.button4);
        List<Weight> tezine= Arrays.asList(Weight.class.getEnumConstants());
        ArrayAdapter<Weight> adapter1= new ArrayAdapter<Weight>(this,android.R.layout.simple_spinner_dropdown_item,tezine);
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
        Weight curr= (Weight) spinnerfrom.getSelectedItem();
        Weight to= (Weight) spinnerto.getSelectedItem();

        numberTo.setText(String.valueOf(broj*to.value()/curr.value()));


    }
}
