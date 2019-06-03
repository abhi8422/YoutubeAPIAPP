package com.example.youtubeapiapp.YouTubeApi;

import com.example.youtubeapiapp.YouTubeModel.MyPojo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class YoutubeAPI {
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public static  ApiInterface apiInterface=null;
    public static ApiInterface getApiInterface(){

        if(apiInterface== null){
            Retrofit retrofit=new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
            apiInterface=retrofit.create(ApiInterface.class);
        }
        return apiInterface;
    }
    public interface ApiInterface {
        //GET method name (" ")its end point.
        @GET("search")
        Call<MyPojo> getVideo(@Query("part") String part, @Query("channelId") String channelId, @Query("key") String key);
        /*@GET("getVideos.php")
        Call<MyPojo> getVideo();*/
    }
}
