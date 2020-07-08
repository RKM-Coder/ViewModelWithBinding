package com.goalsr.listenableworkerjavatemplate;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class    MainViewModel extends ViewModel {
    private Repository repository;

    public MutableLiveData<String> lastLocation=new MutableLiveData<>();
    public MutableLiveData<String> lastRequestTime=new MutableLiveData<>();
    public  MutableLiveData<String> btnevent=new MediatorLiveData<>();

    public LiveData<String> workinfo= Transformations.map(btnevent,input->
    {
        lastLocation.setValue("template");
        lastRequestTime.setValue(System.currentTimeMillis()+"");
        return  "wwwww";}
    );


   /* private Function<String, LiveData<String>> makeUpdateUi() {
        return Transformations.map();
    }*/


    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getLocationWorkInfoLiveData(){
       /* lastLocation.setValue("Texttttt");
        lastRequestTime.setValue("Textttcscassaftt");*/
        btnevent.setValue("");
    }


}
