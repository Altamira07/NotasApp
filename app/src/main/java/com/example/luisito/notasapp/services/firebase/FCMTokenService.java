package com.example.luisito.notasapp.services.firebase;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.luisito.notasapp.views.activities.LoginActivity;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by luisito on 12/12/17.
 */
import com.google.firebase.iid.FirebaseInstanceId;

import java.util.HashMap;

public class FCMTokenService extends FirebaseInstanceIdService
{
    @Override
    public void onTokenRefresh()
    {
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.e("TokenF",token);
        regToken( token );
    }
    private void regToken(String token)
    {
        SharedPreferences preferences = getSharedPreferences("preferenciasApp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("token",token);
        editor.commit();
    }


}

