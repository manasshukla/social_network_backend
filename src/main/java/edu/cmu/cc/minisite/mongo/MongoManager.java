package edu.cmu.cc.minisite.mongo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mongodb.*;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Sorts;
import org.bson.Document;
import org.bson.json.JsonMode;
import org.bson.json.JsonWriterSettings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;

public class MongoManager{




        private static final String DB_HOST = System.getenv("MONGO_HOST");
        private static final int DB_PORT = 27017;

        private static final String DB_NAME = "reddit_db";
        private static final String COLLECTION_NAME = "posts";
        private static  MongoClient client = null;


        public static MongoClient getMongoClient(){
            if(null == client){
                client = new MongoClient(DB_HOST,DB_PORT);
            }
            return client;
        }


        public static MongoDatabase getDatabase(String dbName){
                return getMongoClient().getDatabase(DB_NAME);
        }

        public static MongoCollection<Document> getCollection(String dbName ,String collectionName){
                return getDatabase(dbName).getCollection(collectionName);
        }


        public static List<String> getComments(String userName){
            List<String> commentsList = new ArrayList<>();

            Block<Document> printBlock = new Block<Document>() {
                @Override
                public void apply(Document document) {
                    JsonObject obj = new JsonObject();
                    commentsList.add(document.toJson());
                }
            };

            MongoCollection<Document> collection = getCollection(DB_NAME,COLLECTION_NAME);
            collection.find(eq("uid",userName)).sort(Sorts.descending("ups", "timestamp"))
                    .projection(fields(excludeId())).forEach(printBlock);

            System.out.println("*************************PRINTING FROM LIST ***************************");
            commentsList.stream().forEach(i-> System.out.println(i));
            return commentsList;
        }



}
