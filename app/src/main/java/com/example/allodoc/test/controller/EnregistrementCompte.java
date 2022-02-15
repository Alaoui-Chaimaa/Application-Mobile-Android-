package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.allodoc.R;

public class EnregistrementCompte extends AppCompatActivity {
    private Button btn_connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enregistrement_compte);
        btn_connection=(Button)findViewById(R.id.btn_connection);
        btn_connection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent connection=new Intent(EnregistrementCompte.this,MainActivity.class);
                startActivity(connection);
            }
        });
    }
}
