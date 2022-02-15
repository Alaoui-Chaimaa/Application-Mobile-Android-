package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.allodoc.R;

public class Recherche extends AppCompatActivity {
    private Button btn_medecin;
    private String tel;
    private Toolbar toolbar;
    private Button btn_rdv;
    private String tel_p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recherche);
        Intent intent1=getIntent();
        tel_p=intent1.getStringExtra("tel_p");
        btn_medecin=(Button)findViewById(R.id.btn_medecin);
        btn_rdv=(Button)findViewById(R.id.btn_rendez_vous);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        toolbar.inflateMenu(R.menu.my_menu);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId()==R.id.item2)
                {
                    Intent intent=new Intent(Recherche.this,MainActivity.class);
                    startActivity(intent);
                }else  if(item.getItemId()==R.id.item1)
                {
                    Intent intent=new Intent(Recherche.this,ProfilPatient

                            .class);
                    startActivity(intent);
                }



                return true;
            }
        });
        Intent intent=getIntent();
        tel=intent.getStringExtra("tel");
        btn_medecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recherche_medecin=new Intent(Recherche.this,ListeSpecialites.class);
                recherche_medecin.putExtra("tel",tel);
                startActivity(recherche_medecin);
            }
        });
        btn_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultation_rdv=new Intent(Recherche.this,ListRdv.class);
                consultation_rdv.putExtra("tel_patient",tel);
                startActivity(consultation_rdv);
            }
        });
    }


}
