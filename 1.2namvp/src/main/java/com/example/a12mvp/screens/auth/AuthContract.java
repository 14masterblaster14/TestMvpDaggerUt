package com.example.a12mvp.screens.auth;

import com.example.a12mvp.Main.MainPresenter;
import com.example.a12mvp.Main.MainView;
import com.example.a12mvp.utils.Constants;

/**
 * Created by ADMIN on 9/29/2017.
 */

public interface AuthContract {

    interface AuthView extends MainView<AuthPresenter> {
        String getEmail();

        String getPassword();

        void displayErrorEmail(Constants.ErrorCodes errorCode);

        void displayErrorPassword(Constants.ErrorCodes errorCode);

        void showProgress(String message);

        void dismissProgress();

        void showMessage(String message);
    }

    interface AuthPresenter extends MainPresenter {
        void signIn();

        void signUp();
    }
}
