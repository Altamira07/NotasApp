package com.example.luisito.notasapp.interfaces.login;

/**
 * Created by luisito on 10/12/17.
 */

public interface LoginView {
    void showError(String error);
    void showProgress(boolean option);
    void showResult(boolean success);
}
