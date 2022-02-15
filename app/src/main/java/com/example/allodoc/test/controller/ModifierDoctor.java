package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.Adapter;
import com.example.allodoc.test.model.AdapterDoctorModify;
import com.example.allodoc.test.model.Profil;

import java.util.List;

public class ModifierDoctor extends AppCompatActivity {
    private ListView list_doctor;
    private Button btn_doctor_modify;
    private AdapterDoctorModify adapter;
    private List<Profil> list;
    private AccesLocal acces;
    private Profil medecin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_doctor);
        list_doctor=(ListView)findViewById(R.id.list_doctor_modify);
        btn_doctor_modify=(Button)findViewById(R.id.btn_doctor_modify);
        acces=new AccesLocal(this);
        try
        {
            list= acces.getListProduct();
            //Init adapter
            adapter = new AdapterDoctorModify(this,list);
            //Set adapter for listview
            list_doctor.setAdapter(adapter);
        }catch (NullPointerException ignored)
        {

        }
        list_doctor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                medecin=list.get(position);
            }
        });
        btn_doctor_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentResult=new Intent();
                intentResult.putExtra("medecin",medecin);
                setResult(ModifierRdv.RESULT_OK,intentResult);
                finish();

            }
        });
    }
}
