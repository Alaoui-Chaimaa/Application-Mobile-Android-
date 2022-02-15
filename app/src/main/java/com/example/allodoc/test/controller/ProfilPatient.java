package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.Compte;

public class ProfilPatient extends AppCompatActivity {

    private TextView nom_patient;
    private TextView email_patient;
    private TextView tel_patient;

    private String nom;
    private String email;
    private String tel;

    private AccesLocal acces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        acces=new AccesLocal(this);
        setContentView(R.layout.activity_profil_patient);
        nom_patient=(TextView)findViewById(R.id.nom_patient);
        email_patient=(TextView)findViewById(R.id.email_patient);
        tel_patient=(TextView)findViewById(R.id.tel_patient);

        SharedPreferences sharedPreferences = getSharedPreferences("compte", MODE_PRIVATE);
        tel=sharedPreferences.getString("tel","");
        try {
            nom=acces.getNomPatient(tel);
            email=acces.getEmailPatient(tel);

        }catch (NullPointerException ignored)
        {

        }
        nom_patient.setText(nom);
        tel_patient.setText(tel);
        email_patient.setText(email);



    }
}
