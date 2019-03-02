package com.example.organizadorultradia.Presenter;


import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.Modelo.model;


public class Presentador implements Interface.Presenter {
private Interface.View view;
private Interface.Model model;

    public Presentador(Interface.View view){
      this.view = view;
      model=new model(this);
    }
    @Override
    public boolean RegistrarLogin(String Email, String Pass) {
        return model.RegistrarLogin(Email,Pass);
    }
    @Override
    public void RegistrarActividad(String actividad, String duracion, String descripcion) {
        //capta los datos
    model.RegistrarActividad(actividad,duracion,descripcion);
    }

    @Override
    public boolean isEmpty(String Email, String Pass) {
        boolean comprobar = false;
        if(model.isEmpty(Email,Pass)==true)
        {
            comprobar=true;
        }
        return comprobar;
    }
}
