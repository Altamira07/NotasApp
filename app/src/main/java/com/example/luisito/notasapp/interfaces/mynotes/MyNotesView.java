package com.example.luisito.notasapp.interfaces.mynotes;

import android.view.View;

import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 10/12/17.
 */

public interface MyNotesView {
    void showProgress(boolean option);
    void showMessage(String message);
    void loadMyNotesView(List<Nota> notas);
    void refreshNotes(List<Nota> notas);
    void refresh();
}
