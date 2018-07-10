package edu.cmu.cc.minisite.hbase;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class BigtableHelperTest {

    @Test
    public void connect() {
    }

    @Test
    public void getFollowers() throws IOException {
        BigtableHelper.connect();
        System.out.println(String.join(",",BigtableHelper.getFollowers("xxorlak")));
    }
}