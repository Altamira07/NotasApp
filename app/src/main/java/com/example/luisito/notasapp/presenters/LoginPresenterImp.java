package com.example.luisito.notasapp.presenters;

import com.example.luisito.notasapp.interactors.LoginInteractorImp;
import com.example.luisito.notasapp.interfaces.login.LoginInteractor;
import com.example.luisito.notasapp.interfaces.login.LoginPresenter;
import com.example.luisito.notasapp.interfaces.login.LoginView;

/**
 * Created by luisito on 10/12/17.
 */

public class LoginPresenterImp implements LoginPresenter {
    LoginView view;
    LoginInteractor interactor;
    public  LoginPresenterImp(LoginView view)
    {
        this.view = view;
        interactor = new LoginInteractorImp(this);
    }

    @Override
    public void showErrorPresenter(String error) {
        if(view != null)
        {
            view.showProgress(false);
            view.showError(error);
        }
    }

    @Override
    public void showResultPresenter(Boolean success) {
        if(view != null)
        {
            view.showProgress(false);
            view.showResult(success);
        }
    }

    @Override
    public void loginPresenter(String email,String password,String token)
    {
        if(view != null)
        {
            view.showProgress(true);
            interactor.login(email,password,token);
        }
    }

    @Override
    public void signUp(String email, String password, String token) {
        if(view != null)
        {
            view.showProgress(true);
            interactor.sigUp(email,password,token);

        }
    }
}
