package com.example.organizadorultradia.Modelo;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.organizadorultradia.Presenter.LoginPresentador;

import org.json.JSONObject;

public class Login_model implements Response.Listener<JSONObject>, Response.ErrorListener{
    private LoginPresentador presenter;
    ProgressDialog progreso;
    RequestQueue request;
    JsonObjectRequest stringRequest;
    Context getAplicationContext;

    public Login_model(LoginPresentador presenter, Context contexto) {
        this.presenter = presenter;
        request = Volley.newRequestQueue(getAplicationContext);
    }
    private void WEBservice(){
        String url="";
        url.replace(" ", "%20");
        stringRequest= new JsonObjectRequest(Request.Method.GET,url,null,this,this);
        request.add(stringRequest);
    }
    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {
        Toast.makeText(getAplicationContext,"se ha registrado exitosamente",Toast.LENGTH_SHORT).show();
    }
    public void validarLogin(String Email, String Pass) {
     // a la espera de envio de datos
    }
}
