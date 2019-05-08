package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.organizadorultradia.Interface.RegistrarUsuarioContract;
import com.example.organizadorultradia.Presenter.RegistrarPresentador;
import com.example.organizadorultradia.R;

public class Activity_UsuarioRegistrar extends AppCompatActivity implements RegistrarUsuarioContract.view {
    private EditText email;
    private EditText password;
    private EditText passwordConfi;
    private Button registrar;
    private ImageButton imageButton1;
    private RegistrarUsuarioContract.Presenter presentador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__usuario_registrar);
        setUpActivity();
    }

    private void setUpActivity() {
        presentador = new RegistrarPresentador(getApplicationContext());
        presentador.setView(this);
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Pass);
        passwordConfi = findViewById(R.id.ConfiPass);
        registrar = this.findViewById(R.id.registrarUsuario);
        imageButton1 = findViewById(R.id.imageButton);
        setUpListeners();
    }

    private void setUpListeners() {
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pas = password.getText().toString();
                String pass2 = passwordConfi.getText().toString();
                presentador.registrarLogin(em, pas);
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(Activity_UsuarioRegistrar.this,AddNewPhoto.class);
                startActivity(next);
            }
        });
    }

}
