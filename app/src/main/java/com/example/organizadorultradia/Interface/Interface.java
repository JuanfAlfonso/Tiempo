package com.example.organizadorultradia.Interface;

public interface Interface {
    interface View{

    }

    interface Presenter{
        void RegistrarLogin(String Email, int Pass);
        void RegistrarActividad(String actividad,int duracion,String descripcion);
    }

    interface Model{
      void RegistrarLogin(String Email, int Pass);
      void RegistrarActividad(String actividad,int duracion,String descripcion);
    }




}
