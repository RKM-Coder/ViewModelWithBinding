package com.goalsr.listenableworkerjavatemplate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;

import com.goalsr.listenableworkerjavatemplate.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

   ActivityMainBinding activityMainBinding;
   MainViewModel mainViewModel;
    MainViewModelFactory mainViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainViewModelFactory=new MainViewModelFactory();
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mainViewModel= ViewModelProviders.of(this,mainViewModelFactory).get(MainViewModel.class);

        activityMainBinding.setLifecycleOwner(this);
        activityMainBinding.setViewmodel(mainViewModel);



    }
}
