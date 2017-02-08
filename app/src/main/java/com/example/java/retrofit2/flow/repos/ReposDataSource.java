package com.example.java.retrofit2.flow.repos;

import com.example.java.retrofit2.base.BaseDataSource;
import com.example.java.retrofit2.model.Repo;

import java.util.List;

import rx.Single;

/**
 * Created by java on 08.02.2017.
 */

public interface ReposDataSource extends BaseDataSource{
    public Single<List<Repo>> getRepos(String user);
    public void clearRepos();
}
