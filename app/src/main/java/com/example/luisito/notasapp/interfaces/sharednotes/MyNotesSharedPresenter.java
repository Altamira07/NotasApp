package com.example.luisito.notasapp.interfaces.sharednotes;

import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 12/12/17.
 */

public interface MyNotesSharedPresenter {
    void loadNotesPresenter();
    void loadSuccess(List<Nota> notas);
    void loadFail(String message);
    void deleteNote(int id);
    void success(String message);
}
