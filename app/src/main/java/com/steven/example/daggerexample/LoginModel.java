package com.steven.example.daggerexample;

public class LoginModel implements MainActivityMVP.Model {

    private LoginRepository mRepository;

    public LoginModel(LoginRepository repository) {
        this.mRepository = repository;
    }

    @Override
    public void createUser(String username, String password) {
        mRepository.saveUser(new User(username, password));
    }

    @Override
    public User getUser() {
        return mRepository.getUser();
    }
}
