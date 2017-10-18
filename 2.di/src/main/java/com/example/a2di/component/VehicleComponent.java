package com.example.a2di.component;

import com.example.a2di.MainActivity;
import com.example.a2di.model.Vehicle;
import com.example.a2di.module.VehicleModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ADMIN on 9/29/2017.
 */

@Singleton
@Component(modules = {VehicleModule.class})
public interface VehicleComponent {

    Vehicle provideVehicle();

    void inject(MainActivity mainActivity);

}

