package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.Presenter.Presentador;
import com.example.organizadorultradia.R;

public class RegistraractActivity extends AppCompatActivity {
    private EditText ingresarAct;
    private EditText Dur;
    private EditText desc;
    private Interface.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraract);
        ingresarAct =(EditText)findViewById(R.id.ingA);
        Dur =(EditText)findViewById(R.id.Duracion);
        desc =(EditText)findViewById(R.id.Descripcion);
    }
    public void RegistrarAct (View view){
        //capta los datos
        presenter.RegistrarActividad(ingresarAct.getText().toString(),Dur.getText().toString(),desc.getText().toString());
    }

    //metodo para que al oprimir el boton 'regresar', este vuelva a la activity anterior
    public void Previous(View view){
        Intent previous = new Intent(this, Activity_duo.class);
        startActivity(previous);
    }





}