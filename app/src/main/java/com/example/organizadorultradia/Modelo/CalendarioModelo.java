package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.content.Intent;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.CalendarioPresentador;
import com.example.organizadorultradia.clases.Actividad;
import com.example.organizadorultradia.clases.Fecha;
import com.example.organizadorultradia.clases.Informacion;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.sql.SQLOutput;
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
                System.out.println(response);
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(getAplicationContext, "Correcto", Toast.LENGTH_SHORT).show();
                try {

                    String json = response.getString("true");//Capta la informacion de json
                    System.out.println("hello");
                    //extrae la infromacion
                    JsonParser parser = new JsonParser();
                    JsonArray array = parser.parse(json).getAsJsonArray();
                    String fecha = "", descri = "", titulo = "";
                    int hora, horafin, durac;
                    System.out.println(json+"hello");
                    String act="",dur="",des="";
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
                    /*
                    ArrayList<Informacion> prueba = new ArrayList<>();
                    System.out.println();
                    for (JsonElement js : array) {
                        JsonObject object = js.getAsJsonObject();
                        System.out.println();
                        fecha = object.get("Fecha").getAsString();
                        hora = object.get("HoraInicio").getAsInt();
                        horafin = object.get("HoraFin").getAsInt();
                        titulo = object.get("Titulo").getAsString();
                        durac = object.get("Duracion").getAsInt();
                        descri = object.get("Descripcion").getAsString();
                        Informacion info = new Informacion(fecha, hora, horafin, titulo, descri, durac);
                        System.out.println(info.toString());
                        prueba.add(info);
                    }*/

                    //anade informacion como un string por actividades para imprimir
                    ArrayList<String> Mensaje = new ArrayList<>();
                    for (int i=0;i<prueba.size();i++){
                        Mensaje.add(i,"Titulo:" + prueba.get(i).getActividades() +"\n" + "  Duracion:" + prueba.get(i).getDuracion() +"\n"+ "  Descripcion:" + prueba.get(i).getDescripcion());
                        System.out.println(Mensaje.get(i));
                    }
                    //String mensaje = "Actividad:" + prueba.get(0).getActividades() +"\n" + "  Duracion:" + prueba.get(0).getDuracion() +"\n"+ "  Descripcion:" + prueba.get(0).getDescripcion();
                    //System.out.println(mensaje);
                    presentador.enviarActividad(Mensaje);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                super.onFailure(statusCode, headers, responseString, throwable);
                Toast.makeText(getAplicationContext, " no funciono " + throwable, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
