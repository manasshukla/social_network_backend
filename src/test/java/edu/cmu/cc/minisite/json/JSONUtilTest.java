package edu.cmu.cc.minisite.json;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONUtilTest {

    @Test
    public void getEmptyFollowerList() {
        System.out.println(JSONUtil.getEmptyFollowerList().toString());
    }

    @Test
    public void getFollowerList() {
        System.out.println(JSONUtil.getFollowerJSON().toString());
    }
}