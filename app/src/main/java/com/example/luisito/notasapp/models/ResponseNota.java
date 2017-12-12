package com.example.luisito.notasapp.models;

import java.util.List;

/**
 * Created by luisito on 11/12/17.
 */

public class ResponseNota {
    private int code;
    private String mensaje;
    private Nota nota = null;
    public ResponseNota() {
    }

    public ResponseNota(Nota nota, int code, String mensaje) {
        super();
        this.nota = nota;
        this.code = code;
        this.mensaje = mensaje;
    }
    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
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