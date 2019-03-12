package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.widget.Toast;
import com.example.organizadorultradia.Presenter.RegistrarPresentador;
import com.example.organizadorultradia.clases.Usuario;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import org.json.JSONObject;
import cz.msebera.android.httpclient.Header;

public class Registrar_model {
    Context getAplicationContext;
    AsyncHttpClient client;
    RequestParams params;
    String url = "http://172.25.12.228:8080/PruebaAndroid/Registrar";
    private RegistrarPresentador presenter;
    private String email;
    private String pass;
    public Registrar_model(RegistrarPresentador presentador, Context context) {
        this.presenter = presentador;
        this.getAplicationContext = context;
    }

    public void registrarUsuario(Usuario usuario) {
        Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(usuario);
        params.put("usuario", json);
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getAplicationContext, "Usuario registrado" + response, Toast.LENGTH_SHORT).show();
                System.out.println("registro correcto");
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getAplicationContext, "No se recibe respuesta" + throwable, Toast.LENGTH_SHORT).show();
                System.out.println("registro incorrecto");
            }
        });
    }
}
