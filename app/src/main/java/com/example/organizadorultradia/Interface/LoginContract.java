package com.example.organizadorultradia.Interface;

import android.content.Context;

public interface LoginContract {
    interface View{
    }

    interface Presenter{
        void validarLogin(String Email, String Pass);
    }

}
