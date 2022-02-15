package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.allodoc.R;

public class ModificationRdvSecretaire extends AppCompatActivity {
    private Button btn_ajout_nv_rdv;
    private Button btn_deconnexion_secretaire;
    private Button btn_consultation_rdv_dispo;
    private String nom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modification_rdv_secretaire);
        btn_ajout_nv_rdv=(Button)findViewById(R.id.btn_ajout_nv_rdv);
        btn_deconnexion_secretaire=(Button)findViewById(R.id.btn_deconnexion_secretaire);
        btn_consultation_rdv_dispo=(Button)findViewById(R.id.btn_consultation_rdv_dispo);
        Intent intent=getIntent();
        nom=intent.getStringExtra("nom_medecin");
        btn_deconnexion_secretaire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ModificationRdvSecretaire.this,SecretaireConnection.class);
                startActivity(intent1);
            }
        });
        btn_consultation_rdv_dispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(ModificationRdvSecretaire.this,ListRdvSecretaire.class);
                intent2.putExtra("nom_docteur",nom);
                startActivity(intent2);
            }
        });
        btn_ajout_nv_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(ModificationRdvSecretaire.this,AjouterNvRdv.class);
                intent3.putExtra("nom_médecin",nom);
                startActivity(intent3);
            }
        });
    }
}
