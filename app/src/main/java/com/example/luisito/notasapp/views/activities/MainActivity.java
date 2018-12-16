package com.example.luisito.notasapp.views.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.models.Response;
import com.example.luisito.notasapp.models.ResponseMensaje;
import com.example.luisito.notasapp.services.LoginService;
import com.example.luisito.notasapp.utils.Util;
import com.example.luisito.notasapp.views.adapters.MainNotasPagerAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private MainNotasPagerAdapter adapter;
    private  Retrofit retrofit;
    private LoginService services;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabLayout.setupWithViewPager(viewPager);
        adapter = new MainNotasPagerAdapter(this.getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        retrofit  = new Retrofit.Builder()
                .baseUrl(Util.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        services = retrofit.create(LoginService.class);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        fm.popBackStack();
        switch (item.getItemId())
        {
            case R.id.settings:
                startActivity(new Intent(this,SettingsActivity.class));
                break;
            case R.id.synchronize:
                if(adapter != null)
                {
                    adapter.mnf.refresh();
                    adapter.msf.refresh();
                }
                break;
            case R.id.logout:
                logout();
                break;
        };
        return true;
    }

    private void logout()
    {
        final Context context = this.getApplicationContext();
        Call<ResponseMensaje> logout = services.logout(Util.TOKEN);
        logout.enqueue(new Callback<ResponseMensaje>() {
            @Override
            public void onResponse(Call<ResponseMensaje> call, retrofit2.Response<ResponseMensaje> response) {
                if(response.body().getCode() == 200)
                {
                    Util.TOKEN = "";
                    startActivity(new Intent(context,LoginActivity.class));
                    finish();
                }else
                    Toast.makeText(context,response.body().getMensaje(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<ResponseMensaje> call, Throwable t) {

            }
        });
    }
}
