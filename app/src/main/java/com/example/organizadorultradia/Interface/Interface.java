package com.example.organizadorultradia.Interface;

public interface Interface {
    interface View{

    }

    interface Presenter{
        boolean RegistrarLogin(String Email, String Pass);
        void RegistrarActividad(String actividad,String duracion,String descripcion);
        boolean isEmpty(String Email, String Pass);
    }

    interface Model{
      boolean RegistrarLogin(String Email, String Pass);
      void RegistrarActividad(String actividad,String duracion,String descripcion);
      boolean isEmpty(String Email, String Pass);
    }




}
