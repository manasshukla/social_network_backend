package edu.cmu.cc.minisite.hbase;

import com.google.cloud.bigtable.hbase.BigtableConfiguration;
import com.google.cloud.bigtable.hbase.BigtableOptionsFactory;
import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.util.Bytes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;

public class BigtableHelper {
    private static final String PROJECT_ID = "cmu-project5";
    private static final String INSTANCE_ID = "bigtable-instance";

    private static TableName tableName = TableName.valueOf("followers");
    /**
     * HTable handler.
     */
    private static Table bizTable;

    private static Connection connection = null;

    public static void connect() throws IOException {
        Configuration config = BigtableConfiguration.configure(PROJECT_ID, INSTANCE_ID);
        // Include the following line if you are using app profiles.
        // If you do not include the following line, the connection uses the
        // default app profile.
//        config.set(BigtableOptionsFactory.APP_PROFILE_ID_KEY, APP_PROFILE_ID);

        connection = BigtableConfiguration.connect(config);
        System.out.println("Established connection"+connection);
        bizTable = connection.getTable(tableName);

    }

    public static List<String> getFollowers(String name) throws IOException {
        List<String> followers = new ArrayList<>();
        Get get = new Get(Bytes.toBytes(name));
        Result  result = bizTable.get(get);
        NavigableMap<byte[], byte[]> familyMap = result.getFamilyMap( Bytes.toBytes("data"));
        if(null == familyMap || familyMap.isEmpty()){
            return followers;
        }
        for (Map.Entry<byte[], byte[]> entry : familyMap.entrySet()) {
            followers.add(new String(entry.getKey()));
        }

        return followers;
    }
}