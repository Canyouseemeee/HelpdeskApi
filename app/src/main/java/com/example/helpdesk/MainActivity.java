package com.example.helpdesk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.57.34.148:8000/api/")
//                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);
        JsonIssues jsonIssues = retrofit.create(JsonIssues.class);


        Call<List<Issues>> call = jsonIssues.getPosts();
//        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();


        call.enqueue(new Callback<List<Issues>>() {
            @Override
            public void onResponse(Call<List<Issues>> call, Response<List<Issues>> response) {
                if (!response.isSuccessful()){
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Issues> ApiIssues = response.body();

                for (Issues issues : ApiIssues){
                    String content = "";
                    content += "Issuesid: " +issues.getIssuesid() + "\n";
                    content += "Trackerid: " +issues.getTrackerid() + "\n";
                    content += "Priorityid: " +issues.getPriorityid() + "\n";
                    content += "Statusid: " +issues.getStatusid() + "\n";
                    content += "Departmentid: " +issues.getDepartmentid() + "\n";
                    content += "Users: " +issues.getUsers() + "\n";
                    content += "Subject: " +issues.getSubject() + "\n";
                    content += "Description: " +issues.getDescription() + "\n";
                    content += "Date_In: " +issues.getDate_In() + "\n";
                    content += "Image: " +issues.getImage() + "\n";
                    content += "created_at: " +issues.getCreated_at() + "\n";
                    content += "updated_at: " +issues.getUpdated_at() + "\n";

                    textViewResult.append(content);


                }
            }

            @Override
            public void onFailure(Call<List<Issues>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
//        call.enqueue(new Callback<List<Post>>() {
//            @Override
//            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
//                if (!response.isSuccessful()){
//                    textViewResult.setText("Code: " + response.code());
//                    return;
//                }
//
//                List<Post> posts = response.body();
//
//                for (Post post : posts) {
//                    String content = "";
//                    content += "ID: " + post.getId() + "\n";
//                    content += "UserID: " + post.getUserId() + "\n";
//                    content += "Title: " + post.getTitle() + "\n";
//                    content += "Text: " + post.getText() + "\n\n";
//
//                    textViewResult.append(content);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Post>> call, Throwable t) {
//                textViewResult.setText(t.getMessage());
//            }
//        });
    }
}