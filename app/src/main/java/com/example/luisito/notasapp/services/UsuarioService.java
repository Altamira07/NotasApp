package com.example.luisito.notasapp.services;

import com.example.luisito.notasapp.models.Response;
import com.example.luisito.notasapp.models.ResponseUsuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by luisito on 10/12/17.
 */

public interface UsuarioService {

    @POST("api/usuario")
    Call<ResponseUsuario> getUsuario(@Header("Authorization")String auth);

    @FormUrlEncoded
    @PUT("api/usuario")
    Call<ResponseUsuario> putUsuario(@Header("Authorization")String auth, @Field("nombre") String nombre,@Field("apaterno") String apaterno, @Field("amaterno") String amaterno);

}
