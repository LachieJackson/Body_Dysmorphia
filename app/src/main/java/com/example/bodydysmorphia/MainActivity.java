package com.example.bodydysmorphia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button yes = (Button)findViewById(R.id.Yes);
        Button no = (Button)findViewById(R.id.No);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //change to new activity
                Intent intent = UnitChoice.getIntent(MainActivity.this);
                startActivityForResult(intent, 1);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = "too young for BMI";
                Snackbar snackbar = Snackbar.make(findViewById(view.getId()),message,Snackbar.LENGTH_SHORT);
                snackbar.show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(requestCode == 1) {
            String choice = UnitChoice.getResult(data);
            Intent forInput = new Intent(MainActivity.this, InputScreen.class);
            forInput.putExtra("units",choice);
            startActivityForResult(forInput,2);
        }
        else if(requestCode == 2){

        }
    }
}