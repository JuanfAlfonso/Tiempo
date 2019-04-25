package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.CalendarioPresentador;
import com.example.organizadorultradia.clases.Actividad;
import com.example.organizadorultradia.clases.Fecha;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.LinkedList;

import cz.msebera.android.httpclient.Header;

public class CalendarioModelo {
    Context getAplicationContext;
    CalendarioPresentador presentador;
    private String url = "http://ec2-3-86-105-189.compute-1.amazonaws.com:8080/Pruebaoficial/Actividades";
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
        System.out.println(params.toString() + " params");
        client.post(url, params, new JsonHttpResponseHandler() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getAplicationContext, "Correcto", Toast.LENGTH_SHORT).show();
                try {

                    String json = response.getString("true");//Capta la informacion de json

                    //extrae la infromacion
                    JsonParser parser = new JsonParser();
                    JsonArray array = parser.parse(json).getAsJsonArray();
                    String act = "", dur = "", des = "";
                    System.out.println(json);
                    ArrayList<Actividad> prueba= new ArrayList();

                    for (JsonElement js : array) {
                        JsonObject object = js.getAsJsonObject();
                        System.out.println();
                        act = object.get("Actividades").getAsString();
                        dur = object.get("Duracion").getAsString();
                        des = object.get("Descripcion").getAsString();
                        Actividad hola = new Actividad(act, dur, des);
                        prueba.add(hola);
                    }
                    //Extrae a informacion


                    //anade informacion como un string por actividades para imprimir
                    ArrayList<String> Mensaje = new ArrayList<>();
                    for (int i=0;i<prueba.size();i++){
                        Mensaje.add(i,"Actividad:" + prueba.get(i).getActividades() +"\n" + "  Duracion:" + prueba.get(i).getDuracion() +"\n"+ "  Descripcion:" + prueba.get(i).getDescripcion());
                        System.out.println(Mensaje.get(i));
                    }
                    //String mensaje = "Actividad:" + prueba.get(0).getActividades() +"\n" + "  Duracion:" + prueba.get(0).getDuracion() +"\n"+ "  Descripcion:" + prueba.get(0).getDescripcion();
                    //System.out.println(mensaje);
                    presentador.enviarActividad(Mensaje);
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
