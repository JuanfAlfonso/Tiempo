package com.example.organizadorultradia.Presenter;


import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Modelo.Login_model;


public class LoginPresentador implements LoginContract.Presenter {
    private LoginContract.View view;
    private Login_model model;

    public LoginPresentador() {
        model = new Login_model(this);
    }

    @Override
    public void setView(LoginContract.View view) {
        this.view = view;
    }

    @Override
    public void validarLogin(String email, String password) {
        model.validarLogin(email, password);// se envian los datos al modelo para validarlos en la base de datos
        //showInView(email, password);//comprobacion de captrua de datos y mvp
    }


    //private void showInView(String m, String p) {
    //    view.sucessfulSignIn(m, p);
    //}

}
