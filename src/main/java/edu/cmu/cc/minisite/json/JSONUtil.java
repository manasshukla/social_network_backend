package edu.cmu.cc.minisite.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.json.simple.JSONArray;

import java.util.Map;

public class JSONUtil {

    public static void convertToJSONArray(){

    }

    public static JsonObject getEmptyFollowerList(){
        JsonArray followers = new JsonArray();
        JsonObject follower = new JsonObject();
        follower.add("followers",followers);
        return  follower;
    }

    public static JsonObject getFollowerJSON(Map<String, String> followerMap){
        JsonArray followers = new JsonArray();
        JsonObject follower = new JsonObject();

        followerMap.keySet().parallelStream().forEach(i->{
            System.out.println("User name : "+i+" Profile photo : "+followerMap.get(i));
            follower.addProperty("name", i);
            follower.addProperty("profile", followerMap.get(i));
            followers.add(follower);

        });
        JsonObject followerobj = new JsonObject();
        followerobj.add("followers",followers);

        return followerobj;
    }
}
