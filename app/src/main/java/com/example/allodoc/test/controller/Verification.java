package com.example.allodoc.test.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.allodoc.R;
import com.example.allodoc.test.model.Compte;
import com.example.allodoc.test.model.Profil;

public class Verification extends AppCompatActivity {

    private String code_verify;
    private Button btn_inscription;
    private String code;
    private EditText champ_code;
    private Compte compte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
        Intent intent=getIntent();
        code=intent.getStringExtra(NouveauCompte.EXTRA_CODE);

        champ_code=(EditText)findViewById(R.id.activity_verification_code);
        btn_inscription=(Button)findViewById(R.id.inscrire);




        btn_inscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                code_verify=champ_code.getText().toString();

                verification();
              }
        });

    }
    public void verification()
    {
        if(code_verify.equals(""))
        {
          erreur();
        }
        else
        if (!code_verify.equals(code))
        {
            refus();
        }
        else
        {
            succes();
            Intent compte=new Intent(Verification.this,EnregistrementCompte.class);

            startActivity(compte);
        }
    }
    public void erreur()
    {
        Toast.makeText(this, "Veuillez saisir le code de verification", Toast.LENGTH_LONG).show();
    }
    public void succes()
    {
        Toast.makeText(this, "Inscription réussie", Toast.LENGTH_LONG).show();
    }
    public void refus()
    {
        Toast.makeText(this, "Code erroné , veuillez le resaisir", Toast.LENGTH_LONG).show();
    }

}
