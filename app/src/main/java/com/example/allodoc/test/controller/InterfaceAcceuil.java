package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.allodoc.R;

public class InterfaceAcceuil extends AppCompatActivity {

    private CardView espace_patient;
    private CardView espace_secretaire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface_acceuil);
        espace_patient=(CardView)findViewById(R.id.espace_patient);
        espace_secretaire=(CardView)findViewById(R.id.espace_secretaire);
        espace_patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(InterfaceAcceuil.this,MainActivity.class);
                startActivity(intent1);
            }
        });
        espace_secretaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(InterfaceAcceuil.this,SecretaireConnection.class);
                startActivity(intent2);
            }
        });

    }
}
