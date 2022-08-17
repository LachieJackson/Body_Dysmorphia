package com.example.bodydysmorphia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class InputScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inputscreen);
        Intent givenIntent = getIntent();
        TextView weightInfo = findViewById(R.id.weightInfo);
        SeekBar weightSlider = findViewById(R.id.weightSlider);
        TextView weightInputUnits = findViewById(R.id.weightInputUnits);
        TextView heightInfo = findViewById(R.id.heightInfo);
        SeekBar heightSlider = findViewById(R.id.heightSlider);
        TextView heightInputUnits = findViewById(R.id.heightInputUnits);
        EditText weightInput = findViewById(R.id.weightInput);
        EditText heightInput = findViewById(R.id.heightInput);
        Button next = findViewById(R.id.next);
        String choice = givenIntent.getStringExtra("units");

        if(choice.equals("imperial")){
            weightInfo.setText("Use slider to input weight in pounds");
        }
        weightSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String prog = String.valueOf(weightSlider.getProgress());
                weightInput.setText(prog);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                String prog = String.valueOf(weightSlider.getProgress());
                weightInput.setText(prog);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                String prog = String.valueOf(weightSlider.getProgress());
                weightInput.setText(prog);
            }
        });
    }
}
