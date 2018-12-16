package com.example.luisito.notasapp.models;

/**
 * Created by luisito on 10/12/17.
 */

public class Usuario {

    private String nombre;
    private String apaterno;
    private String amaterno;
    private String correo;

    /**
     * No args constructor for use in serialization
     *
     */
    public Usuario() {
    }

    /**
     *
     * @param nombre
     * @param amaterno
     * @param apaterno
     * @param correo
     */
    public Usuario(String nombre, String apaterno, String amaterno, String correo) {
        super();
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}