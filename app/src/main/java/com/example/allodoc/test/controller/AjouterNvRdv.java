package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.BoiteDeDialogue;
import com.example.allodoc.test.model.BoiteDeDialogue1;
import com.example.allodoc.test.model.BoiteDeDialogue4;

public class AjouterNvRdv extends AppCompatActivity {

    private EditText nom_cons_p;
    private EditText tel_cons_p;
    private EditText medecin_cons_p;
    private EditText  but_cons_p;
    private EditText date_cons_p;
    private EditText heure_cons_p;
    private EditText lieu_cons_p;
    private Button confirmer_ajout;
    private String nom;
    private String tel;
    private String medecin;
    private String  but_cons;
    private String date;
    private String heure;
    private String lieu;
    private AccesLocal acces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_nv_rdv);
        acces=new AccesLocal(this);
         Intent intent=getIntent();
         medecin=intent.getStringExtra("nom_médecin");
         try {
             lieu=acces.getLieu(medecin);
         }catch(NullPointerException ignored)
         {

         }
        nom_cons_p=(EditText)findViewById(R.id.nom_cons_p);
        tel_cons_p=(EditText)findViewById(R.id.tel_cons_p);
        medecin_cons_p=(EditText)findViewById(R.id.medecin_cons_p);
        but_cons_p=(EditText)findViewById(R.id.but_cons_p);
        date_cons_p=(EditText)findViewById(R.id.date_cons_p);
        heure_cons_p=(EditText)findViewById(R.id.heure_cons_p);
        lieu_cons_p=(EditText)findViewById(R.id.lieu_cons_p);
        confirmer_ajout=(Button)findViewById(R.id.confirmer_ajout);
        medecin_cons_p.setText(medecin);
        lieu_cons_p.setText(lieu);
        confirmer_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               nom=nom_cons_p.getText().toString();
               tel=tel_cons_p.getText().toString();
              /* medecin=medecin_cons_p.getText().toString();*/

               but_cons=but_cons_p.getText().toString();
               date=date_cons_p.getText().toString();
               heure=heure_cons_p.getText().toString();
               /*lieu=lieu_cons_p.getText().toString();*/
               verification();

            }
        });
    }
    public void verification() {
        if (nom.equals("")) {
            Toast.makeText(this, "Veuillez saisir le nom du patient", Toast.LENGTH_LONG).show();
        } else if (tel.equals("")) {
            Toast.makeText(this, "Veuillez saisir le tel du patient", Toast.LENGTH_LONG).show();
        } else if (isNumber(tel) == 0) {
            Toast.makeText(this, "Le numéro de téléphone ne doit contenir que des nombres", Toast.LENGTH_LONG).show();
        } else if (tel.length()!=10) {
            Toast.makeText(this, "Le numéro de téléphone doit contenir 10 nombres", Toast.LENGTH_LONG).show();
        }
        else if (!tel.substring(0, 2).equals("06") && !tel.substring(0, 2).equals("07")) {
            Toast.makeText(this, "Le numéro de téléphone doit commencer avec 06 ou 07", Toast.LENGTH_LONG).show();
        } /*else if (medecin.equals("")) {
            Toast.makeText(this, "Veuillez saisir le nom du médecin consultant", Toast.LENGTH_LONG).show();
        }*/else if (but_cons.equals("")) {
            Toast.makeText(this, "Veuillez saisir le but de consultation", Toast.LENGTH_LONG).show();
        }else if (date.equals("")) {
            Toast.makeText(this, "Veuillez saisir la date de consultation", Toast.LENGTH_LONG).show();
        }
        else if (heure.equals("")) {
            Toast.makeText(this, "Veuillez saisir l'heure de consultation", Toast.LENGTH_LONG).show();
        }
       /* else if (lieu.equals("")) {
            Toast.makeText(this, "Veuillez saisir le lieu de consultation", Toast.LENGTH_LONG).show();
        }*/else if(acces.RendezVousExiste(medecin,heure,date)==1)
        {

            openDialog();
        }else if(acces.RendezVousExisteJour(tel,medecin,date)==1)
        {

            openDialog2();
        }
        else
        {
            acces.ajoutRendezVous(nom,tel,medecin,but_cons,date,heure,lieu);
            openDialog1();
        }


    }
    public Integer isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9')
            {
                return 1;
            }
        }
        return 0;
    }
    public void openDialog()
    {
        BoiteDeDialogue alertDialog=new BoiteDeDialogue();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }
    public void openDialog2()
    {
        BoiteDeDialogue4 alertDialog=new BoiteDeDialogue4();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }
    public void openDialog1()
    {
        BoiteDeDialogue1 alertDialog=new BoiteDeDialogue1();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }


}
