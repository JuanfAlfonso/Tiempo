package com.example.organizadorultradia.Modelo;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.organizadorultradia.Presenter.LoginPresentador;

public class Login_model implements Response.Listener<String>,Response.ErrorListener {
    private LoginPresentador presenter;
    private EditText correo,usuario;
    private Button login;
    Requestqueue request;
    private ProgressDialog progreso;
    Context contextico;

    public Login_model(LoginPresentador presenter, Context aaaaaa) {
        this.presenter = presenter;
        contextico=aaaaaa;
    }
    public void validarLogin(String Email, String Pass) {
     // a la espera de envio de datos
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(String response) {
        request=Volley.newRequestQueue(getContext());
    }
}
