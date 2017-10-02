package com.example.a31test.mainscreen;


import com.example.a31test.data.component.NetComponent;
import com.example.a31test.util.CustomScope;

import dagger.Component;

/**
 * Created by Aditya on 11-May-16.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
