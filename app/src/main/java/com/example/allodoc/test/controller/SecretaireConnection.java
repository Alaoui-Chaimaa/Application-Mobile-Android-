package com.example.allodoc.test.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;

public class SecretaireConnection extends AppCompatActivity {

    private Button btn_secretaire_cnx;
    private EditText nom_docteur_s;
    private EditText identifiant;
    private String nom;
    private String Id;
    private AccesLocal acces;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secretaire_connection);
        btn_secretaire_cnx=(Button)findViewById(R.id.btn_secretaire_cnx);
        nom_docteur_s=(EditText)findViewById(R.id.nom_docteur_s);
        identifiant=(EditText)findViewById(R.id.identifiant);
        acces=new AccesLocal(this);


        btn_secretaire_cnx.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                nom=nom_docteur_s.getText().toString();
                Id=identifiant.getText().toString();
                verifier();

            }
        });
    }
    public void verifier()
    {
        if(nom.equals(""))
        {
            Toast.makeText(this,"Veuillez saisir le nom du médecin avec lequel vous travaillez",Toast.LENGTH_SHORT).show();
        }
        else if(Id.equals(""))
        {
            Toast.makeText(this,"Veuillez saisir votre identifiant",Toast.LENGTH_SHORT).show();
        }else if(Id.length()!=6)
        {
            Toast.makeText(this,"L'identifiant doit contenir 6 caractères",Toast.LENGTH_SHORT).show();
        }else if(acces.secretaire_existe(nom,Id)==1)
        {
            Toast.makeText(this,"Connexion Réussie",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(SecretaireConnection.this,AcceuilSecretaire.class);
            intent.putExtra("nom_docteur",nom);
            startActivity(intent);
        }else if(acces.secretaire_existe(nom,Id)==0)
        {
            Toast.makeText(this,"Identifiant erroné , veuillez le resaisir",Toast.LENGTH_SHORT).show();
        }else if(acces.secretaire_existe(nom,Id)==-1)
        {
            Toast.makeText(this,"Ce compte n'existe pas",Toast.LENGTH_SHORT).show();
        }

    }
}
