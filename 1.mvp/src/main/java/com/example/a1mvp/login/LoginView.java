package com.example.a1mvp.login;

/**
 * Created by ADMIN on 9/28/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
