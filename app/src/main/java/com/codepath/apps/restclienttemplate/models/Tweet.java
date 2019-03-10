package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class Tweet {

    public String body;
    public long id;
    public String timeStamp;
    public User profile;

    public static Tweet fromJSON(JSONObject jo) throws JSONException {
         Tweet tweet = new Tweet();

         tweet.body = jo.getString("text");
         tweet.id = jo.getLong("id");
         tweet.timeStamp = jo.getString("created_at");
         tweet.profile = User.fromJSON(jo.getJSONObject("user"));

         return tweet;
    }
}
