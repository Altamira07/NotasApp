package com.example.luisito.notasapp.presenters;

import com.example.luisito.notasapp.interactors.MyNotesSharedInteractorImp;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedInteractor;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedPresenter;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedView;
import com.example.luisito.notasapp.models.Nota;

import java.util.List;

public class MyNotesSharedPresenterImp implements MyNotesSharedPresenter {
    MyNotesSharedView view;
    MyNotesSharedInteractorImp interactor;
    public MyNotesSharedPresenterImp(MyNotesSharedView view) {
        interactor = new MyNotesSharedInteractorImp(this);
        this.view = view;
    }
    @Override
    public void loadNotesPresenter() {

        if(view != null)
        {
            view.showProgress(true);
            interactor.loadNotes();
        }
    }

    @Override
    public void loadSuccess(List<Nota> notas) {
        if(view != null)
        {
            view.showProgress(false);
            view.loadMyNotesView(notas);
        }
    }

    @Override
    public void loadFail(String message)
    {
        if(view != null)
        {
            view.showProgress(false);
            view.showMessage(message);
        }
    }

    @Override
    public void deleteNote(int id) {
        if(view != null)
        {
            view.showProgress(true);
            interactor.delete(id);
        }
    }

    @Override
    public void success(String message) {
        if(view != null)
        {
            view.showProgress(false);
            view.showMessage(message);
        }
    }

}
