package com.example.organizadorultradia.Presenter;


import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Modelo.Login_model;

import org.json.JSONObject;


public class LoginPresentador implements LoginContract.Presenter {
    private LoginContract.View view;
    private Login_model model;
    Context contexto;

    public LoginPresentador(Context applicationContext) {
        contexto=applicationContext;
        model = new Login_model(this, contexto);
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
