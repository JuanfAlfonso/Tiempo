package com.example.organizadorultradia.Modelo;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.widget.Toast;

import com.example.organizadorultradia.Presenter.CalendarioPresentador;
import com.example.organizadorultradia.clases.Actividad;
import com.example.organizadorultradia.clases.Fecha;
import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import cz.msebera.android.httpclient.Header;

public class CalendarioModelo {
    Context getAplicationContext;
    CalendarioPresentador presentador;
    private String url = "http://192.168.0.25:10567/Pruebaoficial/Actividades";
    AsyncHttpClient client;
    RequestParams params;

    public CalendarioModelo(CalendarioPresentador presenter, Context context) {
        this.getAplicationContext = context;
        this.presentador = presenter;
    }

    public char traerComilla() {
        return '"';
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
                    Gson gson2 = new Gson();
                    String json = response.getString("true");

                    JsonParser parser = new JsonParser();
                    JsonArray array = parser.parse(json).getAsJsonArray();
                    String act="",dur="",des="";
                    System.out.println(json);
                    for (JsonElement js:array) {
                        JsonObject object = js.getAsJsonObject();
                        System.out.println();
                        act =object.get("Actividades").getAsString();
                         dur =object.get("Duracion").getAsString();
                         des=object.get("Descripcion").getAsString();

                        System.out.println(act+"  "+dur+"  "+des);
                    }
                    Actividad hola = new Actividad(act,dur,des);


                    String mensaje = "Actividad:"+hola.getActividades() + "  Duracion:" + hola.getDuracion() + "  Descripcion:" + hola.getDescripcion();

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
