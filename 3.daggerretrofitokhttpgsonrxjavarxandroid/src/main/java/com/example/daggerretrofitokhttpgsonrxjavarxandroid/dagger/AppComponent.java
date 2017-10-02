package com.example.daggerretrofitokhttpgsonrxjavarxandroid.dagger;

import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.food.FoodActivity;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.food.FoodPresenterImpl;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.foodz.FoodzActivity;
import com.example.daggerretrofitokhttpgsonrxjavarxandroid.ui.foodz.FoodzPresenterImpl;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by ADMIN on 10/2/2017.
 */


@Singleton
@Component(modules = {AppModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(FoodzActivity target);

    void inject(FoodActivity target);

    void inject(FoodzPresenterImpl target);

    void inject(FoodPresenterImpl target);
}
