package com.example.a4di;

import android.app.Application;
import android.content.Context;

import com.example.a4di.data.DataManager;
import com.example.a4di.di.component.ApplicationComponent;
import com.example.a4di.di.component.DaggerApplicationComponent;
import com.example.a4di.di.module.ApplicationModule;

import javax.inject.Inject;

/**
 * Created by ADMIN on 10/1/2017.
 */

public class DemoApplication extends Application {

    protected ApplicationComponent applicationComponent;

    @Inject
    DataManager dataManager;

    public static DemoApplication get(Context context) {
        return (DemoApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
