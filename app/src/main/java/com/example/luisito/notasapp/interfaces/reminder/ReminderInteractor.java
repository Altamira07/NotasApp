package com.example.luisito.notasapp.interfaces.reminder;

/**
 * Created by luisito on 12/12/17.
 */

public interface ReminderInteractor {
    void createReminder(String titulo,String fecha);
    void updateReminder(int id, String titulo,String fecha );
    void deleteReminder(int id);
}
