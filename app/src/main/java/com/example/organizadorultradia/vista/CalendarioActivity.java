package com.example.organizadorultradia.vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.organizadorultradia.R;
import com.example.organizadorultradia.vista.Activity_duo;

public class CalendarioActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
    }
    public void Previous(View view){
        Intent previous = new Intent(this, Activity_duo.class);
        startActivity(previous);
    }
}
