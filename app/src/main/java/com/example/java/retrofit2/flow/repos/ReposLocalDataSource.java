package com.example.java.retrofit2.flow.repos;

import com.example.java.retrofit2.base.BaseLocalDataSource;
import com.example.java.retrofit2.model.Repo;

import java.util.List;

import io.realm.RealmResults;
import rx.Single;

/**
 * Created by java on 08.02.2017.
 */

public class ReposLocalDataSource extends BaseLocalDataSource implements ReposDataSource {
    @Override
    public Single<List<Repo>> getRepos(String user) {
        return Single.create(subscriber ->{
            realm.executeTransaction(innerRealm ->{
               RealmResults list = innerRealm.where(Repo.class).equalTo("name", user)
                       .findAll();
                if(list == null) {
                    subscriber.onError(new Exception("vse ploho"));
                } else {
                    List<Repo> repos = innerRealm.copyFromRealm(list);
                    if(repos != null) {
                        subscriber.onSuccess(repos);
                    } else {
                        subscriber.onError(new Exception("vse ploho2"));
                    }
                }
            });
        });
    }

    @Override
    public void clearRepos() {

    }

    public Single<List<Repo>> saveRepos(List<Repo> list){
        realm.executeTransaction(query -> {
            realm.copyToRealmOrUpdate(list);
        });

        return Single.just(list);

    }
}
