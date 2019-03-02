package com.example.organizadorultradia.Modelo;

import android.content.Intent;
import android.widget.Toast;

import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.vista.Activity_duo;

public class model implements Interface.Model {
    private Interface.Presenter presenter;

    public model(Interface.Presenter presenter) {
        this.presenter=presenter;
    }


    @Override
    public boolean RegistrarLogin(String Email, String Pass) {

     return true;
    }

    @Override
    public void RegistrarActividad(String actividad, String duracion, String descripcion) {
      // a la espera del negro
    }

    @Override
    public boolean isEmpty(String Email, String Pass) {
        boolean comprobar = false;
        if (Email.equals("") & Pass.equals("")){//valida si los campos del edittext esta vacios
            return  false;
        }else if(comprobar){//valida si el usuario esta registrado en la base de datos
         return true;
        }else {
            return false;
        }
    }
}
