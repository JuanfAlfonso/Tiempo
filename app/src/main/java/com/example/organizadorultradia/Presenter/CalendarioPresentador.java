package com.example.organizadorultradia.Presenter;

import android.content.Context;
import android.widget.TextView;

import com.example.organizadorultradia.Interface.CalendarContract;
import com.example.organizadorultradia.Modelo.CalendarioModelo;
import com.example.organizadorultradia.clases.Fecha;
import com.example.organizadorultradia.clases.Informacion;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.LinkedList;

public class CalendarioPresentador implements CalendarContract.presentador {
    Context getContext;
    CalendarioModelo model;
    ArrayList<String> mensaje = new ArrayList<>();
    public CalendarioPresentador(Context getContext){
        this.getContext=getContext;
        model = new CalendarioModelo(this,getContext);

    }

    @Override
    public void enviarFecha(int dia,int mes,int anio) {
        Fecha fecha = new Fecha(dia, mes, anio);
       model.recibirFecha(fecha);
       //

    }
    public void enviarActividad(ArrayList<String> mensaje){
        this.mensaje =mensaje;
    }

    public ArrayList<String> getMensaje(){

        return mensaje;
    }
}
