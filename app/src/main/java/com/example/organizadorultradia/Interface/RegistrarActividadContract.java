package com.example.organizadorultradia.Interface;

public interface RegistrarActividadContract {
    interface View{

    }
    interface Presenter{
        void registrarActividad(String actividad,String duracion,String descripcion);
        void comprobar(boolean com);

        boolean comprobarVacios();
    }
}
