package com.example.luisito.notasapp.interactors;

import com.example.luisito.notasapp.interfaces.login.LoginInteractor;
import com.example.luisito.notasapp.interfaces.login.LoginPresenter;
import com.example.luisito.notasapp.models.Response;
import com.example.luisito.notasapp.services.LoginService;
import com.example.luisito.notasapp.utils.Interactor;
import com.example.luisito.notasapp.utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luisito on 10/12/17.
 */
public class LoginInteractorImp extends Interactor implements LoginInteractor {
    private LoginPresenter presenter;
    private  Retrofit retrofit;
    private LoginService services;
    public LoginInteractorImp(LoginPresenter presenter) {
        this.presenter = presenter;
        retrofit  = new Retrofit.Builder()
                .baseUrl(Util.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        services = retrofit.create(LoginService.class);
    }
    @Override
    public void login(String email, String password,String token) {
        if(!email.equals("") && !password.equals(""))
        {
            Call<Response>response = services.login(email,Util.md5(password),token);
            response.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    presenter.showResultPresenter(false);
                    if(response.body().getMensaje().getCode() == 200)
                    {
                        Util.TOKEN = response.body().getMensaje().getToken();
                        presenter.showResultPresenter(true);
                    }
                    presenter.showErrorPresenter(response.body().getMensaje().getMsj());
                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    presenter.showErrorPresenter(t.getMessage());
                }
            });

        }else
            presenter.showErrorPresenter("Los campos son obligatorios");
    }

    @Override
    public void sigUp(String email, String password,String token) {
        if(!email.equals("") && !password.equals(""))
        {
            Call<Response> response = services.signUp(email,Util.md5(password),token);
            response.enqueue(new Callback<Response>() {
                @Override
                public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                    if(response.body().getMensaje().getCode() == 200)
                    {
                        Util.TOKEN = response.body().getMensaje().getToken();
                        presenter.showResultPresenter(true);
                    }
                     presenter.showErrorPresenter(response.body().getMensaje().getMsj());

                }

                @Override
                public void onFailure(Call<Response> call, Throwable t) {
                    presenter.showErrorPresenter(t.getMessage());
                }
            });
        }else
            presenter.showErrorPresenter("Los campos son obligatorios");
    }
}
