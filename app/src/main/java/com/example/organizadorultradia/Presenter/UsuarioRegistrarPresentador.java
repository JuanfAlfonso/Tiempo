package com.example.organizadorultradia.Presenter;

import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Interface.RegistrarUsuarioContract;
import com.example.organizadorultradia.vista.Activity_UsuarioRegistrar;

public class UsuarioRegistrarPresentador implements RegistrarUsuarioContract.Presenter {
    private RegistrarUsuarioContract.view view;
    @Override
    public void setView( RegistrarUsuarioContract.view view) {
       this.view= view;
    }

    @Override
    public void registrarLogin(String Email, String Pass) {
        System.out.println("EMAIL"+Email+"PASSWORD"+Pass);
    }
}
