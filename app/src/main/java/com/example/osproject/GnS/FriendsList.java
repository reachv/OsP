package com.example.osproject.GnS;

import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

import java.util.List;

@ParseClassName("Friends")
public class FriendsList extends ParseObject {

    //Getters
    public String getCurr(){
        return ParseUser.getCurrentUser().getUsername();
    }
    public List<String> getFriends(){
        return getList("friendsList");
    }

    //Setters
    public void setCurr(String x){
        put("currUser", x);
    }
    public void setfriendsList(List<String> x){
        put("friendsList", x);
    }
}
