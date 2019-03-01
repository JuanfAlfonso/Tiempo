package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.R;

public class LoginActivity extends AppCompatActivity {
    private Interface.View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void Prueba(View view){
        Intent next = new Intent(this, Activity_duo.class);
        startActivity(next);
    }

}