package com.example.allodoc.test.controller;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.AdapterRdv;
import com.example.allodoc.test.model.AdapterRdvSecretaire;
import com.example.allodoc.test.model.Rdv;

import java.util.List;

public class ListRdvSecretaire extends AppCompatActivity {
    private ListView listView;
    private AdapterRdvSecretaire adapter;
    private List<Rdv> listItem;
    private AccesLocal accesBD;
    private String nom_docteur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rdv_secretaire);
        accesBD = new AccesLocal(this);
        listView = (ListView) findViewById(R.id.listRdvDispo);
        Intent intent=getIntent();
        nom_docteur=intent.getStringExtra("nom_docteur");
        try
        {
            listItem = accesBD.getRdvSecretaire(nom_docteur);
            adapter = new AdapterRdvSecretaire(this, listItem);
            listView.setAdapter(adapter);

            if(listItem.isEmpty())
            {
                Intent list_vide=new Intent(ListRdvSecretaire.this,ListRdvVide.class);
                startActivity(list_vide);
            }


        }catch (NullPointerException ignored)
        {

        }


    }
}
