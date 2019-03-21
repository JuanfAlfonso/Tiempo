package com.example.organizadorultradia.Presenter;

import com.example.organizadorultradia.Interface.CalendarioAbstract;

public class PresentadorCalendario implements CalendarioAbstract.presentador {


    @Override
    public void enviardia(int dia, int mes, int año) {
        System.out.println(dia+"  "+mes+"  "+año);
    }
}
