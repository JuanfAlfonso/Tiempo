package com.example.organizadorultradia.Presenter;

import com.example.organizadorultradia.Interface.CalendarContract;
import com.example.organizadorultradia.Modelo.CalendarioModelo;

public class CalendarioPresentador implements CalendarContract.presentador {
    CalendarioModelo modelo;
    @Override
    public void enviarFecha(int dia) {
     modelo.recibirFecha(dia);
    }
}
