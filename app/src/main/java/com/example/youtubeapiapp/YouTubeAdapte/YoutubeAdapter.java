package com.example.youtubeapiapp.YouTubeAdapte;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.youtubeapiapp.Config;
import com.example.youtubeapiapp.R;
import com.example.youtubeapiapp.YouTubeActivity;
import com.example.youtubeapiapp.YouTubeModel.High;
import com.example.youtubeapiapp.YouTubeModel.Id;
import com.example.youtubeapiapp.YouTubeModel.Items;
import com.example.youtubeapiapp.YouTubeModel.Snippet;
import com.example.youtubeapiapp.YouTubeModel.Thumbnails;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

public class YoutubeAdapter extends RecyclerView.Adapter<YoutubeAdapter.YouTubeViewHolder> implements View.OnClickListener {
Items[] items;
Context context;

    public YoutubeAdapter(Items[] items, Context context) {
        this.items = items;
        this.context = context;
    }
    @NonNull
    @Override
    public YouTubeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_youtube,parent,false);
        view.setOnClickListener(this);
        return new YouTubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YouTubeViewHolder holder, final int position) {
        final Items item=items[position];
        final Id id=item.getId();
        Snippet snippet=item.getSnippet();
        Thumbnails thumbnails=snippet.getThumbnails();
        High high=thumbnails.getHigh();
        final String url=high.getUrl();
        //Toast.makeText(context,url,Toast.LENGTH_LONG).show();
       holder.youTubeView.initialize(Config.YOUTUBE_API_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {
            youTubeThumbnailView.setImageResource(R.drawable.ic_launcher_background);
            youTubeThumbnailLoader.setVideo(id.getVideoId());
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
            }
        });
       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               //String no=String.valueOf(position);
               String no=id.getVideoId();

               Toast.makeText(context,no,Toast.LENGTH_LONG).show();
                Intent intent=new Intent(context,YouTubeActivity.class);
                intent.putExtra("videoID",id.getVideoId());
                context.startActivity(intent);
           }
       });

    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    @Override
    public void onClick(View v) {

    }

    public class YouTubeViewHolder extends RecyclerView.ViewHolder {
        YouTubeThumbnailView youTubeView;
        LinearLayout linearLayout;
        public YouTubeViewHolder(final View itemView) {
            super(itemView);
            youTubeView=itemView.findViewById(R.id.youtube_view);
            linearLayout=itemView.findViewById(R.id.linear);
            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=getAdapterPosition();
                    String no=String.valueOf(position);
                    Toast.makeText(context,no,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(, YouTubeActivity.class);
                }
            });*/


        }

    }
}
