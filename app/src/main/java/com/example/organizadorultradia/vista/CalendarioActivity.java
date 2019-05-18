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
import com.example.organizadorultradia.clases.Actividad;
import com.example.organizadorultradia.clases.Informacion;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;

public class CalendarioActivity extends AppCompatActivity {

    TextView actividad;
    CalendarContract.presentador presentador;
    ArrayList<String> Mensaje= new ArrayList<>();
    CompactCalendarView Calendario;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        setUpActivity();
    }
    private void setUpActivity() {
        Calendario = findViewById(R.id.calendar);
        Calendario.setUseThreeLetterAbbreviation(true);
        Calendario.setFirstDayOfWeek(Calendar.SUNDAY);
        actividad=findViewById(R.id.Actividades);
        presentador= new CalendarioPresentador(getApplicationContext());
        setUpListeners();
    }

    private void setUpListeners() {
        Calendario.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {

            }
        });
    }
    private void visualizarAct(int year, int month, int dayOfMonth) {

        String total="";
        for (int i =0;i<Mensaje.size()-1;i++){
          total=Mensaje.get(i)+"\n"+Mensaje.get(i+1);
        }
        actividad.setText(total);
    }
}