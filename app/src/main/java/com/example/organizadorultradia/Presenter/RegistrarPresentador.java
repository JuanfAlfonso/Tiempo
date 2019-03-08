package com.example.organizadorultradia.Presenter;

import android.content.Context;


import com.example.organizadorultradia.Interface.RegistrarUsuarioContract;
import com.example.organizadorultradia.Modelo.Registrar_model;
import com.example.organizadorultradia.clases.Usuario;
import com.example.organizadorultradia.vista.Activity_UsuarioRegistrar;

public class RegistrarPresentador implements RegistrarUsuarioContract.Presenter {
    Context context;
    Registrar_model model;

    public RegistrarPresentador(Context view) {
        context = view;
        model = new Registrar_model(this, view);

    }


    @Override
    public void setView(RegistrarUsuarioContract.view view) {

    }

    @Override
    public void registrarLogin(String Email, String Pass) {
        Usuario usuario = new Usuario(Email, Pass);
        model.registrarUsuario(usuario);
    }
}
