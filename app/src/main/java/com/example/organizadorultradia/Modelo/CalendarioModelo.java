package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.CalendarioPresentador;
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

import java.sql.SQLOutput;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class CalendarioModelo {
    Context getAplicationContext;
    CalendarioPresentador presentador;
    private String url = "http://172.25.19.248:10567/Pruebaoficial/Actividades";
    AsyncHttpClient client;
    RequestParams params;
    public CalendarioModelo(CalendarioPresentador presenter, Context context) {
        this.getAplicationContext = context;
        this.presentador = presenter;
    }
    public void recibirFecha(Fecha fecha) {
        Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(fecha);
        params.put("date", json);
        System.out.println(params.toString()+" params");
        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getAplicationContext, "Correcto", Toast.LENGTH_SHORT).show();
                try {
                   /* for(int i =0; i<=response.length(); i++){
                        JSONObject json = response.getJSONObject(i);
                        System.out.println(i);
                    }*/
                    Gson gson2 = new Gson();
                    String json = response.getString("true");
                    System.out.println(json+" String");

                    Actividad hola = gson2.fromJson(json,Actividad.class);//no esta asignando los atributos del objeto


                    System.out.println(hola.getActividades()+"  1");
                    System.out.println(hola.getDuracion()+"     2");
                    System.out.println(hola.getDescripcion()+"  3");

                    String mensaje = hola.getActividades()+" "+hola.getDuracion()+" "+hola.getDescripcion();

                    System.out.println(mensaje);
                    presentador.enviarActividad(mensaje);
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
