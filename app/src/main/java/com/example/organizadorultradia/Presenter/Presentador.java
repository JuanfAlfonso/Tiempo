package com.example.organizadorultradia.Presenter;


import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Modelo.Login_model;


public class Presentador implements LoginContract.Presenter {
    private LoginContract.View view;
    private Login_model model;

    public Presentador() {
        model = new Login_model(this);
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void registrarLogin(String email, String password) {
        showInView(email, password);
    }

    @Override
    public void registrarActividad(String actividad, String duracion, String descripcion) {
        model.RegistrarActividad(actividad, duracion, descripcion);
    }

    private void showInView(String m, String p){
        view.sucessfulSignIn(m, p);
    }

}
