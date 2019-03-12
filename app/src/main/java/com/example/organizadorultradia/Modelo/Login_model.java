package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.LoginPresentador;
import com.example.organizadorultradia.clases.Usuario;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestHandle;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Login_model {
    Context getAplicationContext;
    AsyncHttpClient client;
    RequestParams params;
    String url = "http://192.168.111.1:24389/PruebaAndroid/Registrar";
    private LoginPresentador presenter;
    private String email;
    private String pass;

    public Login_model(LoginPresentador presenter, Context getAplicationContext) {
        this.presenter = presenter;
        this.getAplicationContext = getAplicationContext;
    }

    public void validarLogin(Usuario usuario) {
       /* email = Email;
        pass = Pass;
        params = new RequestParams();
        //si estan los datos
        params.put("email", email);
        params.put("password", pass);
        */
        Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json= gson.toJson(usuario);
         params.put("usuario",json);
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getAplicationContext, "Login succes" + response, Toast.LENGTH_SHORT).show();
                System.out.println("Login succes" + response);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getAplicationContext, "Ocurrio un error" + throwable, Toast.LENGTH_SHORT).show();
                System.out.println("Ocurrio un error" + throwable);
            }
        });

    }
}
