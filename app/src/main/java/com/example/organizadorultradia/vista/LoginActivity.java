package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.organizadorultradia.Interface.LoginContract;
import com.example.organizadorultradia.Presenter.Presentador;
import com.example.organizadorultradia.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {
    private EditText email;
    private EditText password;
    private Button loginButton;
    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setUpActivity();
    }

    private void setUpActivity() {
        presenter = new Presentador();
        presenter.setView(this);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Pass);
        loginButton = (Button) this.findViewById(R.id.loginButtom);
        setUpListeners();
    }

    private void setUpListeners() {
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textEmail = email.getText().toString();
                String textPassword = password.getText().toString();
                if (!textEmail.equals("") && !textPassword.equals(""))
                    presenter.registrarLogin(textEmail, textPassword);
            }
        });
    }

    public void Prueba(View view) {
        Intent next = new Intent(this, Activity_duo.class);
        startActivity(next);
    }

    @Override
    public void sucessfulSignIn(String m, String p) {
        System.out.println("email: " + m + " password: " + p+" desde la vista");
    }

    //public void registrarUsuario(View view) {
    //    String email = email.getText().toString();
    //    String pass = password.getText().toString();
    //    if (email.equals("") && pass.equals("")) {
    //        Toast.makeText(this, "Campo vacio", Toast.LENGTH_LONG).show();
    //    } else{

    //    }
    //}

}