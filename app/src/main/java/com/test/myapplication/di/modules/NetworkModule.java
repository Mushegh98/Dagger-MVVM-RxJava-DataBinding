package com.test.myapplication.di.modules;

import com.test.myapplication.remote.UserService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class NetworkModule {

    //Methodner@ voric object petqa stexvi nshum enq Provides anotation-ov u veradardzvox arjeqi object a stexcvum
    @Provides
    @Singleton
    static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    static UserService provideUserService(Retrofit retrofit){
        return retrofit.create(UserService.class);
    }

}
