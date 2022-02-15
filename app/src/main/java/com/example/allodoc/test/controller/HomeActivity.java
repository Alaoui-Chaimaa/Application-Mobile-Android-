package com.example.allodoc.test.controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.allodoc.R;
import com.example.allodoc.test.model.AccesLocal;

public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent= new Intent(HomeActivity.this,InterfaceAcceuil.class);
                startActivity(homeIntent);
                finish();
            }
        },4000);

    }

}
