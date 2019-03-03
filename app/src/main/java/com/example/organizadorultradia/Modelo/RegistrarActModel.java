package com.example.organizadorultradia.Modelo;

import com.example.organizadorultradia.Presenter.RegistrarActPresentador;

public class RegistrarActModel {
    private RegistrarActPresentador presenter;
    public RegistrarActModel(RegistrarActPresentador presenter) {
        this.presenter =presenter;
    }
    public void RegistrarActividad(String actividad,String duracion,String descripcion){
        System.out.println("ENTRO A MODELO");


    }
}
