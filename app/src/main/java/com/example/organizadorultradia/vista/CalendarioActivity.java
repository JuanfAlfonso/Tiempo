package com.example.organizadorultradia.vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;
import android.widget.Toast;

import com.example.organizadorultradia.Interface.CalendarioAbstract;
import com.example.organizadorultradia.Presenter.PresentadorCalendario;
import com.example.organizadorultradia.R;

public class CalendarioActivity extends AppCompatActivity {

    CalendarView calendario;
    CalendarioAbstract.presentador presentador = new PresentadorCalendario();
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendario);
        calendario=(CalendarView)findViewById(R.id.calendar);
        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener(){
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),dayOfMonth+"/"+month+"/"+year, Toast.LENGTH_LONG).show();
                System.out.println(dayOfMonth+" "+month+" "+year);
                presentador.enviardia(dayOfMonth,month,year);
            }
        });
    }
}
