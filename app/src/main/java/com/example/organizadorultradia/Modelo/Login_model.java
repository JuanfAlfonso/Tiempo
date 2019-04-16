package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.LoginPresentador;
import com.example.organizadorultradia.clases.Usuario;
import com.example.organizadorultradia.vista.Activity_duo;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class Login_model extends AppCompatActivity {
    Context getAplicationContext;
    AsyncHttpClient client;
    RequestParams params;
    String url = "http://ec2-3-86-105-189.compute-1.amazonaws.com:8080/Pruebaoficial/Login";
    private LoginPresentador presenter;

    public Login_model(LoginPresentador presenter, Context getAplicationContext) {
        this.presenter = presenter;
        this.getAplicationContext = getAplicationContext;
    }
    public void validarLogin(Usuario usuario) {
        final Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(usuario);
        params.put("usuario", json);
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                System.out.println("RESPONSE = " + response.toString());
                try {
                    int otraP = response.getInt("true");
                    System.out.println(otraP);
                    if (otraP == 1) {
                        System.out.println("entro");
                        Intent next = new Intent(getAplicationContext, Activity_duo.class);
                        next.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        getAplicationContext.startActivity(next);
                        Toast.makeText(getAplicationContext, "Bienvenido" + response, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getAplicationContext, "Usuario no registrado" + response, Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getAplicationContext, "No hay respuesta del servidor" + throwable, Toast.LENGTH_SHORT).show();

            }

        });
    }
}
