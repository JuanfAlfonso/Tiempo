package com.example.organizadorultradia.Interface;

public interface LoginContract {
    interface View{
       void sucessfulSignIn(String m, String p);
    }

    interface Presenter{
        void setView(LoginContract.View view);
        void validarLogin(String Email, String Pass);
    }

}
