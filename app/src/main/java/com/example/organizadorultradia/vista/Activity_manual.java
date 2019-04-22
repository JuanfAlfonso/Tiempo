package com.example.organizadorultradia.vista;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.example.organizadorultradia.R;

public class Activity_manual extends AppCompatActivity {
    public TextView tit;
    public TextView dur;
    public TextView des;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registromanual);
        setUpActivity();
    }

    private void setUpActivity() {
        tit = findViewById(R.id.Titulo);
        dur = findViewById(R.id.DuracionManual);
        des= findViewById(R.id.DescripcionManual);

        setUpListener();
        
    }

    private void setUpListener() {
        String Act = getIntent().getExtras().getString("Actividad");
        String Dur = getIntent().getExtras().getString("Duracion");
        String Des = getIntent().getExtras().getString("Descripcion");
        System.out.println("este es el poder "+Act+Dur+Des);
        tit.setText("Titulo: "+Act);
        dur.setText("Duracion: "+Dur);
        des.setText("Descripcion: "+Des);
    }


}
