package com.example.service;


import com.example.Constants;
import com.example.SnowflakeIDGen;
import com.example.common.PropertyFactory;
import com.example.common.Result;
import com.example.common.SnowflakeZeroIDGen;
import com.example.exception.InitException;
import com.example.snowflake.SnowflakeIDGenImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Properties;
public class SnowflakeService {
    private Logger logger = LoggerFactory.getLogger(SnowflakeService.class);

    private SnowflakeIDGen idGen;

    public SnowflakeService() throws InitException {
        Properties properties = PropertyFactory.getProperties();
        boolean flag = Boolean.parseBoolean(properties.getProperty(Constants.LEAF_SNOWFLAKE_ENABLE, "true"));
        if (flag) {
            String zkAddress = properties.getProperty(Constants.LEAF_SNOWFLAKE_ZK_ADDRESS);
            int port = Integer.parseInt(properties.getProperty(Constants.LEAF_SNOWFLAKE_PORT));
            idGen = new SnowflakeIDGenImpl(zkAddress, port);
            if(idGen.init()) {
                logger.info("Snowflake Service Init Successfully");
            } else {
                throw new InitException("Snowflake Service Init Fail");
            }
        } else {
            idGen = new SnowflakeZeroIDGen();
            logger.info("Zero ID Gen Service Init Successfully");
        }
    }

    public Result getId() {
        return idGen.get();
    }
}
