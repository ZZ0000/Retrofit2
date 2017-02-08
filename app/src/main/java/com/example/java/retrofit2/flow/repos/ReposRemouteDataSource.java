package com.example.java.retrofit2.flow.repos;

import com.example.java.retrofit2.base.BaseRemouteDataSource;
import com.example.java.retrofit2.model.Repo;

import java.util.List;

import rx.Single;

/**
 * Created by java on 08.02.2017.
 */

public class ReposRemouteDataSource extends BaseRemouteDataSource implements ReposDataSource{
    @Override
    public Single<List<Repo>> getRepos(String user) {
        return repoService.getRepos(user);
    }

    @Override
    public void clearRepos() {

    }
}
