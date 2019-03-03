package com.example.organizadorultradia.Presenter;

import com.example.organizadorultradia.Interface.RegistrarActividadContract;
import com.example.organizadorultradia.Modelo.RegistrarActModel;

public class RegistrarActPresentador implements RegistrarActividadContract.Presenter {
    private RegistrarActividadContract.View view;
    private RegistrarActModel model;

    public RegistrarActPresentador(){
      model= new RegistrarActModel(this);
    }
    @Override
    public void registrarActividad(String actividad, String duracion, String descripcion) {
        System.out.println("ENTRO A PRESENTADOR");
        view.sucessfulAct(actividad,duracion,descripcion);
        model.RegistrarActividad(actividad, duracion, descripcion);
    }

    @Override
    public void setView(RegistrarActividadContract.View view) {
        this.view = view;
    }
}
