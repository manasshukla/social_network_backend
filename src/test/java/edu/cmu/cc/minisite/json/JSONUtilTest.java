package edu.cmu.cc.minisite.json;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class JSONUtilTest {

    @Test
    public void getEmptyFollowerList() {
        System.out.println(JSONUtil.getEmptyFollowerList().toString());
    }

    @Test
    public void getFollowerList() {
        Map<String,String> testMap = new HashMap<>();
        testMap.put("testUser","testProfile");
        testMap.put("testUser2","testProfile2");
        System.out.println(JSONUtil.getFollowerJSON(testMap).toString());
    }
}