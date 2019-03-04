package com.example.organizadorultradia.vista;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.organizadorultradia.Interface.RegistrarUsuarioContract;
import com.example.organizadorultradia.Presenter.UsuarioRegistrarPresentador;
import com.example.organizadorultradia.R;

public class Activity_UsuarioRegistrar extends AppCompatActivity implements RegistrarUsuarioContract.view{
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
     presentador = new UsuarioRegistrarPresentador();
     presentador.setView(this);
     email =(EditText) findViewById(R.id.Email);
     password = (EditText)findViewById(R.id.Pass);
     passwordConfi = (EditText) findViewById(R.id.ConfiPass);
     registrar =(Button) this.findViewById(R.id.registrarUsuario);
     setUpListeners();
    }

    private void setUpListeners() {

            registrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String em = email.getText().toString();
                    String pas= password.getText().toString();
                    String pass2= passwordConfi.getText().toString();
                    if (pas.equals(pass2)){
                        presentador.registrarLogin(em,pas);
                    }else
                    {
                    //hacer un cuadro de dialogo
                    }

                }
            });



    }

}
