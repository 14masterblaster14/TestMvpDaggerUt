package com.example.a4di.di.module;

import android.app.Activity;
import android.content.Context;

import com.example.a4di.di.annotation.ActivityContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by ADMIN on 10/1/2017.
 */

@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }
}
