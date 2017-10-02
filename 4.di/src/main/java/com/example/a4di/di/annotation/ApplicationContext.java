package com.example.a4di.di.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by ADMIN on 10/1/2017.
 */


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
