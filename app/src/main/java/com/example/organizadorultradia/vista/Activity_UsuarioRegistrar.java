package com.example.organizadorultradia.vista;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.organizadorultradia.Interface.RegistrarUsuarioContract;
import com.example.organizadorultradia.Presenter.RegistrarPresentador;
import com.example.organizadorultradia.R;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class Activity_UsuarioRegistrar extends AppCompatActivity implements RegistrarUsuarioContract.view {
    private EditText email;
    private EditText password;
    private EditText passwordConfi;
    private Button registrar;
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
        email =  findViewById(R.id.Email);
        password = findViewById(R.id.Pass);
        passwordConfi =  findViewById(R.id.ConfiPass);
        registrar =  this.findViewById(R.id.registrarUsuario);
        setUpListeners();
    }

    private void setUpListeners() {

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String em = email.getText().toString();
                String pas = password.getText().toString();
                String pass2 = passwordConfi.getText().toString();
                if (pas.equals(pass2)) {
                    presentador.registrarLogin(em, pas);
                } else {
                    Crouton.makeText((Activity) getApplicationContext(), "Las contraseñas no coinciden", Style.ALERT);//no sirve
                    //hacer un cuadro de dialogo
                }
            }
        });
    }

}
