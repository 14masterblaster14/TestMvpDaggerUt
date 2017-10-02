package com.example.a2di.Dagger;

import android.content.Context;

import com.example.a2di.ShopApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ADMIN on 9/28/2017.
 */

@Module
public class AppModule {
    private final ShopApplication shopApplication;

    public AppModule(ShopApplication shopApplication) {
        this.shopApplication = shopApplication;
    }

@Provides
@Singleton
    public ShopApplication provideContext(){

    return shopApplication;
}
}
