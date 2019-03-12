package com.example.organizadorultradia.Presenter;


import android.content.Context;

import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Modelo.Login_model;
import com.example.organizadorultradia.clases.Usuario;


public class LoginPresentador implements LoginContract.Presenter {
    Context contexto;
    //private LoginContract.View view;
    private Login_model model;

    public LoginPresentador(Context applicationContext) {
        this.contexto = applicationContext;
        model = new Login_model(this, applicationContext);
    }



    @Override
    public void validarLogin(String email,String password) {
        Usuario usuario = new Usuario(email,password);
        model.validarLogin(usuario);// se envian los datos al modelo para validarlos en la base de datos
        //showInView(email, password);//comprobacion de captrua de datos y mvp
    }

    //private void showInView(String m, String p) {\
    //    view.sucessfulSignIn(m, p);
    //}

}
