package com.example.a12mvp.Main;

/**
 * Created by ADMIN on 9/29/2017.
 */

public interface MainView<T extends MainPresenter> {
    void initPresenter();

    void setPresenter(T presenter);
}
