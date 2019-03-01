package com.example.organizadorultradia.Presentador;

import android.view.View;
import android.widget.EditText;
import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.Modelo.Login_model;

public class presentador implements Interface.Presenter {
private Interface.View view;
private Interface.Model model;
    public void presentador(Interface.View view, Interface.Model model){
      this.view = view;
      model=new Login_model(this);
    }
    @Override
    public void RegistrarLogin(String Email, int Pass) {

    }
    @Override
    public void RegistrarActividad(String actividad, int duracion, String descripcion) {

    }
}
