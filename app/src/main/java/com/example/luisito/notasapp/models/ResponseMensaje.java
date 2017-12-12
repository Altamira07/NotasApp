package com.example.luisito.notasapp.models;

/**
 * Created by luisito on 11/12/17.
 */
public class ResponseMensaje {

    private int code;
    private String mensaje;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseMensaje() {
    }

    /**
     *
     * @param mensaje
     * @param code
     */
    public ResponseMensaje(int code, String mensaje) {
        super();
        this.code = code;
        this.mensaje = mensaje;
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
