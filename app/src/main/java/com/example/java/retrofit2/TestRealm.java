package com.example.java.retrofit2;


import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by java on 06.02.2017.
 */

public class TestRealm extends RealmObject {
    @Required

    private String title;

    public String getTitle() {

        return title;

    }

    public void setTitle(final String title) {

        this.title = title;

    }

}
