package com.example.youtubeapiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeapiapp.YouTubeAdapte.YoutubeAdapter;
import com.example.youtubeapiapp.YouTubeApi.YoutubeAPI;
import com.example.youtubeapiapp.YouTubeModel.Items;
import com.example.youtubeapiapp.YouTubeModel.MyPojo;
import com.google.android.youtube.player.YouTubeBaseActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends YouTubeBaseActivity {
    RecyclerView recyclerView;
    private String part="snippet";
    private String channelId="UCjV3DdcdKyVQWqhiL7IRuYw";
    private String key="AIzaSyAf_Aj6pATYQA6f57unSgR17r6YypkWIWw";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Call<MyPojo> call =YoutubeAPI.getApiInterface().getVideo(part,channelId,key);
        call.enqueue(new Callback<MyPojo>() {
            @Override
            public void onResponse(Call<MyPojo> call, Response<MyPojo> response) {
                MyPojo myPojo=response.body();
                Items[] items=myPojo.getItems();
                YoutubeAdapter adapter=new YoutubeAdapter(items,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<MyPojo> call, Throwable t) {

            }
        });
    }

}
