package com.example.service;

import com.example.GetIdServiceRPC;
import com.example.common.Result;
import com.example.common.Status;
import com.example.exception.InitException;
import com.example.exception.LeafServerException;
import com.example.exception.NoKeyException;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

public class GetIdServiceRPCImpl implements GetIdServiceRPC {
    @Autowired
    SegmentService segmentService;


    @Autowired
    SnowflakeService snowflakeService;



    public GetIdServiceRPCImpl() throws InitException, SQLException {
    }

    public String get(String key){
        return get(key,segmentService.getId(key));
    }

    public String get(){
        return get(snowflakeService.getId());
    }

    private String get(String key, Result id){
        Result result;
        if(key == null || key.isEmpty()){
            throw new NoKeyException();
        }
        result = id;
        if(result.getStatus().equals(Status.EXCEPTION)){
            throw new LeafServerException(result.toString());
        }
        return String.valueOf(result.getId());
    }
    private String get(Result id){
        Result result;
        result = id;
        if(result.getStatus().equals(Status.EXCEPTION)){
            throw new LeafServerException(result.toString());
        }
        return String.valueOf(result.getId());
    }

}
