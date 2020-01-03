package com.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        com.alibaba.dubbo.container.Main.main(
                new String[]{"spring","log4j"});
    }
}
