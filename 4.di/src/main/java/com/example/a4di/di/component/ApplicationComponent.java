package com.example.a4di.di.component;

import android.app.Application;
import android.content.Context;

import com.example.a4di.DemoApplication;
import com.example.a4di.data.SharedPrefsHelper;
import com.example.a4di.data.DataManager;
import com.example.a4di.data.DbHelper;
import com.example.a4di.di.annotation.ApplicationContext;
import com.example.a4di.di.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ADMIN on 10/1/2017.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(DemoApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();
}
