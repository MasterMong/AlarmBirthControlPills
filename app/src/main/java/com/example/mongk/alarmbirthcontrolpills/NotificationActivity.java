package com.example.mongk.alarmbirthcontrolpills;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.util.Arrays;

public class NotificationActivity extends AppCompatActivity {

    String[] value = new String[]{
            "เลื่อน 15 นาที",
            "เลื่อน 30 นาที",
            "กินแล้ว"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
                AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(NotificationActivity.this);
                alertdialogbuilder.setTitle("Select A Item ");
                alertdialogbuilder.setItems(value, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String selectedText = Arrays.asList(value).get(which);
                        finish();
                        //gotoCalendarView
                    }
                });
                AlertDialog dialog = alertdialogbuilder.create();
                dialog.show();
    }
}
