package com.example.allodoc.test.controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.BoiteDeDialogue;
import com.example.allodoc.test.model.BoiteDeDialogue5;
import com.example.allodoc.test.model.Profil;
import com.example.allodoc.test.model.Rdv;

public class ModifierRdv extends AppCompatActivity {

    private TextView but_cons;
    private TextView date_cons;
    private TextView heure_cons;
    private TextView medecin;
    private ImageView ic_but_cons;
    private ImageView ic_date_cons;
    private ImageView ic_heure_cons;
    private ImageView ic_medecin;
    private Rdv rdv;
    private String date;
    private Button btn_modifier_rdv;
    private String heure;
    private Profil doctor;
    private String nom_doctor;
    private String lieu_cons;
    private String tel;
    private AccesLocal acces;
    private String b_c;
    private int id;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_rdv);
        but_cons=(EditText)findViewById(R.id.but_cons);
        date_cons=(TextView) findViewById(R.id.date_cons);
        heure_cons=(TextView) findViewById(R.id.heure_cons);
        medecin=(TextView) findViewById(R.id.medecin);
        ic_date_cons=(ImageView) findViewById(R.id.ic_date_cons);
        ic_heure_cons=(ImageView) findViewById(R.id.ic_heure_cons);
        ic_medecin=(ImageView) findViewById(R.id.ic_medecin);
        btn_modifier_rdv=(Button)findViewById(R.id.btn_modifier_rdv);
         acces=new AccesLocal(this);
        Intent intent=getIntent();
        final Rdv rdv=intent.getParcelableExtra("rdv");
        b_c=rdv.getBut_consultation();
        id=rdv.getId();
        but_cons.setText(b_c);
        try {
            tel=acces.getTelPatient(id);
        }catch (NullPointerException ignored)
        {

        }


        ic_date_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ModifierRdv.this,CalendrierModification.class);
                startActivityForResult(intent,1);
            }
        });
        ic_heure_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent(ModifierRdv.this,HeureModification.class);
                startActivityForResult(intent2,2);
            }
        });
        ic_medecin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3=new Intent(ModifierRdv.this,ModifierDoctor.class);
                startActivityForResult(intent3,3);
            }
        });
        if(nom_doctor==null)
        {
            nom_doctor=rdv.getNom_docteur();
            lieu_cons=rdv.getLieu_consultation();
        }
        if(date==null)
        {
            date=rdv.getDate();

        }
        if(heure==null)
        {
            heure=rdv.getHeure();
        }

        btn_modifier_rdv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(acces.RendezVousExiste(nom_doctor,heure,date)==1)
                {

                    openDialog();
                } else if (acces.RendezVousExisteJour(tel, nom_doctor, date) == 1 && !date.equals(rdv.getDate())) {

                            openDialog2();

                    }



                else
                {
                   acces.UpdateRdv(nom_doctor,b_c,date,heure,lieu_cons,id);
                   Intent intent=new Intent(ModifierRdv.this,ModifySuccess.class);
                    intent.putExtra("tel_p",tel);
                    startActivity(intent);

                }
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode==RESULT_OK)
            {
                // TODO Extract the data returned from the child Activity.
                date = data.getStringExtra("date_modify");
                date_cons.setText("Date De Consultation Modifiée: "+date);

            }

        }
        if (requestCode == 2) {
            if(resultCode==RESULT_OK)
            {
                // TODO Extract the data returned from the child Activity.
                heure= data.getStringExtra("heure_modify");
                heure_cons.setText("Heure De Consultation Modifiée: "+heure);

            }

        }
        if (requestCode == 3) {
            if(resultCode==RESULT_OK)
            {
                // TODO Extract the data returned from the child Activity.
               doctor=data.getParcelableExtra("medecin");
               nom_doctor=doctor.getNom_medecin();
               lieu_cons=doctor.getAdresse();
               medecin.setText("Médecin Modifié: "+nom_doctor);
            }

        }


    }
    public void openDialog()
    {
        BoiteDeDialogue alertDialog=new BoiteDeDialogue();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }
    public void openDialog2()
    {
        BoiteDeDialogue5 alertDialog=new BoiteDeDialogue5();
        alertDialog.show(getSupportFragmentManager(),"alertDialog");
    }



}
