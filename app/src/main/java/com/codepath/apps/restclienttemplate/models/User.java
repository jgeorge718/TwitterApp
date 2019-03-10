package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    public String name;
    public long id;
    public String userName;
    public String profilePicURL;

    public static User fromJSON(JSONObject jo) throws JSONException {
        User profile = new User();

        profile.name = jo.getString("name");
        profile.id = jo.getLong("id");
        profile.userName = jo.getString("screen_name");
        profile.profilePicURL = jo.getString("profile_image_url");

        return profile;
    }
}
