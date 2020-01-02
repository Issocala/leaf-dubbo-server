package com.example.common;

import com.example.SnowflakeIDGen;

public class SnowflakeZeroIDGen implements SnowflakeIDGen {
    @Override
    public Result get() {
        return new Result(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return false;
    }
}
