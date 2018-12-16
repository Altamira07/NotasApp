package com.example.luisito.notasapp.interactors;

import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedInteractor;
import com.example.luisito.notasapp.interfaces.sharednotes.MyNotesSharedPresenter;
import com.example.luisito.notasapp.models.ResponseMensaje;
import com.example.luisito.notasapp.models.ResponseNota;
import com.example.luisito.notasapp.models.ResponseNotas;
import com.example.luisito.notasapp.services.NoteService;
import com.example.luisito.notasapp.utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by luisito on 12/12/17.
 */

public class MyNotesSharedInteractorImp implements MyNotesSharedInteractor {
    private Retrofit retrofit;
    private NoteService service;
    private MyNotesSharedPresenter presenter;
    public  MyNotesSharedInteractorImp(MyNotesSharedPresenter presenter)
    {
        this.presenter = presenter;
        retrofit  = new Retrofit.Builder()
                .baseUrl(Util.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(NoteService.class);
    }
    @Override
    public void loadNotes() {
        Call<ResponseNotas> response= service.getNotasCompartidas(Util.TOKEN);
        response.enqueue(new Callback<ResponseNotas>() {
            @Override
            public void onResponse(Call<ResponseNotas> call, Response<ResponseNotas> response) {
                presenter.loadSuccess(response.body().getNotas());
            }

            @Override
            public void onFailure(Call<ResponseNotas> call, Throwable t) {

            }
        });
    }

    @Override
    public void delete(int id) {
        Call<ResponseMensaje> response = service.deleteCompartidas(Util.TOKEN,id);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {
                presenter.success(response.body().getMensaje());
            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {
                presenter.success(t.getMessage());
            }
        });
    }
}
