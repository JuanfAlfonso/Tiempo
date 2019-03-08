package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Presenter.LoginPresentador;
import com.example.organizadorultradia.R;
import com.example.organizadorultradia.clases.Usuario;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private EditText email;
    private EditText password;
    private Button loginButton;
    private Button registrar;
    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpActivity();
        //getApplicationContext();
    }

    private void setUpActivity() {
        presenter = new LoginPresentador(getApplicationContext());
        presenter.setView(this);
        email =  findViewById(R.id.Email);
        password =  findViewById(R.id.Pass);
        loginButton =  this.findViewById(R.id.loginButtom);
        registrar =  this.findViewById(R.id.registrarUsuario);

        setUpListeners();
    }

    private void setUpListeners() {
        loginButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String textEmail = email.getText().toString();
                        String textPassword = password.getText().toString();
                        if (!textEmail.equals("") && !textPassword.equals(""))

                            presenter.validarLogin(textEmail, textPassword);
                    }
                });

    }

    public void registrar(View view) {
        Intent next = new Intent(this, Activity_UsuarioRegistrar.class);
        startActivity(next);
    }

    public void Prueba(View view) {
        Intent next = new Intent(this, Activity_duo.class);
        startActivity(next);
    }

    @Override
    public void sucessfulSignIn(String m, String p) {
        System.out.println("email: " + m + " password: " + p + " desde la vista");
    }


}