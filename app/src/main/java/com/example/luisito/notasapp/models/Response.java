package com.example.luisito.notasapp.models;

/**
 * Created by luisito on 10/12/17.
 */
public class Response {

    private Mensaje mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public Response() {
    }

    /**
     *
     * @param mensaje
     */
    public Response(Mensaje mensaje) {
        super();
        this.mensaje = mensaje;
    }

    public Mensaje getMensaje() {
        return mensaje;
    }

    public void setMensaje(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

}