package com.example.a2di;

import android.app.Application;
import android.widget.Toast;

import com.example.a2di.component.VehicleComponent;
import com.example.a2di.module.VehicleModule;

/**
 * Created by ADMIN on 10/18/2017.
 */

public class MyApplication extends Application {

    //Dager Code starts here...

    VehicleComponent vehicleComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        vehicleComponent = DaggerVehicleComponent.builder().vehicleModule(new VehicleModule()).build();

    }

    public VehicleComponent getVehicleComponent() {
        return vehicleComponent;
    }

}
