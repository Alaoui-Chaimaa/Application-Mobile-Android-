package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.allodoc.R;

public class ListeSpecialites extends AppCompatActivity {

    private String tel;
    private CardView generaliste;
    private CardView cardiologue;
    private CardView ophtalmologue;
    private CardView neurologue;
    private CardView rhumatologue;
    private CardView gynecologue;
    private CardView psychiatre;
    private CardView otorhinologue;
    private CardView pneumologue;
    private CardView dermatologue;
    private CardView gastroenterologue;
    private CardView dentiste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_specialites);
        Intent intent=getIntent();
        tel=intent.getStringExtra("tel");
        generaliste=(CardView)findViewById(R.id.generaliste);
        cardiologue=(CardView)findViewById(R.id.cardiologue);
        ophtalmologue=(CardView)findViewById(R.id.ophtalmologue);
        neurologue=(CardView)findViewById(R.id.neurologue);
        rhumatologue=(CardView)findViewById(R.id.rhumatologue);
        gynecologue=(CardView)findViewById(R.id.gynecologue);
        psychiatre=(CardView)findViewById(R.id.psychiatre);
        otorhinologue=(CardView)findViewById(R.id.oto_rhino_laryngologie);
        pneumologue=(CardView)findViewById(R.id.pneumologie);
        dermatologue=(CardView)findViewById(R.id.dermatologue);
        gastroenterologue=(CardView)findViewById(R.id.gastroenterologue);
        dentiste=(CardView)findViewById(R.id.dentiste);
        generaliste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","M??decin_g??n??raliste");
                startActivity(intent1);

            }
        });
        cardiologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Cardiologie");
                startActivity(intent1);

            }
        });
        ophtalmologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Ophtalmologie");
                startActivity(intent1);

            }
        });
        neurologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Neurologie");
                startActivity(intent1);

            }
        });
        rhumatologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Rhumatologie");
                startActivity(intent1);

            }
        });
        gynecologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Gyn??cologue");
                startActivity(intent1);

            }
        });
        psychiatre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Psychiatrie");
                startActivity(intent1);

            }
        });
        otorhinologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Oto_rhino_laryngologie ");
                startActivity(intent1);

            }
        });
        pneumologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Pneumologie");
                startActivity(intent1);

            }
        });
        dermatologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Dermatologie_et_v??n??r??ologie");
                startActivity(intent1);

            }
        });
        gastroenterologue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Gastro_ent??rologie_et_h??patologie");
                startActivity(intent1);

            }
        });
        dentiste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(ListeSpecialites.this,SearchingMedecin.class);
                intent1.putExtra("tel",tel);
                intent1.putExtra("sp??cialit??","Chirurgien_Dentiste");
                startActivity(intent1);

            }
        });








    }
}
