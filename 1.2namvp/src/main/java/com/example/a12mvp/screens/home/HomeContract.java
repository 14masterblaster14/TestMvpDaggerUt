package com.example.a12mvp.screens.home;

import com.example.a12mvp.Main.MainPresenter;
import com.example.a12mvp.Main.MainView;
import com.example.a12mvp.utils.Constants;

/**
 * Created by ADMIN on 9/29/2017.
 */

public interface HomeContract {

    interface HomeView extends MainView<MainPresenter> {
        void displayUID(String uid);

        void displayEmail(String email);

        String getCheckInMessage();

        void displayErrorCheckInMessage(Constants.ErrorCodes errorCode);

        void showProgress(String message);

        void dismissProgress();

        void showMessage(String message);

        void startCheckInsScreen();
    }

    interface HomePresenter extends MainPresenter {
        void post();

        void browse();

        void signOut();
    }
}
