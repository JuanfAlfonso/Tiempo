package com.example.organizadorultradia.Interface;

public interface LoginContract {
    interface View{
       void sucessfulSignIn(String m, String p);
    }

    interface Presenter{
        void setView(LoginContract.View view);
        void registrarLogin(String Email, String Pass);
        void registrarActividad(String actividad,String duracion,String descripcion);
    }

   //interface Model{
   //  void RegistrarLogin(String Email, String Pass);
   //  void RegistrarActividad(String actividad,String duracion,String descripcion);
   //}


}
