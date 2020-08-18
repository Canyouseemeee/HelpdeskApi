package com.example.helpdesk;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonIssues {

    @GET("ApiIssues")
    Call<List<Issues>> getPosts();
}
