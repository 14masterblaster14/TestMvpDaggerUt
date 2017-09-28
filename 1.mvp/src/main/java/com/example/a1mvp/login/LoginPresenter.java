package com.example.a1mvp.login;

/**
 * Created by ADMIN on 9/28/2017.
 */

public interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
