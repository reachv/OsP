package com.example.osproject.GnS;

import com.parse.ParseClassName;
import com.parse.ParseObject;

import java.util.List;
import java.util.Map;

@ParseClassName("Games")
public class GnSGames extends ParseObject {

    //Getters
    public String getCurr(){
        return getString("currWord");
    }
    public Map<String, List<String>> getAttempted(){
        return getMap("playersAttempt");
    }
    public List<String> getPlayers(){
        return getList("players");
    }

    //Setters
    public void setCurr(String curr){
        put("currWord", curr);
    }
    public void setAttempted(Map<String, List<String>> x){
        put("playersAttempt", x);
    }
    public void setPlayers(List<String> x){
        put("players", x);
    }
}
