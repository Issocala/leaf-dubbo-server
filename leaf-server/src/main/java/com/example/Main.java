package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-server.xml");
        context.start();
        System.in.read();
    }
}
