package com.example.organizadorultradia.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.organizadorultradia.Presenter.PresentadorManual;
import com.example.organizadorultradia.R;

public class Activity_manual extends AppCompatActivity {
    public TextView tit;
    public TextView dur;
    public TextView des;
    public Button btnregistrar;
    PresentadorManual presenter;
    String Actividad;
    String Duracion;
    String Descripcion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registromanual);
        setUpActivity();
    }

    private void setUpActivity() {
        tit = findViewById(R.id.Titulo);
        dur = findViewById(R.id.DuracionManual);
        des = findViewById(R.id.DescripcionManual);
        btnregistrar = findViewById(R.id.RegistrarManualBtn);
        presenter = new PresentadorManual(getApplicationContext());
        String Act = getIntent().getExtras().getString("Actividad");
        String Dur = getIntent().getExtras().getString("Duracion");
        String Des = getIntent().getExtras().getString("Descripcion");
        System.out.println("este es el poder " + Act + Dur + Des);
        Actividad=Act;
        Duracion=Dur;
        Descripcion=Des;
        tit.setText("Titulo: " + Act);
        dur.setText("Duracion: " + Dur);
        des.setText("Descripcion: " + Des);
        setUpListener();
    }
    private void setUpListener() {
        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.registrarActividad(Actividad,Duracion,Descripcion);
            }
        });
    }


}
