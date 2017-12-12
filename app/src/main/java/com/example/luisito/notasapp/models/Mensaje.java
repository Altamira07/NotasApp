package com.example.luisito.notasapp.models;

/**
 * Created by luisito on 10/12/17.
 */

public class Mensaje {

    private String msj;
    private String error;
    private String token;
    private int code;

    /**
     * No args constructor for use in serialization
     *
     */
    public Mensaje() {
    }

    /**
     *
     * @param error
     * @param token
     * @param msj
     * @param code
     */
    public Mensaje(String msj, String error, String token,int code) {
        super();
        this.msj = msj;
        this.error = error;
        this.token = token;
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

}