package com.example.a31test;

import android.app.Application;

import com.example.a31test.data.component.DaggerNetComponent;
import com.example.a31test.data.component.NetComponent;
import com.example.a31test.data.module.AppModule;
import com.example.a31test.data.module.NetModule;


/**
 * Created by Aditya on 11-May-16.
 */
public class App extends Application {
    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
