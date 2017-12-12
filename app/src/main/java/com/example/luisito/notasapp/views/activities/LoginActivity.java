package com.example.luisito.notasapp.views.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.interfaces.login.LoginPresenter;
import com.example.luisito.notasapp.interfaces.login.LoginView;
import com.example.luisito.notasapp.presenters.LoginPresenterImp;
import com.example.luisito.notasapp.utils.Util;

/**
 * Created by luisito on 10/12/17.
 */

public class LoginActivity extends AppCompatActivity implements LoginView,View.OnClickListener {

    private LoginPresenter presenter;
    private ProgressBar progressBar;
    private EditText email;
    private EditText password;
    private Button login;
    private  Button signUp;
    private LinearLayout loyout;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        progressBar = (ProgressBar) findViewById(R.id.login_progress);
        email = (EditText) findViewById(R.id.login_email);
        password = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.login_login);
        login.setOnClickListener(this);
        presenter = new LoginPresenterImp(this);
        loyout = (LinearLayout) findViewById(R.id.login_layout);
        signUp = (Button) findViewById(R.id.login_singup);
        signUp.setOnClickListener(this);
        if(Util.TOKEN != "") {
            showResult(true);
        }

    }

    @Override
    public void showError(String error) {
        Toast.makeText(this,error,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showProgress(boolean option) {
        if(option)
        {
            loyout.setVisibility(View.GONE);
            progressBar.setVisibility(View.VISIBLE);
        }else{
            loyout.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.GONE);
        }
    }
    @Override
    public void showResult(boolean success) {
        if (success)
        {
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View v) {
        String email = this.email.getText().toString();
        String password = this.password.getText().toString();
        SharedPreferences preferences = getSharedPreferences("preferenciasApp", Context.MODE_PRIVATE);
        String token = preferences.getString("token","");
        switch (v.getId())
        {
            case R.id.login_login:
                presenter.loginPresenter(email,password,token);
                break;
            case R.id.login_singup:
                presenter.signUp(email,password,token);
                break;
        }
    }

}
