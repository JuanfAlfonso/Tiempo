package com.example.organizadorultradia.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.organizadorultradia.Interface.CalendarContract;
import com.example.organizadorultradia.Presenter.CalendarioPresentador;
import com.example.organizadorultradia.R;

import java.sql.SQLOutput;

public class CalendarioActivity extends AppCompatActivity {

    CalendarView calendario;
    TextView actividad;
    CalendarContract.presentador presentador;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        setUpActivity();
    }
    private void setUpActivity() {

        calendario=(CalendarView)findViewById(R.id.calendar);
        actividad=(TextView)findViewById(R.id.Actividades);
        presentador= new CalendarioPresentador(getApplicationContext());
        setUpListeners();
    }

    private void setUpListeners() {
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
                presentador.enviarFecha(dayOfMonth,month,year);
                //actividad.setText("hola");
                actividad.setText(presentador.getMensaje());
            }
        });
    }

}