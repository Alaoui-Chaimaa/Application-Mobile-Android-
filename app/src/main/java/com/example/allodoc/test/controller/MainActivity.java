package com.example.allodoc.test.controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;


import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;

import static android.provider.Telephony.Mms.Part.TEXT;


public class MainActivity extends AppCompatActivity {

    private Button btn_inscription;
    private Button btn_connexion;

    private EditText num_tel;
    private EditText mot_de_passe;
    private String tel;
    private String pass;
    private static AccesLocal acces_bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        acces_bd=new AccesLocal(this);
        btn_inscription=(Button)findViewById(R.id.btn_inscription);
        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nouveau_compte=new Intent(MainActivity.this,NouveauCompte.class);
                startActivity(nouveau_compte);
            }
        });

       btn_connexion=(Button)findViewById(R.id.btn_connexion);
       num_tel=(EditText)findViewById(R.id.num_tel);
       mot_de_passe=(EditText) findViewById(R.id.mot_de_passe);
       btn_connexion.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
             tel=num_tel.getText().toString();
             pass=mot_de_passe.getText().toString();
             verification_connexion();

           }
       });

    }
    public void verification_connexion() {
        if (tel.equals("")) {
            Toast.makeText(this, "Veuillez remplir Le champ téléphone", Toast.LENGTH_LONG).show();
        } else if (tel.length() != 10) {
            Toast.makeText(this, "Le numéro de tel doit contenir 10 nombres", Toast.LENGTH_LONG).show();
        } else if (isNumber(tel) ==1) {
            Toast.makeText(this, "Le numéro de téléphone ne doit contenir que des nombres", Toast.LENGTH_LONG).show();
        } else if (!tel.substring(0, 2).equals("06") && !tel.substring(0, 2).equals("07")) {
            Toast.makeText(this, "Le numéro de téléphone doit commencer avec 06 ou 07", Toast.LENGTH_LONG).show();
        } else if (pass.equals("")) {
            Toast.makeText(this, "Veuillez saisir votre mot de passe", Toast.LENGTH_LONG).show();
        } else if (acces_bd.compte_existe(tel, pass) == 1) {
            Toast.makeText(this, "Connexion Réussie", Toast.LENGTH_LONG).show();

            SharedPreferences sharedPreferences = getSharedPreferences("compte", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("tel",tel);
            editor.apply();

            Intent recherche =new Intent(MainActivity.this,Recherche.class);
            recherche.putExtra("tel",tel);
            startActivity(recherche);
        } else if (acces_bd.compte_existe(tel, pass) == 0) {
            Toast.makeText(this, "Mot de passe erroné", Toast.LENGTH_LONG).show();
        } else if (acces_bd.compte_existe(tel, pass) == (-1)) {
            Toast.makeText(this, " Numéro de téléphone erroné ", Toast.LENGTH_LONG).show();
        }

    }

    public Integer isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <'0' || s.charAt(i) >'9')
                return 1;

        }
        return 0;
    }

}
