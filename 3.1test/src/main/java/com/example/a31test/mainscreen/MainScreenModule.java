package com.example.a31test.mainscreen;


import com.example.a31test.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aditya on 11-May-16.
 */
@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}
