package com.example.luisito.notasapp.interfaces.login;

/**
 * Created by luisito on 10/12/17.
 */

public interface LoginPresenter {
    void showErrorPresenter(String result);
    void showResultPresenter(Boolean success);
    void loginPresenter(String email,String password,String token);
    void signUp(String email,String password,String token);
}
