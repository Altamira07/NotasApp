package com.example.luisito.notasapp.presenters;

import com.example.luisito.notasapp.interactors.SettingsInteractorImp;
import com.example.luisito.notasapp.interfaces.settings.SettingsInteractor;
import com.example.luisito.notasapp.interfaces.settings.SettingsPresenter;
import com.example.luisito.notasapp.interfaces.settings.SettingsView;

/**
 * Created by luisito on 10/12/17.
 */

public class SettingsPresenterImp implements SettingsPresenter {
    private SettingsView view;
    private SettingsInteractor interactor;

    public SettingsPresenterImp(SettingsView view) {
        this.view = view;
        interactor = new SettingsInteractorImp(this);
    }

    @Override
    public void saveSettingsPresenter(String name, String lastName,String email) {
        if(view !=null)
        {
            view.showProgress(true);
            interactor.save(name,lastName,email);
        }
    }

    @Override
    public void showMessage(String message) {
        if(view !=null)
        {
            view.showProgress(false);
            view.showMessage(message);
        }
    }

    @Override
    public void loadSettingsPresenter(String name,String lastName,String email) {
        if(view !=null)
        {
            view.showProgress(false);
            view.loadInfo(name,lastName,email);
        }
    }

    @Override
    public void load() {
        if(view != null)
        {
            view.showProgress(true);
            interactor.load();
        }
    }

}
