package com.example.a12mvp.screens;

import com.example.a12mvp.Main.MainPresenter;
import com.example.a12mvp.Main.MainView;

/**
 * Created by ADMIN on 9/29/2017.
 */

public interface NavigationContract {

    interface NavigationView extends MainView<NavigationPresenter> {
        void setToolbarTitle(String title);

        void displayIndicatorStatus(boolean isAuthorized);

        void displayAuthScreen();

        void displayHomeScreen();

        void displayCheckInsScreen();
    }

    interface NavigationPresenter extends MainPresenter {

    }
}
