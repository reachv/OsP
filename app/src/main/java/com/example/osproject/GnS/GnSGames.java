package com.example.osproject.GnS;

import com.parse.Parse;
import com.parse.ParseClassName;
import com.parse.ParseObject;
import com.parse.ParseUser;

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
    public Map<String, Integer> getnumAttempts(){
        return getMap("numAttempts");
    }
    public List<ParseUser> getPlayers(){
        return getList("players");
    }
    public Map<String, Integer> getScore(){
        return getMap("score");
    }
    public String getTitle(){
        return getString("title");
    }

    //Setters
    public void setCurr(String curr){
        put("currWord", curr);
    }
    public void setAttempted(Map<String, List<String>> x){
        put("playersAttempt", x);
    }
    public void setPlayers(List<ParseUser> x){
        put("players", x);
    }
    public void setnumAttempt(Map<String, Integer> x){
        put("numAttempts", x);
    }
    public void setScore(Map<String, Integer> x){
        put("score", x);
    }
    public void setTitle(String x){
        put("title", x);
    }
}
