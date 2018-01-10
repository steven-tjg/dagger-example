package com.steven.example.daggerexample;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public MainActivityMVP.Presenter provideMainActivityPresenter(MainActivityMVP.Model model) {
        return new MainActivityPresenter(model);
    }

    @Provides
    public MainActivityMVP.Model provideMainActivityModel(LoginRepository repository) {
        return new LoginModel(repository);
    }

    @Provides
    public LoginRepository provideLoginRepository() {
        return new MemoryRepository();
    }
}
