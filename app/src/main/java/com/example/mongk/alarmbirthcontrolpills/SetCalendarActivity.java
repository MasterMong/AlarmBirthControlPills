package com.example.mongk.alarmbirthcontrolpills;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class SetCalendarActivity extends AppCompatActivity {
    private TextView txtDate;
    private TextView txtTime;
    private DatePickerDialog.OnDateSetListener txtDateSetListener;
    private TimePickerDialog.OnTimeSetListener txtTimeSetListener;
    //private String[] txt = new String[7];
    private Map<String,String> txt = new HashMap<String,String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_calendar);

        txt.put("pill","");
        txt.put("circle","");
        txt.put("year","");
        txt.put("month","");
        txt.put("day","");
        txt.put("hour","");
        txt.put("minute","");

        //Pills List
        Spinner listPills = (Spinner) findViewById(R.id.spinnerPills);
        final String[] pills = getResources().getStringArray(R.array.pills);
        ArrayAdapter<String> adapterPills = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, pills);
        listPills.setAdapter(adapterPills);
        listPills.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                txt.put("pill", pills[position]);
                /*Toast.makeText(getApplicationContext(),
                        "Select : " + txt.get("pill"),
                        Toast.LENGTH_SHORT).show();
                */
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        // -- END --

        // Pick Date
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dateDialog = new DatePickerDialog(
                    SetCalendarActivity.this,
                    txtDateSetListener,
                    year,month,day);
                dateDialog.show();
            }
        });

        txtDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                //month = month + 1;
                //String date = day + "/" + month + "/" + year;
                txt.put("year",String.valueOf(year));
                txt.put("month",String.valueOf(month));
                txt.put("day",String.valueOf(day));
                txtDate.setText(txt.get("day") + "/" + txt.get("month") + "/" + txt.get("year"));
            }
        };
        // --End--
        
        // Time Picker
        txtTime = (TextView) findViewById(R.id.txtTime);
        txtTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar time = Calendar.getInstance();
                int hour = time.get(Calendar.HOUR_OF_DAY);
                int minute = time.get(Calendar.MINUTE);
                TimePickerDialog timeDialog = new TimePickerDialog(
                    SetCalendarActivity.this,
                    txtTimeSetListener,hour,
                    minute, true);
                timeDialog.show();
            }
        });

        txtTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int h, int m) {
                //String time = h + ":" + m ;
                txt.put("hour", String.valueOf(h));
                txt.put("minute",String.valueOf(m));
                txtTime.setText(txt.get("hour") + "." + txt.get("minute") + " น.");
            }
        };

        // --END--

        /*
        final EditText txtTime = (EditText) findViewById(R.id.txtTime);
        txtTime.setOnClickListener(new AdapterView.OnClickListener(){

            @Override
            public void onClick(View view) {
                txtTime.setText("");
            }
        });
        */
    }

    // Set Day Circle
    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch(view.getId()) {
            case R.id.radio21:
                if (checked)
                    txt.put("circle","21");
                    break;
            case R.id.radio28:
                if (checked)
                    txt.put("circle","28");
                    break;
        }
    }
    // --END--

    // -- Put Setting --
    public void setCalendar (View view) {
        if (txt.get("pill") == "" || txt.get("circle") == "" || txt.get("year") == "" || txt.get("month") == "" || txt.get("day") == "" || txt.get("hour") == "" || txt.get("minute") == "") {
            Toast.makeText(getApplicationContext(),
                    "ตรวจสอบข้อมูลให้เรียบร้อย",
                    Toast.LENGTH_SHORT).show();
        }else{
            SharedPreferences.Editor editor = getSharedPreferences("myPref", MODE_PRIVATE).edit();
            editor.putBoolean("setCalendar", true);
            editor.putString("setPill", txt.get("pill"));
            editor.putInt("setCircle", Integer.valueOf(txt.get("circle")));
            editor.putInt("setYear", Integer.valueOf(txt.get("year")));
            editor.putInt("setMonth", Integer.valueOf(txt.get("month")));
            editor.putInt("setDay", Integer.valueOf(txt.get("day")));
            editor.putInt("setHour", Integer.valueOf(txt.get("hour")));
            editor.putInt("setMinute", Integer.valueOf(txt.get("minute")));
            editor.apply();

            Intent intentHome = new Intent(this, HomeActivity.class);
            startActivity(intentHome);

            finish();
        }

    }
    // --END-
}


