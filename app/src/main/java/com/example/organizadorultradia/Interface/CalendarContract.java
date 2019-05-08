package com.example.organizadorultradia.Interface;

import android.content.Context;

import com.example.organizadorultradia.clases.Informacion;

import java.util.ArrayList;
import java.util.LinkedList;

public interface CalendarContract {
    interface view{

    }
    interface presentador{
      void enviarFecha(int dia,int mes,int anio);

     ArrayList<String> getMensaje();
    }
}
