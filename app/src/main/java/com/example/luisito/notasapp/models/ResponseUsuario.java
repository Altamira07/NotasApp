package com.example.luisito.notasapp.models;

/**
 * Created by luisito on 10/12/17.
 */

public class ResponseUsuario {

    private Usuario usuario;
    private int code;
    private String mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseUsuario() {
    }

    /**
     *
     * @param usuario
     * @param mensaje
     * @param code
     */
    public ResponseUsuario(Usuario usuario, int code, String mensaje) {
        super();
        this.usuario = usuario;
        this.code = code;
        this.mensaje = mensaje;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
