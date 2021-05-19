package com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.post;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.goalsr.listenableworkerjavatemplate.R;
import com.goalsr.listenableworkerjavatemplate.dagger2.model.Post;
import com.goalsr.listenableworkerjavatemplate.dagger2.utils.VerticalSpacingItemDecoration;
import com.goalsr.listenableworkerjavatemplate.dagger2.viewmodel.ViewModelProviderFactory;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class PostFragment extends DaggerFragment {
    private static final String TAG = "PostFragment";
    private RecyclerView recyclerView;
    private PostViewModel postViewMode;

    MediatorLiveData<Resource<Post>> postsmediator=new MediatorLiveData<>();

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

    @Inject
    PostsRecyclerAdapter postsRecyclerAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_post,null);
        recyclerView=view.findViewById(R.id.recycler_view);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        postViewMode= ViewModelProviders.of(this,viewModelProviderFactory).get(PostViewModel.class);
        initRecyclerView();
        subscriberObserver();
    }

    public void subscriberObserver(){
        postViewMode.observerPost().removeObservers(getViewLifecycleOwner());
        postViewMode.observerPost().observe(getViewLifecycleOwner(), new Observer<Resource<List<Post>>>() {
            @Override
            public void onChanged(Resource<List<Post>> listResource) {
                if(listResource != null){
                    switch (listResource.status){

                        case LOADING:{
                            Log.d(TAG, "onChanged: LOADING...");
                            break;
                        }

                        case SUCCESS:{
                            Log.d(TAG, "onChanged: got posts...");
                            postsRecyclerAdapter.setPosts(listResource.data);
                            break;
                        }

                        case ERROR:{
                            Log.e(TAG, "onChanged: ERROR..." + listResource.message );
                            break;
                        }
                    }
                }
            }
        });
    }

    private void initRecyclerView(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        VerticalSpacingItemDecoration itemDecoration = new VerticalSpacingItemDecoration(15);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(postsRecyclerAdapter);
    }
}
