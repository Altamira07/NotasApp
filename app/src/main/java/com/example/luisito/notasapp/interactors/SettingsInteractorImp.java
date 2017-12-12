package com.example.luisito.notasapp.interactors;

import android.widget.Toast;

import com.example.luisito.notasapp.interfaces.settings.SettingsInteractor;
import com.example.luisito.notasapp.interfaces.settings.SettingsPresenter;
import com.example.luisito.notasapp.models.ResponseUsuario;
import com.example.luisito.notasapp.models.Usuario;
import com.example.luisito.notasapp.services.UsuarioService;
import com.example.luisito.notasapp.utils.Interactor;
import com.example.luisito.notasapp.utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luisito on 10/12/17.
 */

public class SettingsInteractorImp extends Interactor implements SettingsInteractor {
    private SettingsPresenter presenter;
    private UsuarioService service;
    public SettingsInteractorImp(SettingsPresenter presenter) {
        this.presenter = presenter;
        retrofit  = new Retrofit.Builder()
                .baseUrl(Util.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(UsuarioService.class);
    }

    @Override
    public void load() {
        Call<ResponseUsuario> usuario = service.getUsuario(Util.TOKEN);
        usuario.enqueue(new Callback<ResponseUsuario>() {
            @Override
            public void onResponse(Call<ResponseUsuario> call, Response<ResponseUsuario> response) {
                if(response.body().getCode() == 200)
                {
                    presenter.loadSettingsPresenter(
                            response.body().getUsuario().getNombre(),
                            response.body().getUsuario().getApaterno()+" "+response.body().getUsuario().getAmaterno(),
                            response.body().getUsuario().getCorreo());
                }else{
                    presenter.showMessage("No se encontro tu usuario");
                }
            }

            @Override
            public void onFailure(Call<ResponseUsuario> call, Throwable t) {
                presenter.showMessage("No cargo");
            }
        });
    }

    @Override
    public void save(String name, String lastName, String email) {
        String []last = lastName.split(" ");
        Call<ResponseUsuario> save;
        if(last.length == 2)
            save = service.putUsuario(Util.TOKEN,name,last[0],last[1]);
        else
            save = service.putUsuario(Util.TOKEN,name,lastName,"");
        save.enqueue(new Callback<ResponseUsuario>() {
            @Override
            public void onResponse(Call<ResponseUsuario> call, Response<ResponseUsuario> response) {
                presenter.showMessage(response.body().getMensaje());

            }

            @Override
            public void onFailure(Call<ResponseUsuario> call, Throwable t) {
                presenter.showMessage(t.toString());
            }
        });

    }
}
