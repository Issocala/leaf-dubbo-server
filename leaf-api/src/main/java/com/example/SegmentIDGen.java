package com.example;

import com.example.common.Result;

public interface SegmentIDGen {
    Result get(String key);
    boolean init();
}
