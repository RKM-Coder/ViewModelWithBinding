package com.goalsr.listenableworkerjavatemplate.dagger2.ui.main.post;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.LiveDataReactiveStreams;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

import com.goalsr.listenableworkerjavatemplate.dagger2.SessionManager;
import com.goalsr.listenableworkerjavatemplate.dagger2.model.Post;
import com.goalsr.listenableworkerjavatemplate.dagger2.network.main.MainApi;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    private static final String TAG = "PostViewModel";


    private final SessionManager sessionManager;
    private final MainApi mainApi;
    private MediatorLiveData<Resource<List<Post>>> post;

    @Inject
    public PostViewModel(SessionManager sessionManager,MainApi mainApi) {
        this.mainApi=mainApi;
        this.sessionManager=sessionManager;
        Log.d(TAG, "PostViewModel: working");
    }

    public LiveData<Resource<List<Post>>> observerPost() {
        if (post == null) {
            post = new MediatorLiveData<>();
            post.setValue(Resource.loading((List<Post>) null));
            int id = sessionManager.getUser().getValue().data.getId();
            final LiveData<Resource<List<Post>>> source = LiveDataReactiveStreams.fromPublisher(

                    mainApi.getPostById(sessionManager.getUser().getValue().data.getId())

                            .onErrorReturn(new Function<Throwable, List<Post>>() {
                                @Override
                                public List<Post> apply(Throwable throwable) throws Exception {
                                    Log.e(TAG, "apply: ", throwable);
                                    Post post = new Post();
                                    post.setId(-1);
                                    ArrayList<Post> posts = new ArrayList<>();
                                    posts.add(post);
                                    return posts;
                                }
                            })

                            .map(new Function<List<Post>, Resource<List<Post>>>() {
                                @Override
                                public Resource<List<Post>> apply(List<Post> posts) throws Exception {

                                    if (posts.size() > 0) {
                                        if (posts.get(0).getId() == -1) {
                                            return Resource.error("Something went wrong", null);
                                        }
                                    }

                                    return Resource.success(posts);
                                }
                            })

                            .subscribeOn(Schedulers.io())
            );

            post.addSource(source, new Observer<Resource<List<Post>>>() {
                @Override
                public void onChanged(Resource<List<Post>> listResource) {
                    post.setValue(listResource);
                    post.removeSource(source);
                }
            });
        }
        return post;
    }

}
