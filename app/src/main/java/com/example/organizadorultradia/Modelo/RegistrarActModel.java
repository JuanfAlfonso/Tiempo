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
import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class RegistrarActModel {
    String url = "http://192.168.0.24:10567/Pruebaoficial/Actividades";
    private RegistrarActPresentador presenter;
    Context getAplicationContext;
    RequestParams params;
    AsyncHttpClient client;

    public RegistrarActModel(RegistrarActPresentador presenter, Context view) {
        this.presenter = presenter;
        this.getAplicationContext= view;
    }

    public void RegistrarActividad(Actividad actividad) {
        Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(actividad);
        params.put("actividad", json);
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    int otraP = response.getInt("true");
                    if(otraP==1){
                        Toast.makeText(getAplicationContext, "Actividad registrada" + response, Toast.LENGTH_SHORT).show();
                        presenter.comprobar(true);
                    }else
                    {
                        Toast.makeText(getAplicationContext, "Actividad ya existe" + response, Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                presenter.comprobar(false);
                Toast.makeText(getAplicationContext, "No hay respuesta del servidor" + throwable, Toast.LENGTH_SHORT).show();

            }
        });

    }
}
