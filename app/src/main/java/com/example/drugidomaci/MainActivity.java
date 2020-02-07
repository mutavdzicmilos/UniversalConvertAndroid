package com.example.drugidomaci;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
public class MainActivity extends AppCompatActivity {

    Button valute;
    Button duzine;
    Button tezine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drugi);
        valute= findViewById(R.id.button2);
        duzine= findViewById(R.id.button3);
        tezine=findViewById(R.id.button4);
        tezine=findViewById(R.id.button5);
    }
    public void naKlik(View view) {
        Intent activityChangeIntent = new Intent(this, DrugiActivity.class);
        this.startActivity(activityChangeIntent);
    }
    public void naKlik2(View view) {
        Intent activityChangeIntent = new Intent(this, Third.class);
        this.startActivity(activityChangeIntent);
    }
    public void naKlik3(View view) {
        Intent activityChangeIntent = new Intent(this, Forth.class);
        this.startActivity(activityChangeIntent);
    }
    public void naKlik4(View view) {
        Intent activityChangeIntent = new Intent(this, Fifth.class);
        this.startActivity(activityChangeIntent);
    }
    public void naKlik5(View view) {
        Intent activityChangeIntent = new Intent(this, Sixth.class);
        this.startActivity(activityChangeIntent);
    }

}
