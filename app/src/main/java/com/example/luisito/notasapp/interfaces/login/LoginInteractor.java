package com.example.luisito.notasapp.interfaces.login;

/**
 * Created by luisito on 10/12/17.
 */

public interface LoginInteractor {
    void login(String email,String password,String token);
    void sigUp(String email,String password,String token);
}
