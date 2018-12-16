package com.example.luisito.notasapp.models;

import java.util.List;

/**
 * Created by luisito on 10/12/17.
 */

public class ResponseNotas {

    private List<Nota> notas = null;
    private int code;
    private String mensaje;
    private Nota nota = null;
    public ResponseNotas() {
    }

    /**
     *
     * @param notas
     * @param mensaje
     * @param code
     */
    public ResponseNotas(List<Nota> notas, int code, String mensaje) {
        super();
        this.notas = notas;
        this.code = code;
        this.mensaje = mensaje;
    }
    public ResponseNotas(Nota nota, int code, String mensaje) {
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

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
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
