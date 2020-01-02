package com.example;

import com.example.common.Result;

public interface SnowflakeIDGen {
    Result get();
    boolean init();
}
