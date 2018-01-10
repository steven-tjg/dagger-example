package com.steven.example.daggerexample;

public interface MainActivityMVP {

    interface Model {
        void createUser(String username, String password);

        User getUser();
    }

    interface View {
        String getUsername();

        void setUsername(String username);

        String getPassword();

        void setPassword(String password);

        void showUserNotAvailable();

        void showInputError();

        void showSuccessMessage();
    }

    interface Presenter {
        void setView(MainActivityMVP.View view);

        void loginButtonClicked();

        void getCurrentUser();
    }
}
