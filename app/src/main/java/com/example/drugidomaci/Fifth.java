package com.example.drugidomaci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.drugidomaci.model.Temperature;
import com.example.drugidomaci.model.Weight;

import java.util.Arrays;
import java.util.List;

public class Fifth extends AppCompatActivity {

    Spinner spinnerfrom;
    Spinner spinnerto;
    EditText numberFrom;
    EditText numberTo;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth2);
        spinnerfrom=findViewById(R.id.spinner2);
        spinnerto=findViewById(R.id.spinner4);
        numberFrom=findViewById(R.id.editText3);
        numberTo=findViewById(R.id.editText4);
        button= findViewById(R.id.button4);
        List<Temperature> tezine= Arrays.asList(Temperature.class.getEnumConstants());
        ArrayAdapter<Temperature> adapter1= new ArrayAdapter<Temperature>(this,android.R.layout.simple_spinner_dropdown_item,tezine);
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


        double temp=0;

        Temperature curr= (Temperature) spinnerfrom.getSelectedItem();
        Temperature to= (Temperature) spinnerto.getSelectedItem();
        if(curr.equals(to)){
            numberTo.setText(String.valueOf(broj));
            return;
        }
    if(curr.equals(Temperature.Fahrenheit)){
        if(to.equals(Temperature.Celsius))
        temp=(broj-32)*0.5556;
        if(to.equals(Temperature.Kelvin))
            temp=(broj-32)*0.5556+273.15;

        numberTo.setText(String.valueOf(temp));
        return;
    }else{
        if(curr.equals(Temperature.Celsius)){
            if(to.equals(Temperature.Fahrenheit)){
                temp=(broj*1.8)+32;
            }
             if(to.equals(Temperature.Kelvin)){
                 temp=broj+273.15;
             }

            numberTo.setText(String.valueOf(temp));
            return;
        }
            if(to.equals(Temperature.Celsius)){
                temp=(broj-273.15);
            }else{
                temp=broj*9/5 - 459.67;
            }
        numberTo.setText(String.valueOf(temp));
        return;
    }








    }
}
