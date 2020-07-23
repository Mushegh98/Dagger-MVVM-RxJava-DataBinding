package com.test.myapplication.repository;

import com.test.myapplication.model.UserModel;
import com.test.myapplication.remote.UserService;

import javax.inject.Inject;

import io.reactivex.Single;

public class UserRepository {
    private UserService userService;

    //vor object@ dnenq ira text@ Inject enq anum
    @Inject
    public UserRepository(UserService userService) {
        this.userService = userService;
    }

    public Single<UserModel> modelSingle(){
        return userService.getUserModel();
    }
}
