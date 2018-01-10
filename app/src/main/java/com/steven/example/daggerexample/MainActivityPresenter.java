package com.steven.example.daggerexample;

import android.support.annotation.Nullable;

public class MainActivityPresenter implements MainActivityMVP.Presenter {

    @Nullable
    private MainActivityMVP.View mView;
    private MainActivityMVP.Model mModel;

    public MainActivityPresenter(MainActivityMVP.Model model) {
        this.mModel = model;
    }

    @Override
    public void setView(MainActivityMVP.View view) {
        this.mView = view;
    }

    @Override
    public void loginButtonClicked() {
        if (mView != null) {
            if (mView.getUsername().trim().isEmpty() || mView.getPassword().trim().isEmpty()) {
                mView.showInputError();
            } else {
                mModel.createUser(mView.getUsername(), mView.getPassword());
                mView.showSuccessMessage();
            }
        }
    }

    @Override
    public void getCurrentUser() {
        User user = mModel.getUser();

        if (user == null) {
            if (mView != null) {
                mView.showUserNotAvailable();
            }
        } else {
            if (mView != null) {
                mView.setUsername(user.getUsername());
                mView.setPassword(user.getPassword());
            }
        }
    }
}
