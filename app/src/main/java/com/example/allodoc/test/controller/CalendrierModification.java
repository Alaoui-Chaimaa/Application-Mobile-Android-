package com.example.allodoc.test.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import com.example.allodoc.R;
import com.example.allodoc.test.model.BoiteDeDialogue6;

public class CalendrierModification  extends AppCompatActivity {

    private CalendarView calendar;
    private TextView date_view;
    private String Date;
    private Button btn_confirmer_date;
    private TextView date_cons;
    private Calendar calendrier=Calendar.getInstance();
    private Date dateChoisie=new Date();
    private Date dateSysteme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendrier_modification);
        calendar=(CalendarView)findViewById(R.id.calendar_modify);
        date_view=(TextView)findViewById(R.id.date_view_modify);
        btn_confirmer_date=(Button) findViewById(R.id.btn_confirmer_date);
        date_cons=(TextView) findViewById(R.id.date_cons);
        Intent intent=getIntent();
        dateSysteme=new Date();

        calendar.setOnDateChangeListener(
                new CalendarView
                        .OnDateChangeListener() {
                    @Override

                    // In this Listener have one method
                    // and in this method we will
                    // get the value of DAYS, MONTH, YEARS
                    public void onSelectedDayChange(
                            @NonNull CalendarView view,
                            int year,
                            int month,
                            int dayOfMonth)
                    {

                        // Store the value of date with
                        // format in String type Variable
                        // Add 1 in month because month
                        // index is start with 0
                        Date = dayOfMonth + "-"
                                + (month + 1) + "-" + year;

                        // set this date in TextView for Display
                        date_view.setText(Date);
                        calendrier.set(year,month,dayOfMonth);
                        dateChoisie=calendrier.getTime();

                    }
                });
        btn_confirmer_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Date==null)
                {
                  Date();
                }
                else if(dateChoisie.compareTo(dateSysteme)<0)
                {
                    openDialog6();
                }
                else
                {
                    Intent intentResult=new Intent();
                    intentResult.putExtra("date_modify",Date);
                    setResult(ModifierRdv.RESULT_OK,intentResult);
                    finish();

                }

            }
        });

    }
    public void Date()
    {
        Toast.makeText(this,"Si vous voulez modifier la date de consultation veuillez choisir une date",Toast.LENGTH_LONG).show();
    }
    public void openDialog6()
    {
        BoiteDeDialogue6 alertDialog=new BoiteDeDialogue6();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }

}
