package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.organizadorultradia.Interface.RegistrarActividadContract;
import com.example.organizadorultradia.Presenter.RegistrarActPresentador;
import com.example.organizadorultradia.R;

public class RegistraractActivity extends AppCompatActivity implements RegistrarActividadContract.View {
    private EditText ingresarAct;
    private EditText duracion;
    private EditText descripcion;
    private Button registrarAct;
    private RegistrarActividadContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraract);

        setUpActivity();
    }

    private void setUpActivity() {
        presenter = new RegistrarActPresentador(getApplicationContext());
       // presenter.setView(this);
        ingresarAct = findViewById(R.id.ingA);
        duracion =  findViewById(R.id.Duracion);
        descripcion =  findViewById(R.id.Descripcion);
        registrarAct = findViewById(R.id.registrarActBtn);
        SetUpLinsteners();
    }

    private void SetUpLinsteners() {
        registrarAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ing = ingresarAct.getText().toString();
                String dur = duracion.getText().toString();
                String des = descripcion.getText().toString();
                if (!ing.equals("") && !dur.equals("") && !des.equals("")) {
                    presenter.registrarActividad(ing, dur, des);
                }
            }
        });
    }


    //metodo para que al oprimir el boton 'regresar', este vuelva a la activity anterior
    public void Previous(View view) {
        Intent previous = new Intent(this, Activity_duo.class);
        startActivity(previous);
    }

    //metodo para comprobar que si se trasnfieren los datos
    @Override
    public void sucessfulAct(String actividad, String duracion, String descripcion) {
        System.out.println("/ACTIVIDAD:" + actividad + "/DUARACION" + duracion + "/DESCRIPCION" + descripcion);
    }
}