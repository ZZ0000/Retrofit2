package com.example.java.retrofit2.flow.repos.Presenter;

import android.content.Context;

import com.example.java.retrofit2.flow.repos.ReposDataSource;
import com.example.java.retrofit2.flow.repos.ReposRepository;
import com.example.java.retrofit2.flow.repos.View.ReposView;
import com.example.java.retrofit2.model.Repo;

import java.util.List;

import rx.Single;
import rx.internal.util.SubscriptionList;

/**
 * Created by java on 13.02.2017.
 */

public class ReposPresenter implements ReposDataSource {
    ReposRepository reposRepository = new ReposRepository();
    ReposView reposView = null;
    SubscriptionList subscriptionList = new SubscriptionList();

   @Override
    public Single<List<Repo>> getRepos(String user) {
       Single<List<Repo>> single = reposRepository.getRepos(user);
       single.subscribe(list -> reposView.showRepos(list),
               throwable -> throwable.printStackTrace()); // Throwable::printStackTrace);
       return single;
   }

    @Override
    public void clearRepos() {
        reposRepository.clearRepos();
    }

    @Override
    public void init(Context context) {

    }

   public void onAttach(ReposView view){
        reposView = view;
        reposRepository.init(view.getContex());
    }

    public void onDetach(){
       subscriptionList.unsubscribe();
    }
}
