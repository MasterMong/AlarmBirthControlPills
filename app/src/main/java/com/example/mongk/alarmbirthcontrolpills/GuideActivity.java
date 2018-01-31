package com.example.mongk.alarmbirthcontrolpills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class GuideActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        Button btInfo = (Button) findViewById(R.id.btInfo);
        btInfo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
                intentInfo.putExtra("x", getString(R.string.info));
                startActivity(intentInfo);
            }
        });
        Button btGuide = (Button) findViewById(R.id.btGuide);
        btGuide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
                intentInfo.putExtra("x", getString(R.string.guide));
                startActivity(intentInfo);
            }
        });
        Button btEffect = (Button) findViewById(R.id.btEffect);
        btEffect.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
                intentInfo.putExtra("x", getString(R.string.effect));
                startActivity(intentInfo);
            }
        });
        Button btPills = (Button) findViewById(R.id.btPills);
        btPills.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
                intentInfo.putExtra("x", getString(R.string.pills));
                startActivity(intentInfo);
            }
        });
    }
}
