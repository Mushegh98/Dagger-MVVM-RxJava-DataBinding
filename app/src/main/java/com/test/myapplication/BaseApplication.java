package com.test.myapplication;

import android.app.Application;

import com.test.myapplication.di.components.AppComponent;
import com.test.myapplication.di.components.DaggerAppComponent;


public class BaseApplication extends Application {

    //stex petqa mi angam build anenq normal ancni nor stexcvi DaggerAppComponent@
    private AppComponent appComponent;

    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.create();

    }
}
