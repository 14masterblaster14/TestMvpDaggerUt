package com.example.a22di;

import android.app.Application;

import com.example.a22di.Dagger.component.DaggerStorageComponent;
import com.example.a22di.Dagger.component.StorageComponent;
import com.example.a22di.Dagger.module.StorageModule;

/**
 * Created by ADMIN on 10/1/2017.
 */

public class MyApplication extends Application {

    StorageComponent storageComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        storageComponent = DaggerStorageComponent.builder().storageModule(new StorageModule(this)).build();
    }

    public StorageComponent getStorageComponent() {
        return storageComponent;
    }
}
