package com.example.bodydysmorphia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class UnitChoice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unitchoice);
        Button metric = findViewById(R.id.metric);
        Button imperial = findViewById(R.id.imperial);

        metric.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returndata = new Intent();
                returndata.putExtra("choice","metric");
                setResult(RESULT_OK, returndata);
                finish();
            }
        });

        imperial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returndata = new Intent();
                returndata.putExtra("choice","imperial");
                setResult(RESULT_OK, returndata);
                finish();
            }
        });
    }

    public static Intent getIntent(Context c)
    {
        Intent intent = new Intent(c, UnitChoice.class);
        return intent;
    }

    public static String getResult(Intent intent)
    {
        return intent.getStringExtra("choice");
    }
}
