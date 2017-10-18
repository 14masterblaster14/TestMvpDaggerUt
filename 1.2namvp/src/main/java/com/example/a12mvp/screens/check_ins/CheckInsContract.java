package com.example.a12mvp.screens.check_ins;

import com.example.a12mvp.Main.MainPresenter;
import com.example.a12mvp.Main.MainView;

import java.util.List;

/**
 * Created by ADMIN on 9/29/2017.
 */

public interface CheckInsContract {

    interface CheckInsView extends MainView<CheckInsPresenter> {
        void displayCheckIns(List<CheckIn> checkIns);

        void displayEmptyPlaceholder(boolean isShown);

        void showProgress(String message);

        void dismissProgress();

        void showMessage(String message);
    }

    interface CheckInsPresenter extends MainPresenter {
        void refresh();

        void getMyCheckIns();

        void getAllCheckIns();
    }
}
