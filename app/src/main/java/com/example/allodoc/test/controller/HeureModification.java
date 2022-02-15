package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.allodoc.R;

import java.util.ArrayList;

public class HeureModification extends AppCompatActivity {

    private ListView listView;
    private Button btn_heure_modify;
    ArrayList<String> list;
    private String heure_modify;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heure_modification);

        listView=(ListView)findViewById(R.id.list_heure_modify);
        btn_heure_modify=(Button)findViewById(R.id.btn_heure_modify);
        list=new ArrayList<>();
        list.add("8:30");
        list.add("9:00");
        list.add("9:30");
        list.add("10:00");
        list.add("10:30");
        list.add("11:00");
        list.add("11:30");
        list.add("12:00");
        list.add("14:30");
        list.add("15:00");
        list.add("15:30");
        list.add("16:00");
        list.add("16:30");
        list.add("17:00");
        list.add("17:30");
        list.add("18:00");
        final ArrayAdapter adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                heure_modify=list.get(position).toString();


            }
        });
        btn_heure_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(heure_modify==null)
                {
                    Heure();
                }
                else {
                    Intent intentResult = new Intent();
                    intentResult.putExtra("heure_modify", heure_modify);
                    setResult(ModifierRdv.RESULT_OK, intentResult);
                    finish();
                }
            }
        });
    }
    public void Heure()
    {
        Toast.makeText(this,"Si vous voulez modifier l'heure de consultation, veuillez choisir une heure",Toast.LENGTH_LONG).show();

    }
}
