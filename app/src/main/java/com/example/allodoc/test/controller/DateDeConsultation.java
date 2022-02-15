package com.example.allodoc.test.controller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.BoiteDeDialogue;
import com.example.allodoc.test.model.BoiteDeDialogue3;
import com.example.allodoc.test.model.BoiteDeDialogue5;
import com.example.allodoc.test.model.BoiteDeDialogue6;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class DateDeConsultation extends AppCompatActivity {
    CalendarView calender;
    TextView date_view;
    ListView listView;
    ArrayList<String> list;
    private String heure;
    private AccesLocal acces;
    private String Date;
    private Button btn_confirmation;
    private String nom;
    private String lieu_consultation;
    private String but_consultation;
    private String tel_patient;
    private String nom_patient;
    private Calendar calendrier=Calendar.getInstance();
    private Date dateChoisie=new Date();
    private Date dateSysteme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_de_consultation);

        // By ID we can use each component
        // which id is assign in xml file
        // use findViewById() to get the
        // CalendarView and TextView
        calender = (CalendarView)
                findViewById(R.id.calender);
        date_view = (TextView)
                findViewById(R.id.date_view);
        listView=(ListView)findViewById(R.id.listheure);
        btn_confirmation=(Button)findViewById(R.id.btn_confirmation);
        Intent intent=getIntent();
        nom=intent.getStringExtra("nom_medecin").toString();
        lieu_consultation=intent.getStringExtra("lieu_consultation").toString();
        but_consultation=intent.getStringExtra("but_consultation").toString();
        tel_patient=intent.getStringExtra("tel_patient");
        acces=new AccesLocal(this);
        nom_patient=acces.getNomPatient(tel_patient);
        dateSysteme=new Date();
        list=new ArrayList<>();
        list.add("8:30");
        list.add("9:00");
        list.add("9:30");
        list.add("10:00");
        list.add("10:30");
        list.add("11:00");
        list.add("11:30");
        list.add("12:00");
        list.add("14:30");
        list.add("15:00");
        list.add("15:30");
        list.add("16:00");
        list.add("16:30");
        list.add("17:00");
        list.add("17:30");
        list.add("18:00");
        // Add Listener in calendar
        calender.setOnDateChangeListener(
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
                                 Date
                                        = dayOfMonth + "-"
                                        + (month + 1) + "-" + year;

                                // set this date in TextView for Display
                                date_view.setText(Date);
                                calendrier.set(year,month,dayOfMonth);
                                dateChoisie=calendrier.getTime();

                            }
                        });

        final ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                heure=list.get(position).toString();


            }
        });
        btn_confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  try {
                    if(Date==null)
                    {
                        Date();
                    }
                        else if(heure==null)
                    {
                        Heure();
                    }else if(dateChoisie.compareTo(dateSysteme)<0)
                    {
                        openDialog6();
                    }
                   else if (acces.RendezVousExiste(nom, heure, Date) == 1) {

                        openDialog();


                    } else if (acces.RendezVousExisteJour(tel_patient, nom, Date) == 1) {

                        openDialog2();
                    } else {
                        acces.ajoutRendezVous(nom_patient, tel_patient, nom, but_consultation, Date, heure, lieu_consultation);
                        openDialog3();
                    }


                }catch (NullPointerException ignored)
                {

                }



            }
        });

    }

    public void Erreur()
    {
        Toast.makeText(this,"date"+dateSysteme.toString(),Toast.LENGTH_LONG).show();
    }
    public void Succes()
    {
        Toast.makeText(this,"Rendez vous enregistré",Toast.LENGTH_LONG);
    }
    public void Date()
    {
        Toast.makeText(this,"Veuillez choisir la date du rendez-vous",Toast.LENGTH_LONG).show();
    }
    public void Heure()
    {
        Toast.makeText(this,"Veuillez choisir l'heure du rendez-vous",Toast.LENGTH_LONG).show();

    }
    public void openDialog()
    {
        BoiteDeDialogue alertDialog=new BoiteDeDialogue();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }
    public void openDialog2()
    {
        BoiteDeDialogue5 alertDialog=new BoiteDeDialogue5();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }
    public void openDialog3()
    {
        BoiteDeDialogue3 alertDialog=new BoiteDeDialogue3();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }
    public void openDialog6()
    {
        BoiteDeDialogue6 alertDialog=new BoiteDeDialogue6();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }

}

