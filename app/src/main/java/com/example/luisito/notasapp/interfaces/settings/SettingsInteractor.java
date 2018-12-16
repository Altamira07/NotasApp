package com.example.luisito.notasapp.interfaces.settings;

/**
 * Created by luisito on 10/12/17.
 */

public interface SettingsInteractor {
    void load();
    void save(String name,String lastName,String email);
}
