package com.example.organizadorultradia.Modelo;

import com.example.organizadorultradia.Interface.Interface;

public class Login_model implements Interface.Model {
    private Interface.Presenter presenter;

    public Login_model(Interface.Presenter presenter) {
        this.presenter=presenter;
    }


    @Override
    public void RegistrarLogin(String Email, String Pass) {

    }

    @Override
    public void RegistrarActividad(String actividad, String duracion, String descripcion) {
      // a la espera del negro
    }
}
