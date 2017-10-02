package com.example.a22di.Dagger.component;

import com.example.a22di.AFragment;
import com.example.a22di.BFragment;
import com.example.a22di.Dagger.module.StorageModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ADMIN on 10/1/2017.
 */


@Singleton
@Component(modules = StorageModule.class)
public interface StorageComponent {
    void inject(AFragment aFragment);

    void inject(BFragment bFragment);
}
