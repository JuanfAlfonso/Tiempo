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
                actividad.setText("");
                visualizarAct(year, month, dayOfMonth);

            }
        });
    }
    private void visualizarAct(int year, int month, int dayOfMonth) {

        String total="";
        for (int i =0;i<Mensaje.size()-1;i++){
          total=Mensaje.get(i)+"\n"+Mensaje.get(i+1);
        }
        actividad.setText(total);
        /*
        ArrayList<Informacion> Mensaje2= new ArrayList<>();
        String fecha= year +"/"+month+"/"+dayOfMonth;
        for(int i =0;i<Mensaje.size();i++)
        {
            if(Mensaje.get(i).fecha.equals(fecha))
            {
                Mensaje2.add(Mensaje.get(i));
            }
        }
        String negrosetHp="";
        for(int i =0;i<Mensaje2.size();i++)
        {
            negrosetHp+="Titulo:" + Mensaje2.get(i).titulo +"\n" + "  Duracion:" + Mensaje2.get(i).getDuracion() +"\n"+ "  Descripcion:" + Mensaje2.get(i).getDescripcion()+"Hora inicio: "+
                    "\n"+Mensaje2.get(i).hora+ "Hora fin: "+ "\n"+Mensaje2.get(i).horafin+"\n"+"\n";
        }
        actividad.setText(negrosetHp);*/
    }
}