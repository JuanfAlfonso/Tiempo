package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.organizadorultradia.Interface.Interface;
import com.example.organizadorultradia.R;

public class LoginActivity extends AppCompatActivity {
    private EditText Email;
    private EditText Pass;
    private Interface.View view;
    private Interface.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_Login);
          Email =(EditText)findViewById(R.id.Email);
          Pass = (EditText)findViewById(R.id.Pass);
    }
    public void Prueba(View view){
        Intent next = new Intent(this, Activity_duo.class);
        startActivity(next);
    }
    public void registrarUusario(View view){
        presenter.RegistrarLogin(Email.getText().toString(),Pass.getText().toString());
    }

}