package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.RegistrarActPresentador;
import com.example.organizadorultradia.clases.Actividad;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import cz.msebera.android.httpclient.Header;

public class RegistrarActModel {
    String url = "http://ec2-3-86-105-189.compute-1.amazonaws.com:8080/Pruebaoficial/Actividades";
    private RegistrarActPresentador presenter;
    Context getAplicationContext;
    RequestParams params;
    AsyncHttpClient client;

    public RegistrarActModel(RegistrarActPresentador presenter, Context view) {
        this.presenter = presenter;
        this.getAplicationContext= view;
    }

    public void RegistrarActividad(Actividad actividad) {
        System.out.println("RE HOLA X2");
        Gson gson = new Gson();
        params = new RequestParams();
        client = new AsyncHttpClient();
        String json = gson.toJson(actividad);
        params.put("actividad", json);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date);

        client.post(url, params, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    int otraP = response.getInt("true");
                    if(otraP==1){
                        Toast.makeText(getAplicationContext, "Actividad registrada" + response, Toast.LENGTH_SHORT).show();
                        presenter.comprobar(true);

                        //prueba algoritmo!!!!!!!!!!!!!!!!!

                        String json = response.getString("true");//Capta la informacion de json

                        //extrae la infromacion
                        JsonParser parser = new JsonParser();
                        JsonArray array = parser.parse(json).getAsJsonArray();
                        String fecha = "", descri = "",titulo="";
                        int hora,horafin,durac;
                        System.out.println(json);
                        ArrayList<Informacion> prueba= new ArrayList<>();

                        for (JsonElement js : array) {
                            JsonObject object = js.getAsJsonObject();
                            System.out.println();
                            fecha = object.get("Fecha").getAsString();
                            hora= object.get("HoraInicio").getAsInt();
                            horafin=object.get("HoraFin").getAsInt();
                            titulo= object.get("Titulo").getAsString();
                            durac=object.get("Duracion").getAsInt();
                            descri = object.get("Descripcion").getAsString();
                            Informacion info = new Informacion(fecha,hora,horafin,titulo,descri,durac);
                            prueba.add(info);
                        }
                        //Extrae a informacion
                        //algoriiiiiiiiitmooooooooooo
                        String algo = new Date().toString();
                        int horas, minutos;
                        String[] horita=algo.split(":");
                        minutos=Integer.parseInt(horita[1]);
                        hora=(int)(horita[0].charAt(horita[0].length()-2));
                        ArrayList<Informacion> ActividadesPorFecha = new ArrayList<>();
                        for (int i=0; i<=prueba.size(); i++){
                            if(prueba.get(i).fecha.equals(fecha) && prueba.get(i).horafin>hora && prueba.get(i).hora>=hora){
                                ActividadesPorFecha.add(prueba.get(i)); //actividades que pueden interferir en el registro automatico
                            }
                        }

                        //prueba algoritmo!!!!!!!!!!!!
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
    public void compararActividades(){


    }
}
