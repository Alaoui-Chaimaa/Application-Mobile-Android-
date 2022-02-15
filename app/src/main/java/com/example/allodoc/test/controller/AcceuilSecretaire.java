package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.allodoc.R;

public class AcceuilSecretaire extends AppCompatActivity {
    private Button btn_rdv_dispo;
    private Button btn_ajout_rdv;
    private String nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil_secretaire);
        Intent intent=getIntent();
        nom=intent.getStringExtra("nom_docteur");
        Toolbar toolbar=(Toolbar)findViewById(R.id.menu_acceuil);
        toolbar.inflateMenu(R.menu.menu1);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.item1)
                {
                    Intent intent=new Intent(AcceuilSecretaire.this,SecretaireConnection.class);
                    startActivity(intent);
                }
                return true;
            }
        });
        btn_rdv_dispo=(Button)findViewById(R.id.btn_rdv_dispo);
        btn_ajout_rdv=(Button)findViewById(R.id.btn_ajout_rdv);
        btn_rdv_dispo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rdv_dispo=new Intent(AcceuilSecretaire.this,ListRdvSecretaire.class);
                rdv_dispo.putExtra("nom_docteur",nom);
                startActivity(rdv_dispo);
            }
        });
        btn_ajout_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ajout_rdv=new Intent(AcceuilSecretaire.this,AjouterNvRdv.class);
                ajout_rdv.putExtra("nom_médecin",nom);
                startActivity(ajout_rdv);
            }
        });
    }
}
