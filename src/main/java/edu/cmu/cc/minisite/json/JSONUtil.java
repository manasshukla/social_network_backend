package edu.cmu.cc.minisite.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
import edu.cmu.cc.minisite.pojo.Comment;
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


    public static JsonObject getCommentJson(List<Comment> commentList){
        JsonArray commentsArray = new JsonArray();
        for (Comment comment : commentList) {
            JsonObject jsonComment = new JsonObject();
            jsonComment.addProperty("cid",comment.getCid());
            jsonComment.addProperty("parent_id",comment.getParent_id());
            jsonComment.addProperty("uid",comment.getUid());
            jsonComment.addProperty("timestamp",comment.getTimestamp());
            jsonComment.addProperty("content",comment.getContent());
            jsonComment.addProperty("subreddit",comment.getSubreddit());
            jsonComment.addProperty("ups",comment.getUps());
            jsonComment.addProperty("downs",comment.getDowns());
            commentsArray.add(jsonComment);
            }
        System.out.println(commentsArray.toString()+"\n\n");

        JsonObject commentsObj = new JsonObject();
        commentsObj.add("comments",commentsArray);
        System.out.println("Final JSON : \n"+commentsObj.toString());

        return commentsObj;

    }
}
