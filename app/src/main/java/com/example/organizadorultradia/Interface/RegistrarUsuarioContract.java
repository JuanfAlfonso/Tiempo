package com.example.organizadorultradia.Interface;

public interface RegistrarUsuarioContract {
    interface view {
    }
    interface Presenter{
        void setView(RegistrarUsuarioContract.view view);
        void registrarLogin(String Email, String Pass);
    }
}
