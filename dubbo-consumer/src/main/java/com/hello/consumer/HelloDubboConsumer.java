package com.hello.consumer;

import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDubbo
public class HelloDubboConsumer {

    public static void main(String[] args) {
        SpringApplication.run(HelloDubboConsumer.class,args);
    }
}
