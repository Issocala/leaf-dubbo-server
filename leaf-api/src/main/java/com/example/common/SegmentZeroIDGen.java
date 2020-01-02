package com.example.common;

import com.example.SegmentIDGen;

public class SegmentZeroIDGen implements SegmentIDGen {
    @Override
    public Result get(String key) {
        return new Result(0, Status.SUCCESS);
    }

    @Override
    public boolean init() {
        return true;
    }
}
