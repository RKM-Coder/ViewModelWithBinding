package com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.di.ViewModelFactoryModule;
import com.goalsr.listenableworkerjavatemplate.dagger2.model.UserResponse;
import com.goalsr.listenableworkerjavatemplate.dagger2.ui.auth.AuthResource;
import com.goalsr.listenableworkerjavatemplate.dagger2.viewmodel.ViewModelProviderFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class ProfileFragment extends DaggerFragment {
    public String TAG="profilefragment";

    private TextView txt1,txt2,txt3;

    private ProfileViewModel viewModel;

    @Inject
    ViewModelProviderFactory providerFactory;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_profile,null);
        txt1=view.findViewById(R.id.email);
        txt2=view.findViewById(R.id.username);
        txt3=view.findViewById(R.id.website);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel= ViewModelProviders.of(this,providerFactory).get(ProfileViewModel.class);
        subscribeObserver();

    }

    private void subscribeObserver(){
        viewModel.getAuthUserDetails().removeObservers(getViewLifecycleOwner());
        viewModel.getAuthUserDetails().observe(getViewLifecycleOwner(), new Observer<AuthResource<UserResponse>>() {
            @Override
            public void onChanged(AuthResource<UserResponse> userResponseAuthResource) {
                if (userResponseAuthResource!=null){
                    switch (userResponseAuthResource.status){
                        case AUTHENTICATED:{
                            setuserdetails(userResponseAuthResource.data);
                            break;
                        }
                        case ERROR:{
                            setEroorMsg(userResponseAuthResource.message);
                            break;
                        }

                    }
                }
            }
        });
    }

    private void setEroorMsg(String message) {
        txt1.setText(message);
        txt2.setText("error");
        txt3.setText("error");
    }

    private void setuserdetails(UserResponse data) {
        txt1.setText(data.getEmail());
        txt2.setText(data.getUsername());
        txt3.setText(data.getWebsite());

    }
}
