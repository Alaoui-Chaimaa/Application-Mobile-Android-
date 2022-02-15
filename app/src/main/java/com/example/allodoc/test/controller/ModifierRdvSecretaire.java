package com.example.allodoc.test.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.BoiteDeDialogue;
import com.example.allodoc.test.model.BoiteDeDialogue4;
import com.example.allodoc.test.model.BoiteDeDialogue5;
import com.example.allodoc.test.model.BoiteDeDialogue8;
import com.example.allodoc.test.model.Rdv;

public class ModifierRdvSecretaire extends AppCompatActivity {
    private ImageView ic_date_cons;
    private ImageView ic_heure_cons;
    private TextView date_cons;
    private TextView heure_cons;
    private String date;
    private String heure;
    private Button btn_modifier;
    private Rdv rdv;
    private String nom_m;
    private String tel_p;
    private int Id;
    private AccesLocal acces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_rdv_secretaire);
        ic_date_cons = (ImageView) findViewById(R.id.ic_date_cons_modify);
        ic_heure_cons = (ImageView) findViewById(R.id.ic_heure_cons_modify);
        date_cons = (TextView) findViewById(R.id.date_cons_modify);
        heure_cons = (TextView) findViewById(R.id.heure_cons_modify);
        btn_modifier = (Button) findViewById(R.id.btn_modifier_rdv_secretaire);
        acces = new AccesLocal(this);
        Intent intent = getIntent();
        rdv = intent.getParcelableExtra("rdv_secretaire");
        nom_m = rdv.getNom_docteur();
        Id = rdv.getId();
        tel_p = rdv.getTel_patient();

        ic_date_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ModifierRdvSecretaire.this, CalendrierModification.class);
                startActivityForResult(intent, 1);
            }
        });
        ic_heure_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(ModifierRdvSecretaire.this, HeureModification.class);
                startActivityForResult(intent2, 2);
            }
        });
        if (date == null) {
            date = rdv.getDate();

        }
        if (heure == null) {
            heure = rdv.getHeure();
        }

        btn_modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (acces.RendezVousExiste(nom_m, heure, date) == 1) {

                    openDialog();
                } else if (acces.RendezVousExisteJour(tel_p,nom_m,date) == 1 && !date.equals(rdv.getDate())) {
                    openDialog2();

                } else {
                    acces.UpdateRdvSecretaire(date, heure, Id);
                    Intent intent = new Intent(ModifierRdvSecretaire.this, ModificationRdvSecretaire.class);
                    intent.putExtra("nom_medecin", nom_m);
                    startActivity(intent);
                }
            }

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                // TODO Extract the data returned from the child Activity.
                date = data.getStringExtra("date_modify");
                date_cons.setText("Date De Consultation Modifiée: " + date);

            }

        }
        if (requestCode == 2) {
            if (resultCode == RESULT_OK) {
                // TODO Extract the data returned from the child Activity.
                heure = data.getStringExtra("heure_modify");
                heure_cons.setText("Heure De Consultation Modifiée: " + heure);

            }

        }
    }

    public void openDialog() {
        BoiteDeDialogue alertDialog = new BoiteDeDialogue();
        alertDialog.show(getSupportFragmentManager(), "alertDialog");
    }

    public void openDialog2() {
        BoiteDeDialogue4 alertDialog = new BoiteDeDialogue4();
        alertDialog.show(getSupportFragmentManager(), "alertDialog");
    }

    public void openDialog3() {
        BoiteDeDialogue8 alertDialog = new BoiteDeDialogue8();
        alertDialog.show(getSupportFragmentManager(), "alertDialog");
    }

}
