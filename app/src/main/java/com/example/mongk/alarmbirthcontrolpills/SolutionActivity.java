package com.example.mongk.alarmbirthcontrolpills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SolutionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution);

        Button bt30 = (Button) findViewById(R.id.bt30);
        bt30.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
                intentInfo.putExtra("x", getString(R.string.eth30));
                startActivity(intentInfo);
            }
        });

        Button bt20 = (Button) findViewById(R.id.bt20);
        bt20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
                intentInfo.putExtra("x", getString(R.string.eth20));
                startActivity(intentInfo);
            }
        });
    }




}
