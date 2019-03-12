package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.RegistrarActPresentador;
import com.example.organizadorultradia.clases.Actividad;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import cz.msebera.android.httpclient.Header;

public class RegistrarActModel {
    String url = "";
    private RegistrarActPresentador presenter;
    Context context;
    RequestParams params;
    AsyncHttpClient client;

    public RegistrarActModel(RegistrarActPresentador presenter, Context view) {
        this.presenter = presenter;
        this.context = view;
    }

    public void RegistrarActividad(Actividad actividad) {
        Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(actividad);
        params.put("actividad", json);
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(context, "Usuario registrado" + response, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
            }
        });

    }
}
