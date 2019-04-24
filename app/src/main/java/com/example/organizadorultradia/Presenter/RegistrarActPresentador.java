package com.example.organizadorultradia.Presenter;

import android.content.Context;

import com.example.organizadorultradia.Interface.RegistrarActividadContract;
import com.example.organizadorultradia.Modelo.RegistrarActModel;
import com.example.organizadorultradia.clases.Actividad;
import com.example.organizadorultradia.vista.RegistraractActivity;

public class RegistrarActPresentador implements RegistrarActividadContract.Presenter {
    private Context view;
    private RegistrarActModel model;
    private boolean Comprobar;



    public RegistrarActPresentador(Context context){
        this.view= context;
        model= new RegistrarActModel(this,view);
    }
    @Override
    public void registrarActividad(String actividad, String duracion, String descripcion) {
        //view.sucessfulAct(actividad,duracion,descripcion);
        Actividad actividad1 = new Actividad(actividad,duracion,descripcion);
        model.RegistrarActividad(actividad1);
    }

    @Override
    public void comprobar(boolean com) {
         this.Comprobar=com;
    }

    @Override
    public boolean comprobarVacios() {
        if(Comprobar==true)
        {
            return true;
        }else{
            return false; }
    }
    //Registro automatico
    public void autoRegis(String actividad, String duracion, String descripcion){


    }
}
