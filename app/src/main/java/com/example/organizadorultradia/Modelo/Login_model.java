package com.example.organizadorultradia.Modelo;

import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.Presentador.presentador;

public class Login_model implements Interface.Model {
    private Interface.Presenter Presenter;

    public Login_model(Interface.Presenter presenter) {
        this.Presenter=presenter;
    }


    @Override
    public void RegistrarLogin(String Email, int Pass) {

    }

    @Override
    public void RegistrarActividad(String actividad, int duracion, String descripcion) {

    }
}
