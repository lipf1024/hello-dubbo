package com.hello.consumer.controller;

import com.hello.api.HelloService;

public class HelloFallBackMock implements HelloService {
    @Override
    public String hello() {
        return "fallback";
    }
}
