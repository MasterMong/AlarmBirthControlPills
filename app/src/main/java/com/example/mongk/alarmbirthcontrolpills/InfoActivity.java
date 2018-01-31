package com.example.mongk.alarmbirthcontrolpills;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        WebView htmlInfo = (WebView) findViewById(R.id.webviewInfo);
        WebSettings ws = htmlInfo.getSettings();

        Intent intent = getIntent();

        String url = intent.getStringExtra("x");
        //Toast.makeText(getApplicationContext(), url, Toast.LENGTH_LONG ).show();
        htmlInfo.loadUrl(url);
    }
}
