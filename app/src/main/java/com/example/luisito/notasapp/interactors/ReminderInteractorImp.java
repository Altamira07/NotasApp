package com.example.luisito.notasapp.interactors;

import android.util.Log;

import com.example.luisito.notasapp.interfaces.reminder.ReminderInteractor;
import com.example.luisito.notasapp.models.ResponseMensaje;
import com.example.luisito.notasapp.services.ReminderService;
import com.example.luisito.notasapp.utils.Util;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ReminderInteractorImp implements ReminderInteractor {
    private Retrofit retrofit;
    private ReminderService service;

    public ReminderInteractorImp()
    {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(Util.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ReminderService.class);
    }


    @Override
    public void createReminder(String titulo, String fecha) {
        Call<ResponseMensaje> response = service.createReminder(Util.TOKEN,titulo,fecha);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {
                Log.e("Respuesta",response.body().getMensaje());
            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {
                Log.e("Respuesta",t.toString());
            }
        });
    }

    @Override
    public void updateReminder(int id, String titulo, String fecha) {
        Call<ResponseMensaje> response = service.updateReminder(Util.TOKEN,id,titulo,fecha);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {

            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {

            }
        });
    }

    @Override
    public void deleteReminder(int id) {
        Call<ResponseMensaje> response = service.deleteReminder(Util.TOKEN,id);
        response.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, Response<ResponseMensaje> response) {

            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {

            }
        });
    }
}
