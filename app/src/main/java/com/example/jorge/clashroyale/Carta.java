package com.example.jorge.clashroyale;

import java.io.Serializable;

public class Carta implements Serializable {

    private String nombre;
    private String calidad;
    private String tipo;
    private String descripcion;
    private String velocidad;
    private int imagen, imagenTabla;


    public Carta(String nombre, String calidad, String tipo, String descripcion, String velocidad, int imagen, int imagenTabla) {
        this.nombre = nombre;
        this.calidad = calidad;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.velocidad = velocidad;
        this.imagen = imagen;
        this.imagenTabla = imagenTabla;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCalidad() {
        return calidad;
    }

    public void setCalidad(String calidad) {
        this.calidad = calidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(String velocidad) {
        this.velocidad = velocidad;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getImagenTabla(){
        return imagenTabla;
    }

    public void setImagenTabla(int imagenTabla) {
        this.imagenTabla = imagenTabla;
    }
}
