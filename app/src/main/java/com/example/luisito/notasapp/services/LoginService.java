package com.example.luisito.notasapp.services;

import com.example.luisito.notasapp.models.Mensaje;
import com.example.luisito.notasapp.models.Response;
import com.example.luisito.notasapp.models.ResponseMensaje;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by luisito on 10/12/17.
 */

public interface LoginService
{
    @FormUrlEncoded
    @POST("api/signIn")
    Call<Response> login(@Field("correo") String email, @Field("contrasena") String password,@Field("token")String  token);
    @FormUrlEncoded
    @POST("api/signUp")
    Call<Response> signUp(@Field("correo") String email, @Field("contrasena") String password,@Field("token") String token);
    @POST("api/logout")
    Call<ResponseMensaje> logout(@Header("Authorization")String auth);
}
