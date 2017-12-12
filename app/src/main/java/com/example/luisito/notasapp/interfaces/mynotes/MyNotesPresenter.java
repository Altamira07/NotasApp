package com.example.luisito.notasapp.interfaces.mynotes;

import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 10/12/17.
 */

public interface MyNotesPresenter {
    void loadNotesPresenter();
    void loadSuccess(List<Nota> notas);
    void showMessage(String message);
    void createNote(String title,String content);
    void delete(int id);
    void update(int id,String title,String content);
    void shared(int idNote,String email);
}
