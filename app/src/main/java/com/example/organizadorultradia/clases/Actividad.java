package com.example.organizadorultradia.clases;

public class Actividad {
    String Actividades,Duracion,Descripcion;
  public Actividad(String act,String dur,String des)
  {
      this.Actividades= act;
      this.Duracion=dur;
      this.Descripcion=des;

  }
    public String getActividades() {
        return Actividades;
    }

    public void setActividades(String actividades) {
        Actividades = actividades;
    }

    public String getDuracion() {
        return Duracion;
    }

    public void setDuracion(String duracion) {
        Duracion = duracion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
