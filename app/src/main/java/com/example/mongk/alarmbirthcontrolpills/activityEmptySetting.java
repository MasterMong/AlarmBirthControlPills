package com.example.mongk.alarmbirthcontrolpills;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class activityEmptySetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty_setting);
    }
    public void begin (View view) {
        Intent setCalendar = new Intent(getApplicationContext(), SetCalendarActivity.class);
        startActivity(setCalendar);
        finish();
    }


}
