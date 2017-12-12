package com.example.luisito.notasapp.presenters;

import com.example.luisito.notasapp.interactors.MyNotesInteractorImp;
import com.example.luisito.notasapp.interfaces.mynotes.MyNotesPresenter;
import com.example.luisito.notasapp.interfaces.mynotes.MyNotesView;
import com.example.luisito.notasapp.models.Nota;

import java.util.List;

/**
 * Created by luisito on 10/12/17.
 */

public class MyNotesPresenterImp implements MyNotesPresenter {
    private MyNotesView view;
    private MyNotesInteractorImp interactor;
    public MyNotesPresenterImp(MyNotesView view) {
        this.view = view;
        interactor = new MyNotesInteractorImp(this);
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
    public void showMessage(String message) {
        if (view != null)
        {
            view.showProgress(false);
            view.showMessage(message);
        }
    }

    @Override
    public void createNote(String title, String content) {
        if(view != null)
        {
            view.showProgress(true);
            interactor.saveNote(title,content);
        }
    }


    @Override
    public void delete(int id) {
        if(view != null)
        {
            interactor.deleteNote(id);
            view.showProgress(true);
        }
    }

    @Override
    public void update(int id, String title, String content) {
        if(view != null)
        {
            interactor.updateNote(id,title,content);
            view.showProgress(true);
        }
    }

    @Override
    public void shared(int idNote, String email) {
        if(view != null)
        {
            view.showProgress(true);
            interactor.sharedNote(idNote,email);
        }
    }


}
