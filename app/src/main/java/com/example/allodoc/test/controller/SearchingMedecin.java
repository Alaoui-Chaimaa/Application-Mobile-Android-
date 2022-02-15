package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;
import com.example.allodoc.test.model.Adapter;
import com.example.allodoc.test.model.Profil;

import java.util.ArrayList;
import java.util.List;

public class SearchingMedecin extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    private Adapter adapter;
    private List<Profil> listItem;
    private AccesLocal mDBHelper;
    private String tel;
    private Toolbar toolbar;
    private String specialite;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_searching_medecin2);
        listView= (ListView)findViewById(R.id.listview);
        searchView=(SearchView)findViewById(R.id.searchView);
        toolbar=(Toolbar) findViewById(R.id.toolbar_list_medecins);
        mDBHelper = new AccesLocal(this);
        Intent intent=getIntent();
        tel=intent.getStringExtra("tel");
        specialite=intent.getStringExtra("spécialité");

        //Get product list in db when db exists
        try
        {
            listItem = mDBHelper.getListMedecin(specialite);
            //Init adapter
            adapter = new Adapter(this, tel,listItem);
            //Set adapter for listview
            listView.setAdapter(adapter);
        }catch (NullPointerException ignored)
        {

        }
         searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
             @Override
             public boolean onQueryTextSubmit(String query) {
                 return false;
             }

             @Override
             public boolean onQueryTextChange(String newText) {
                 List<Profil> results=new ArrayList<>();
                 for(Profil p :listItem)
                 {
                     try {
                         if(p.getNom_medecin().toLowerCase().contains(newText.toLowerCase()) ||
                                 p.getNom_medecin().toUpperCase().contains(newText.toUpperCase()))
                             results.add(p);

                     }catch (NullPointerException ignored)
                     {

                     }

                 }

                 ((Adapter)listView.getAdapter()).update(results);
                 return false;
             }
         });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                       /* Intent intent=new Intent(SearchingMedecin.this,ProfilMedecin.class);
                        intent.putExtra("Item",listItem.get(position));
                        intent.putExtra("tel",tel);
                        startActivity(intent);*/





            }
        });

    }


}
