package com.example.luisito.notasapp.models;

/**
 * Created by luisito on 10/12/17.
 */

public class Nota {

    private int id;
    private String titulo;
    private String contenido;

    /**
     * No args constructor for use in serialization
     *
     */
    public Nota() {
    }

    /**
     *
     * @param id
     * @param titulo
     * @param contenido
     */
    public Nota(int id, String titulo, String contenido) {
        super();
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

}