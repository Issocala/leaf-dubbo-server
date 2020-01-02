package com.example.snowflake;

import com.example.SnowflakeIDGen;
import com.example.common.PropertyFactory;
import com.example.common.Result;
import org.junit.Test;

import java.util.Properties;

public class SnowflakeIDGenImplTest {
    @Test
    public void testGetId() {
        Properties properties = PropertyFactory.getProperties();

        SnowflakeIDGen idGen = new SnowflakeIDGenImpl(properties.getProperty("leaf.zk.list"), 8080);
        for (int i = 1; i < 1000; ++i) {
            Result r = idGen.get();
            System.out.println(r);
        }
    }
}
