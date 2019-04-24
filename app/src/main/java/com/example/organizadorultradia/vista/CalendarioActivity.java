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
import java.util.ArrayList;
import java.util.LinkedList;

public class CalendarioActivity extends AppCompatActivity {

    CalendarView calendario;
    TextView actividad;
    CalendarContract.presentador presentador;
    ArrayList<String> Mensaje= new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        setUpActivity();
    }
    private void setUpActivity() {

        calendario=findViewById(R.id.calendar);
        actividad=findViewById(R.id.Actividades);
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
                Mensaje = presentador.getMensaje();
                visualizarAct();

            }
        });
    }
    private void visualizarAct() {
        String total="";
        for (int i =0;i<Mensaje.size()-1;i++){
          total=Mensaje.get(i)+"\n"+Mensaje.get(i+1);
        }
        actividad.setText(total);
    }
}