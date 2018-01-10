package com.steven.example.daggerexample;

public interface LoginRepository {
    User getUser();

    void saveUser(User user);
}
