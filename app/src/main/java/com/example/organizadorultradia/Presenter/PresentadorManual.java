package com.example.organizadorultradia.Presenter;

import android.content.Context;

import com.example.organizadorultradia.Modelo.Manual_model;
import com.example.organizadorultradia.clases.Actividad;

public class PresentadorManual {
    Context context;
    Manual_model model;

    public PresentadorManual(Context view) {
        context = view;
        model = new Manual_model(this, view);
    }
    public void registrarActividad(String actividad, String duracion, String descripcion) {
        Actividad actividad1 = new Actividad(actividad,duracion,descripcion);
        model.RegistraManual(actividad1);
        System.out.println("RE HOLA");
    }
}
