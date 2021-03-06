package com.test.myapplication.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.test.myapplication.model.UserModel;
import com.test.myapplication.repository.UserRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {

    private UserRepository userRepository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<UserModel> modelMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<UserModel> getModelMutableLiveData() {
        loadData();
        return modelMutableLiveData;
    }

    //Inject enq anum vortex kdrvi Repoyi instance@
    @Inject
    public UserViewModel(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void loadData(){
        disposable.add(userRepository.modelSingle()
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeWith(new DisposableSingleObserver<UserModel>() {
            @Override
            public void onSuccess(UserModel value) {
                getModelMutableLiveData().setValue(value);
            }

            @Override
            public void onError(Throwable e) {

            }
        }));
    }
}
