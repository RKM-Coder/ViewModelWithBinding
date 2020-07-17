package com.goalsr.listenableworkerjavatemplate.workmanagerlistion;

import android.content.Context;
import android.icu.lang.UCharacter;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.work.WorkInfo;

import java.util.UUID;

public class Repository {

    private Context mContext;

    LiveData<WorkInfo> livedata=new MutableLiveData<>();

    public Repository() {

    }

    public LiveData<WorkInfo> getUserValue() {
        UUID uid= UUID.randomUUID();

        return livedata;
    }
}
