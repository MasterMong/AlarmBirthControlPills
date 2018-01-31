package com.example.mongk.alarmbirthcontrolpills;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();

        SharedPreferences prefs = getSharedPreferences("myPref", MODE_PRIVATE);
        if(!Objects.equals(prefs.getString("firstStart", null), "nope")) {
            //Toast.makeText(getApplicationContext(), prefs.getString("firstStart", null), Toast.LENGTH_LONG ).show();
            editor.putBoolean("setCalendar", false);
        }

        editor.putString("firstStart", "nope");
        editor.apply();

        Button btNotification = (Button) findViewById(R.id.btNotification);
        btNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent na = new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(na);

            }
        });
    }

    public void callInfo(View view) {
        Intent intentInfo = new Intent(getApplicationContext(), InfoActivity.class);
        intentInfo.putExtra("x", getString(R.string.info));
        startActivity(intentInfo);
    }
    public void callGuide(View view) {
        Intent intentGuide = new Intent(getApplicationContext(), GuideActivity.class);
        startActivity(intentGuide);
    }

    public void callSolution(View view) {
        Intent intentSolution = new Intent(this, SolutionActivity.class);
        startActivity(intentSolution);
    }

    public void callCalendar(View view) {
        SharedPreferences prefs = getSharedPreferences("myPref", MODE_PRIVATE);
        if(!prefs.getBoolean("setCalendar", Boolean.parseBoolean(null))) {
            //Toast.makeText(getApplicationContext(), "calendar not set", Toast.LENGTH_LONG ).show();
            Intent intentEmpty = new Intent(getApplicationContext(), activityEmptySetting.class);
            startActivity(intentEmpty);
        }else {
            Toast.makeText(getApplicationContext(),
                    String.valueOf(prefs.getInt("setYear",0)),
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void clear(View view) {
        SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();
        editor.putBoolean("setCalendar", false);
        //editor.clear();
        editor.commit();
    }
}
