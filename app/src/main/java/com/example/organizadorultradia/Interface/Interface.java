package com.example.organizadorultradia.Interface;

public interface Interface {
    interface View{

    }

    interface Presenter{
        void RegistrarLogin(String Email, String Pass);
        void RegistrarActividad(String actividad,String duracion,String descripcion);
    }

    interface Model{
      void RegistrarLogin(String Email, String Pass);
      void RegistrarActividad(String actividad,String duracion,String descripcion);
    }




}
