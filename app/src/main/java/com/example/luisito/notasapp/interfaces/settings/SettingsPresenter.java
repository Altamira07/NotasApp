package com.example.luisito.notasapp.interfaces.settings;

/**
 * Created by luisito on 10/12/17.
 */

public interface SettingsPresenter {
    void saveSettingsPresenter(String name,String lastName,String email);
    void showMessage(String message);
    void loadSettingsPresenter(String name,String lastName,String email);
    void load();
}
