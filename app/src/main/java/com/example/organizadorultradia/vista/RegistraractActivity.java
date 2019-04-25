package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.organizadorultradia.Interface.RegistrarActividadContract;
import com.example.organizadorultradia.Presenter.RegistrarActPresentador;
import com.example.organizadorultradia.R;

public class RegistraractActivity extends AppCompatActivity implements RegistrarActividadContract.View {
    private EditText ingresarAct;
    private EditText duracion;
    private EditText descripcion;
    private Button registrarAct;
    private Button AutoRegis;
    private RegistrarActividadContract.Presenter presenter;
    public Activity_manual manual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registraract);

        setUpActivity();
    }

    private void setUpActivity() {
        presenter = new RegistrarActPresentador(getApplicationContext());
        ingresarAct = findViewById(R.id.ingA);
        duracion =  findViewById(R.id.Duracion);
        descripcion =  findViewById(R.id.Descripcion);
        registrarAct = findViewById(R.id.registrarActBtn);
        AutoRegis = findViewById(R.id.Automatico);
        setUpListener();
    }

    private void setUpListener() {
        registrarAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(RegistraractActivity.this, Activity_manual.class);
               String Act= ingresarAct.getText().toString();
               String dur=duracion.getText().toString();
               String desc =descripcion.getText().toString();
               next.putExtra("Actividad",Act);
               next.putExtra("Duracion",dur);
               next.putExtra("Descripcion",desc);

               startActivity(next);
            }

        });
        AutoRegis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Act= ingresarAct.getText().toString();
                String dur=duracion.getText().toString();
                String desc =descripcion.getText().toString();
                presenter.registrarActividad(Act,dur,desc);

            }
        });
    }

}