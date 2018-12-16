package com.example.luisito.notasapp.interfaces.sharednotes;

import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 12/12/17.
 */

public interface MyNotesSharedView {
    void showProgress(boolean option);
    void showMessage(String message);
    void loadMyNotesView(List<Nota> notas);
    void refresh();

}
