package com.test.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.test.myapplication.databinding.ActivityMainBinding;
import com.test.myapplication.model.UserModel;
import com.test.myapplication.viewmodel.UserViewModel;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding activityMainBinding;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        ((BaseApplication) getApplication()).getAppComponent().inject(this);
        userViewModel = ViewModelProviders.of(this,viewModelFactory).get(UserViewModel.class);

        userViewModel.getModelMutableLiveData().observe(this, new Observer<UserModel>() {
            @Override
            public void onChanged(UserModel userModel) {
                activityMainBinding.setUser(userModel);
            }
        });
    }
}