package com.hello.prvider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class HelloDubboProvider {

    public static void main(String[] args) {
        SpringApplication.run(HelloDubboProvider.class,args);
    }
}
