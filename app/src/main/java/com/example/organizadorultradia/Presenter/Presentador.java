package com.example.organizadorultradia.Presenter;


import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.Modelo.Login_model;


public class Presentador implements Interface.Presenter {
private Interface.View view;
private Interface.Model model;

    public Presentador(Interface.View view){
      this.view = view;
      model=new Login_model(this);
    }
    @Override
    public void RegistrarLogin(String Email, String Pass) {

    }
    @Override
    public void RegistrarActividad(String actividad, String duracion, String descripcion) {
        //capta los datos
        model.RegistrarActividad(actividad,duracion,descripcion);
    }
}
