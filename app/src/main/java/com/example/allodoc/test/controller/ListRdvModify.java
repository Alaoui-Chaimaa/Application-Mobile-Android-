package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.AdapterRdv;
import com.example.allodoc.test.model.Rdv;

import java.util.List;

public class ListRdvModify extends AppCompatActivity {
    private ListView listView;
    private AdapterRdv adapter;
    private List<Rdv> listItem;
    private AccesLocal accesBD;
    private String tel_patient;
    private String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_rdv_modify);
        accesBD = new AccesLocal(this);
        listView = (ListView) findViewById(R.id.listRdvModify);
        Intent intent=getIntent();
        tel_patient=intent.getStringExtra("tel_p");
        try
        {
            listItem = accesBD.getListRdv(tel_patient);
            adapter = new AdapterRdv(this, listItem);
            listView.setAdapter(adapter);
            if(listItem.isEmpty())
            {
                Intent list_vide=new Intent(ListRdvModify.this,ListRdvVide.class);
                startActivity(list_vide);
            }


        }catch (NullPointerException ignored)
        {

        }

    }
}
