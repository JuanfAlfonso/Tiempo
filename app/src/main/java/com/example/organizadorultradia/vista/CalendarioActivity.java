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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.Locale;

public class CalendarioActivity extends AppCompatActivity {

    TextView actividad;
    CalendarContract.presentador presentador;
    CompactCalendarView Calendario;
    TextView titulo;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy",Locale.getDefault());
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        titulo= (TextView)findViewById(R.id.titulo);
        setUpActivity();
        Calendar c = Calendar.getInstance();
        titulo.setText(busquedaMes(c.get(Calendar.MONTH))+"-"+c.get(Calendar.YEAR));
    }
    private void setUpActivity() {
        Calendario = findViewById(R.id.calendar);
        Calendario.setUseThreeLetterAbbreviation(true);
        Calendario.setFirstDayOfWeek(Calendar.SUNDAY);
        actividad=findViewById(R.id.Actividades);
        presentador= new CalendarioPresentador(getApplicationContext());
        setUpListeners();
    }

    public String busquedaMes(int mes){
        ArrayList<String> meses = new ArrayList<>();
        meses.add("Enero");
        meses.add("Febrero");
        meses.add("Marzo");
        meses.add("Abril");
        meses.add("Mayo");
        meses.add("Junio");
        meses.add("Julio");
        meses.add("Agosto");
        meses.add("Septiembre");
        meses.add("Octubre");
        meses.add("Noviembre");
        meses.add("Diciembre");

        return meses.get(mes);
    }

    private void setUpListeners() {
        Calendario.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {

            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                String[] noEntiendo = dateFormat.format(firstDayOfNewMonth).split("-");
                titulo.setText(busquedaMes(Integer.parseInt(noEntiendo[0])-1)+"-"+Integer.parseInt(noEntiendo[1]));
            }
        });
    }
    private void visualizarAct(int year, int month, int dayOfMonth) {

    }
}