package com.example.luisito.notasapp.interfaces.settings;

/**
 * Created by luisito on 10/12/17.
 */

public interface SettingsView {
    void showProgress(boolean option);
    void showMessage(String message);
    void loadInfo(String name,String lastName,String email);
}
