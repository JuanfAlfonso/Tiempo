package com.example.organizadorultradia.clases;

public class Informacion {
    public String fecha;
    public int hora;
    public String titulo, descripcion;
    public int duracion;
    public int horafin;

    public String getFecha() {
        return fecha;
    }

    public Informacion(String fecha, int hora, int horafin, String titulo, String descripcion, int duracion) {
        this.fecha = fecha;
        this.hora = hora;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.horafin=horafin;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getHorafin() {
        return horafin;
    }

    public void setHorafin(int horafin) {
        this.horafin = horafin;
    }
}
