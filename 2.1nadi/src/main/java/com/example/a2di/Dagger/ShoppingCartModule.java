package com.example.a2di.Dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.a2di.ShoppingCart;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ADMIN on 9/28/2017.
 */

@Module
public class ShoppingCartModule {

    @Provides @Singleton
    SharedPreferences provideSharedPreference(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides @Singleton
    ShoppingCart provideShoppingCart(SharedPreferences sharedPreferences){
        return new ShoppingCart(sharedPreferences);
    }
}
