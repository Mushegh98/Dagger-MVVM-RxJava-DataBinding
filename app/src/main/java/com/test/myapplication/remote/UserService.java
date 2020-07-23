package com.test.myapplication.remote;

import com.test.myapplication.model.UserModel;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserService {

    @GET("/users/2")
    Single<UserModel> getUserModel();
}
