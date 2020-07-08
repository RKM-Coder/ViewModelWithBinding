package com.goalsr.listenableworkerjavatemplate;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class Repository {

    private Context mContext;

    LiveData<String> livedata=new MutableLiveData<>();

    public Repository() {

    }

  /*  public LiveData<String> getUserValue() {
        return livedata.setValue();
    }*/
}
