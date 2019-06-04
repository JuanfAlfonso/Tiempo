package com.example.organizadorultradia.vista;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.organizadorultradia.Interface.CalendarContract;
import com.example.organizadorultradia.Presenter.CalendarioPresentador;
import com.example.organizadorultradia.R;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarioActivity extends AppCompatActivity {

    TextView actividad;
    CalendarContract.presentador presentador;
    CompactCalendarView Calendario;
    TextView titulo;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-yyyy", Locale.getDefault());

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        titulo = (TextView) findViewById(R.id.titulo);
        setUpActivity();
        Calendar c = Calendar.getInstance();
        titulo.setText(busquedaMes(c.get(Calendar.MONTH)) + "-" + c.get(Calendar.YEAR));
        Calendario.addEvent(new Event(Color.GREEN, 1559638800L));
    }

    private void setUpActivity() {
        Calendario = findViewById(R.id.calendar);
        Calendario.setUseThreeLetterAbbreviation(true);
        Calendario.setFirstDayOfWeek(Calendar.SUNDAY);
        actividad = findViewById(R.id.Actividades);
        presentador = new CalendarioPresentador(getApplicationContext());
        Event ev1 = new Event(Color.GREEN, 1433701251000L, "Some extra data that I want to store.");
        setUpListeners();
    }

    public String busquedaMes(int mes) {
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
                titulo.setText(busquedaMes(Integer.parseInt(noEntiendo[0]) - 1) + "-" + Integer.parseInt(noEntiendo[1]));
            }
        });
    }

}