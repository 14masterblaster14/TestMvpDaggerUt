package com.example.a4di.di.component;

import com.example.a4di.MainActivity;
import com.example.a4di.di.annotation.PerActivity;
import com.example.a4di.di.module.ActivityModule;

import dagger.Component;

/**
 * Created by ADMIN on 10/1/2017.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
}
