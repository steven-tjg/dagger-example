package com.steven.example.daggerexample;

public class MemoryRepository implements LoginRepository {

    private User mUser;

    @Override
    public User getUser() {
        if (mUser == null) {
            User user = new User("root", "admin");
            user.setId(0);
            return user;
        } else {
            return mUser;
        }
    }

    @Override
    public void saveUser(User user) {
        if (user == null) {
            user = getUser();
        }
        this.mUser = user;
    }
}
