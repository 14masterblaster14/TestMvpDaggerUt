package com.example.a1mvp.main;

import java.util.List;

/**
 * Created by ADMIN on 9/28/2017.
 */

public interface MainView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
