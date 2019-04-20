package com.example.organizadorultradia.vista;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.organizadorultradia.R;


public class Activity_duo extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duo);
    }
    @Override
    public void onBackPressed (){
        System.out.print("bloqueado");
    }
     //metodo para el boton next
    public void nextReg(View view){
        Intent next = new Intent(this, RegistraractActivity.class);
         startActivity(next);
    }
    public void nexthor(View view){
        Intent next = new Intent(this, CalendarioActivity.class);
        startActivity(next);
    }

    public void registrarmanual(View view) {
        Intent next = new Intent(this, Activity_manual.class);
        startActivity(next);
    }

}
