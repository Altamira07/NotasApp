package com.example.luisito.notasapp.interactors;

import android.util.Log;

import com.example.luisito.notasapp.interfaces.mynotes.MyNotesInteractor;
import com.example.luisito.notasapp.interfaces.mynotes.MyNotesPresenter;
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
 * Created by luisito on 10/12/17.
 */

public class MyNotesInteractorImp implements MyNotesInteractor {

    private MyNotesPresenter presenter;
    private Retrofit retrofit;
    private NoteService service;
    public MyNotesInteractorImp(MyNotesPresenter presenter)
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
        Call<ResponseNotas> responseNotasCall = service.getNotas(Util.TOKEN);
        responseNotasCall.enqueue(new Callback<ResponseNotas>() {
            @Override
            public void onResponse(Call<ResponseNotas> call, Response<ResponseNotas> response) {
                if(response.body().getCode() == 200)
                    presenter.loadSuccess(response.body().getNotas());
                else
                    presenter.showMessage(response.body().getMensaje());
            }

            @Override
            public void onFailure(Call<ResponseNotas> call, Throwable t) {
                presenter.showMessage(t.getMessage());
            }
        });
    }


    @Override
    public void updateNote(int id, String title, String content) {
        Call<ResponseMensaje> response = service.updateNota(Util.TOKEN,id,title,content);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {
                presenter.showMessage(response.body().getMensaje());
            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {
                presenter.showMessage(t.getMessage());
            }
        });
    }

    @Override
    public void deleteNote(int id) {
        Call<ResponseMensaje> response = service.deleteNota(Util.TOKEN,id);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {
                presenter.showMessage(response.body().getMensaje());
            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {
                presenter.showMessage(t.getMessage());
            }
        });
    }

    @Override
    public void saveNote(String title, String content) {
        Call<ResponseMensaje> response = service.saveNota(Util.TOKEN,title,content);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {
                presenter.showMessage(response.body().getMensaje());

            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {
                presenter.showMessage(t.getMessage());
            }
        });
    }

    @Override
    public void sharedNote(int idNote, String email) {
        final Call<ResponseMensaje> response = service.sharedNota(Util.TOKEN,idNote,email);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {
                presenter.showMessage(response.body().getMensaje());
            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {
                presenter.showMessage(t.getMessage());
            }
        });
    }
}
