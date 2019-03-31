package com.example.organizadorultradia.Interface;

import android.content.Context;

public interface CalendarContract {
    interface view{

    }
    interface presentador{
     public void enviarFecha(int dia,int mes,int anio);

     public String getMensaje();
    }
}
