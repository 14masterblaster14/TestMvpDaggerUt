package com.example.a22di.Dagger.module;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.a22di.MyApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ADMIN on 10/1/2017.
 */

@Module
public class StorageModule {

    private final MyApplication myApplication;

    public StorageModule(MyApplication myApplication) {
        this.myApplication = myApplication;
    }

    @Singleton
    @Provides
    SharedPreferences provideSharedPreferences() {
        return PreferenceManager.getDefaultSharedPreferences(myApplication);
    }
}
