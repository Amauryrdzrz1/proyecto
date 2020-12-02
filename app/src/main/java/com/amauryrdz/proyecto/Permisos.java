package com.amauryrdz.proyecto;

public class Permisos {

    private String nombre;
    private String nombrepermiso;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombrepermiso() {
        return nombrepermiso;
    }

    public void setNombrepermiso(String nombrepermiso) {
        this.nombrepermiso = nombrepermiso;
    }

    public Permisos(String nombre, String nombrepermiso) {
        this.nombre = nombre;
        this.nombrepermiso = nombrepermiso;
    }
}
