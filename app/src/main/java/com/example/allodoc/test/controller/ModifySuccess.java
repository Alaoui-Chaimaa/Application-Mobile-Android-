package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.allodoc.R;

public class ModifySuccess extends AppCompatActivity {

    private Button btn_chercher_medecin;
    private Button btn_deconnexion;
    private Button btn_consultation_rdv;
    private String tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_success);
        Intent intent=getIntent();
        tel=intent.getStringExtra("tel_p");

        btn_chercher_medecin=(Button)findViewById(R.id.btn_chercher_medecin);
        btn_deconnexion=(Button)findViewById(R.id.btn_deconnexion);
        btn_consultation_rdv=(Button) findViewById(R.id.btn_consultation_rdv);

        btn_chercher_medecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent acceuil=new Intent(ModifySuccess.this,SearchingMedecin.class);
                startActivity(acceuil);
            }
        });
        btn_deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deconnexion=new Intent(ModifySuccess.this,MainActivity.class);
                startActivity(deconnexion);
            }
        });
        btn_consultation_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rdv=new Intent(ModifySuccess.this,ListRdvModify.class);
                rdv.putExtra("tel_p",tel);
                startActivity(rdv);
               
            }
        });
    }
}


