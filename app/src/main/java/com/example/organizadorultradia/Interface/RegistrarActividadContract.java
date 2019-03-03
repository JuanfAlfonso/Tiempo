package com.example.organizadorultradia.Interface;

public interface RegistrarActividadContract {
    interface View{
      void sucessfulAct(String actividad,String duracion,String descripcion);
    }
    interface Presenter{
        void registrarActividad(String actividad,String duracion,String descripcion);
        void setView(RegistrarActividadContract.View view);
    }
}
