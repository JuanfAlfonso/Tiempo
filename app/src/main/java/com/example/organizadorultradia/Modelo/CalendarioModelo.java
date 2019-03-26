package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.widget.Toast;

import com.example.organizadorultradia.clases.Actividad;
import com.example.organizadorultradia.clases.Fecha;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class CalendarioModelo {
    Context getAplicationContext;
    CalendarioPresentador presentador;
    private String url = "http://172.25.12.135:10567/Pruebaoficial/Actividades";
    AsyncHttpClient client;
    RequestParams params;
    public CalendarioModelo(CalendarioPresentador presenter, Context context) {
        this.getAplicationContext = context;
        this.presentador = presenter;
    }
    public void recibirFecha(Fecha fecha) {
         final Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(fecha);
        params.put("date", fecha);
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getAplicationContext, " ", Toast.LENGTH_SHORT).show();

                try {
                    JSONObject json = response.getJSONObject(0);
                    System.out.println(json.toString());
                    Actividad hola = gson.fromJson(json.toString(),Actividad.class);
                    System.out.println(hola.getActividades());
                    System.out.println(hola.getDuracion());
                    System.out.println(hola.getDescripcion());
                } catch (JSONException e) {
                    e.printStackTrace();
                }

               /* try {
                    ArrayList<Actividad> act = new ArrayList();
                   for (int i=0;i<=response.length();i++)
                    {
                        JSONObject ob = response.getJSONObject(i);//obtiene cada actividad por index
                        Actividad actividad = gson.fromJson(String.valueOf(ob),Actividad.class);//lo convierte en un objeto
                        act.add(actividad);//lo agrega en un arreglo
                        System.out.println(act.get(i).getActividades());}

                } catch (JSONException e) {
                    e.printStackTrace();
                }*/

            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getAplicationContext, " " + throwable, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
