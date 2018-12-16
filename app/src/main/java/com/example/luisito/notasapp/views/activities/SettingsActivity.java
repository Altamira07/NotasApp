package com.example.luisito.notasapp.views.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.luisito.notasapp.R;
import com.example.luisito.notasapp.interfaces.settings.SettingsPresenter;
import com.example.luisito.notasapp.interfaces.settings.SettingsView;
import com.example.luisito.notasapp.presenters.SettingsPresenterImp;

public class SettingsActivity extends AppCompatActivity implements SettingsView, View.OnClickListener {
    private EditText name;
    private EditText lastName;
    private EditText email;
    private Button save;
    private ProgressBar progressBar;
    private SettingsPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        progressBar = (ProgressBar) findViewById(R.id.settings_progress);
        name = (EditText) findViewById(R.id.settings_name);
        lastName = (EditText) findViewById(R.id.settings_last_name);
        email = (EditText) findViewById(R.id.settings_email);
        save = (Button) findViewById(R.id.settings_save);
        save.setOnClickListener(this);
        presenter = new SettingsPresenterImp(this);
        presenter.load();
    }

    @Override
    public void showProgress(boolean option) {
        if(option)
            progressBar.setVisibility(View.VISIBLE);
        else
            progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(this, message,Toast.LENGTH_SHORT).show();
    }


    @Override
    public void loadInfo(String name, String lastName, String email) {
        this.name.setText(name);
        this.lastName.setText(lastName);
        this.email.setText(email);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.settings_save)
        {
            String name,lastName,email;
            name = this.name.getText().toString();
            lastName = this.lastName.getText().toString();
            email = this.email.getText().toString();
            presenter.saveSettingsPresenter(name,lastName,email);
        }
    }
}
