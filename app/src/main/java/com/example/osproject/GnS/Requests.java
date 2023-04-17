package com.example.osproject.GnS;

import com.parse.ParseClassName;
import com.parse.ParseObject;

@ParseClassName("FriendsRequest")
public class Requests extends ParseObject {
    //Getters
    public String getRequester(){
        return getString("requester");
    }
    public String getRequested(){
        return getString("requested");
    }
    //Setters
    public void setRequester(String x){
        put("requester", x);
    }
    public void setRequested(String x){
        put("requested", x);
    }
}
