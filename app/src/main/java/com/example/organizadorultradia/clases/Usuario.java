package com.example.organizadorultradia.clases;

public class Usuario {
    String email,password;

    public Usuario(String textEmail, String textPassword) {
        this.email=textEmail;
        this.password=textPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
