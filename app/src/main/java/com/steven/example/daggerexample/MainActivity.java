package com.steven.example.daggerexample;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.Toast;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.View {

    @Inject
    MainActivityMVP.Presenter mPresenter;

    private TextInputEditText mUsername, mPassword;
    private AppCompatButton mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((App) getApplication()).getComponent().inject(this);

        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mLogin = findViewById(R.id.login);


        mLogin.setOnClickListener(v -> mPresenter.loginButtonClicked());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.setView(this);
    }

    @Override
    public String getUsername() {
        return mUsername.getText().toString();
    }

    @Override
    public void setUsername(String username) {
        mUsername.setText(username);
    }

    @Override
    public String getPassword() {
        return mPassword.getText().toString();
    }

    @Override
    public void setPassword(String password) {
        mPassword.setText(password);
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "User Not Available", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        if (mUsername.getText().toString().isEmpty())
            mUsername.setError("Username cannot be empty.");
        if (mPassword.getText().toString().isEmpty())
            mPassword.setError("Password cannot be empty.");
    }

    @Override
    public void showSuccessMessage() {
        Toast.makeText(this, "Login Success.", Toast.LENGTH_SHORT).show();
    }
}
