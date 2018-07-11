package edu.cmu.cc.minisite.json;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
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
        List<JsonObject> jsonarray = new ArrayList<>();
        for (String i : followerMap.keySet()) {
            System.out.println("User name : "+i+" Profile photo : "+followerMap.get(i));
            JsonObject follower = new JsonObject();
            follower.addProperty("name", i);
            follower.addProperty("profile", followerMap.get(i));
            followers.add(follower);
        }
//        followers.add(jsonarray);
        JsonObject followerobj = new JsonObject();
        followerobj.add("followers",followers);

        return followerobj;
    }

    public static JsonObject convertListToJSONArray(List<String> inputList){
        JsonArray commentsArr = new JsonArray();
        String combinedStr = String.join(",", inputList);
        inputList.stream().forEach(str -> {
            JsonPrimitive element = new JsonPrimitive(str);
            System.out.println("Json primitive string : "+element.getAsString());
            commentsArr.add(element);
        });
        JsonObject commentsObj = new JsonObject();
        commentsObj.add("Comments", commentsArr);
        System.out.println(commentsObj.toString());

        return commentsObj;
    }
}
