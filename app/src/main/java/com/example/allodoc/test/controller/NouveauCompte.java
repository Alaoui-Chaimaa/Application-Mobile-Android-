package com.example.allodoc.test.controller;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.Compte;

import java.util.Random;
import java.util.regex.Pattern;

import static java.lang.Math.*;

public class NouveauCompte extends AppCompatActivity {

    public static final String EXTRA_CODE="com.example.allodoc.test.cotroller.code";
    private EditText nomm;
    private EditText num_tel;
    private EditText email;
    private EditText pass_conf;
    private EditText password;
    private Button btn_inscription;
    private String nom;
    private String tel;
    private String mail;
    private String password_conf;
    private String pass;
    private String message;
    private static Compte compte;
    private static AccesLocal acceslocal;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nouveau_compte);
        nomm = (EditText) findViewById(R.id.nom_complet);
        num_tel = (EditText) findViewById(R.id.num_tel);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        pass_conf = (EditText) findViewById(R.id.password_conf);
        btn_inscription = (Button) findViewById(R.id.inscrire);
        acceslocal=new AccesLocal(this);
        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom=nomm.getText().toString();
                tel = num_tel.getText().toString();
                mail = email.getText().toString();
                pass = password.getText().toString();
                password_conf = pass_conf.getText().toString();

                verifier_champ();




            }
        });


    }


    public void verifier_champ() {

        if (nom.equals("")) {
            Toast.makeText(this, "Veuillez saisir votre nom", Toast.LENGTH_LONG).show();
        }
        else if (tel.equals("")) {
            Toast.makeText(this, "Veuillez remplir Le champ téléphone", Toast.LENGTH_LONG).show();
        } else if (tel.length() != 10) {
            Toast.makeText(this, "Le numéro de tel doit contenir 10 nombres", Toast.LENGTH_LONG).show();
        } else if(isNumber(tel)==1)
        {
            Toast.makeText(this, "Le numéro de téléphone ne doit contenir que des nombres", Toast.LENGTH_LONG).show();
        }
        else if (!tel.substring(0,2).equals("06")&&!tel.substring(0,2).equals("07")) {
            Toast.makeText(this, "Le numéro de téléphone doit commencer avec 06 ou 07", Toast.LENGTH_LONG).show();
        }
       else if (acceslocal.num_existe(tel)==1) {
            Toast.makeText(this, "Ce numéro existe déjà , Veuiller saisir un nouveau numéro", Toast.LENGTH_LONG).show();
        }
        else if (mail.equals("")) {
            Toast.makeText(this, "Veuillez remplir Le champ email", Toast.LENGTH_LONG).show();
        } else if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail) == false) {
            Toast.makeText(this, "Veuillez respecter la syntaxe d'email", Toast.LENGTH_LONG).show();
        }  else if (pass.equals("")) {
            Toast.makeText(this, "Veuillez saisir un mot de passe", Toast.LENGTH_LONG).show();
        }
        else if (password_conf.equals("")) {
            Toast.makeText(this, "Veuillez confirmer votre mot de passe", Toast.LENGTH_LONG).show();
        }
        else if (!pass.equals(password_conf)) {
            Toast.makeText(this, "La confirmation n'est pas compatible avec le mot de passe saisi", Toast.LENGTH_LONG).show();
        }
        else
        {

            Random r=new Random();
            int code=r.nextInt(9000);
            compte=new Compte(code,nom,tel,mail,pass);
            message="Votre code de verification est:"+code;
            acceslocal.ajoutCompte(compte);
            String code_envoi=""+code;
            SmsManager.getDefault().sendTextMessage(tel,"AlloDoc",message,null,null);
            Intent verification =new Intent(NouveauCompte.this,Verification.class);
            verification.putExtra(EXTRA_CODE,code_envoi);
            startActivity(verification);
        }




    }


    public Integer isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <'0' || s.charAt(i) >'9')
            {
                return 1;
            }
        }
        return 0;
    }



}

