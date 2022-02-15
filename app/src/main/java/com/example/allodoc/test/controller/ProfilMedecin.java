package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.Profil;

public class ProfilMedecin extends AppCompatActivity {

    private TextView nom_doctor;
    private TextView specialite_doctor;
    private TextView tel_doctor;
    private TextView adresse_doctor;
    private TextView but_consultation;
    private Button btn_date;
    public static AccesLocal acces;
    private String tel;
    private String adresse;
    private String nom;
    private String specialite;
    private String tel_patient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_medecin);
        nom_doctor=(TextView)findViewById(R.id.nom_doctor);
        specialite_doctor=(TextView)findViewById(R.id.specialite_doctor);
        tel_doctor=(TextView)findViewById(R.id.tel_doctor);
        adresse_doctor=(TextView)findViewById(R.id.adresse_doctor);
        but_consultation=(TextView)findViewById(R.id.but_consultation);
        btn_date=(Button)findViewById(R.id.btn_date);
        acces=new AccesLocal(this);
        Intent intent=getIntent();
        tel_patient=intent.getStringExtra("tel");
        Profil p=intent.getParcelableExtra("Item");
        nom=p.getNom_medecin();
        specialite=p.getSpecialite();
        tel=p.getTel();
        adresse=p.getAdresse();
        nom_doctor.setText(nom);
        specialite_doctor.setText(specialite);
        tel_doctor.setText(tel);
        adresse_doctor.setText(adresse);

        btn_date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(but_consultation.getText().toString().equals(""))
                 {
                      erreur();
                 }
                 else
                 {
                     Intent date_consultation=new Intent(ProfilMedecin.this,DateDeConsultation.class);
                     date_consultation.putExtra("nom_medecin",nom);
                     date_consultation.putExtra("lieu_consultation",adresse);
                     date_consultation.putExtra("but_consultation",but_consultation.getText().toString());
                     date_consultation.putExtra("tel_patient",tel_patient);
                     startActivity(date_consultation);
                 }

            }
        });


    }
    public void erreur()
    {


        Toast.makeText(this,"Veuillez saisir le but de consultation",Toast.LENGTH_LONG).show();
    }
}

