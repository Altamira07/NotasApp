package com.example.luisito.notasapp.services;

import com.example.luisito.notasapp.models.ResponseMensaje;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by luisito on 12/12/17.
 */

public interface ReminderService
{
    @FormUrlEncoded
    @POST("api/recordatorio")
    Call<ResponseMensaje> createReminder(@Header("Authorization")String auth, @Field("titulo") String titulo,@Field("fecha") String fecha);

    @PUT("api/recordatorio/{id}")
    Call<ResponseMensaje> updateReminder(@Header("Authorization")String auth, @Path("id") int id,@Field("titulo") String titulo, @Field("fecha") String fecha);

    @DELETE("api/recordatorio/{id}")
    Call<ResponseMensaje> deleteReminder(@Header("Authorization")String auth, @Path("id") int id);

}
