package com.example.luisito.notasapp.services;

import com.example.luisito.notasapp.models.Response;
import com.example.luisito.notasapp.models.ResponseMensaje;
import com.example.luisito.notasapp.models.ResponseNota;
import com.example.luisito.notasapp.models.ResponseNotas;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by luisito on 10/12/17.
 */

public interface NoteService {
    @GET("api/nota")
    Call<ResponseNotas> getNotas(@Header("Authorization")String auth);
    @FormUrlEncoded
    @POST("api/nota")
    Call<ResponseMensaje> saveNota(@Header("Authorization")String auth, @Field("titulo")String title, @Field("contenido") String content);
    @DELETE("api/nota/{id}")
    Call<ResponseMensaje> deleteNota(@Header("Authorization")String auth, @Path("id") int id);
    @FormUrlEncoded
    @PUT("api/nota/{id}")
    Call<ResponseMensaje> updateNota(@Header("Authorization")String auth,@Path("id") int id, @Field("titulo")String title, @Field("contenido") String content);
    //Note shared
    @FormUrlEncoded
    @POST("api/compartir")
    Call<ResponseMensaje> sharedNota(@Header("Authorization")String auth,@Field("id") int id,@Field("correo") String email);
    @GET("api/notas-compartidas")
    Call<ResponseNotas> getNotasCompartidas(@Header("Authorization")String auth);

    @DELETE("api/notas-compartidas/{id}")
    Call<ResponseMensaje> deleteCompartidas(@Header("Authorization")String auth,@Path("id") int id);


}
