package com.test.myapplication.di.components;

import com.test.myapplication.MainActivity;
import com.test.myapplication.di.modules.ContextModule;
import com.test.myapplication.di.modules.NetworkModule;
import com.test.myapplication.di.modules.ViewModelModule;

import javax.inject.Singleton;

import dagger.Component;

//stex tvarkum enq mer modulner@ , Singleton nshanakum a Global Singleton
@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class, ViewModelModule.class})
public interface AppComponent {

    //stex sax mer Activityneri hamar petqa dnenq inject funcian u mej@ dnenq ira Activityn asenq`
    // void inject(MainActivity2 mainActivity2)
    void inject(MainActivity mainActivity);

}
