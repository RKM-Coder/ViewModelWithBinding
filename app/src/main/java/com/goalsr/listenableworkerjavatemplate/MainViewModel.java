package com.goalsr.listenableworkerjavatemplate;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.work.WorkInfo;

public class    MainViewModel extends ViewModel {
    private Repository repository;

    public MutableLiveData<String> lastLocation=new MutableLiveData<>();
    public MutableLiveData<String> lastRequestTime=new MutableLiveData<>();
    public  MutableLiveData<String> btnevent=new MediatorLiveData<>();

    private LiveData<String> makeUpdateUi;
    public LiveData<String> workinfo= Transformations.switchMap(btnevent,input->makeUpdateUi(input)
    );/*public LiveData<String> workinfo= Transformations.map(btnevent,input->
    {
        lastLocation.setValue("template");
        lastRequestTime.setValue(System.currentTimeMillis()+"");
        return  "wwwww";}
    );*/


    private LiveData<String> makeUpdateUi(String input) {
        lastRequestTime.setValue("");
        lastLocation.setValue("");
        Log.e("state",input);
        LiveData<String> makeMap= Transformations.map(repository.getUserValue(),info->{

            if (info.getState()==WorkInfo.State.RUNNING){
                return "RUNNING";
            }else   if (info.getState()==WorkInfo.State.SUCCEEDED){
                lastRequestTime.setValue(""+System.currentTimeMillis());
                lastLocation.setValue("Lat---"+System.currentTimeMillis());
                return "SUCCEEDED";
            }else   if (info.getState()==WorkInfo.State.ENQUEUED){
                return "ENQUEUED";
            }else{
                lastRequestTime.setValue(""+System.currentTimeMillis());
                lastLocation.setValue("Lat---"+System.currentTimeMillis());
                return "SUCCEEDED";
            }
        });
        /*if (input.str.equalsIgnoreCase(WorkInfo.State.RUNNING))*/

        return makeMap;
    }






    /*private Function<String, LiveData<String>> makeUpdateUi() {
        return Transformations.map(repository.getLocationWorkInfoLiveData(,WorkInfo->{
            return "";
        }
    };*/


    public MainViewModel(Repository repository) {
        this.repository = repository;
    }

    public void getLocationWorkInfoLiveData(){
       /* lastLocation.setValue("Texttttt");
        lastRequestTime.setValue("Textttcscassaftt");*/
        btnevent.setValue("");
    }


}
