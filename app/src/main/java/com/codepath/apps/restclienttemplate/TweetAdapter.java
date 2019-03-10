package com.codepath.apps.restclienttemplate;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import java.util.List;

public class TweetAdapter extends RecyclerView.Adapter<TweetAdapter.ViewHolder> {

    public Context context;
    public List<Tweet> tweets;

    public TweetAdapter(Context context, List<Tweet> tweets) {
        this.context = context;
        this.tweets = tweets;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_tweet, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Tweet tweet = tweets.get(position);
        viewHolder.tvBody.setText(tweet.body);
        viewHolder.tvScreenName.setText(tweet.profile.userName);
        Glide.with(context).load(tweet.profile.profilePicURL).into(viewHolder.ivProfileImage);
    }

    @Override
    public int getItemCount() {
        return tweets.size();
    }

    public void clear() {
        tweets.clear();
        notifyDataSetChanged();
    }

    public void addTweets(List<Tweet> tweetList) {
         tweets.addAll(tweetList);
         notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivProfileImage;
        public TextView tvScreenName;
        public TextView tvBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivProfileImage = itemView.findViewById(R.id.ivProfileImage);
            tvScreenName = itemView.findViewById(R.id.tvScreenName);
            tvBody = itemView.findViewById(R.id.tvBody );
        }
    }
}

