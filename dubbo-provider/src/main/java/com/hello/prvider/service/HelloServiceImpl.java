package com.hello.prvider.service;

import com.hello.api.HelloService;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcException;
import org.springframework.beans.factory.annotation.Value;

@DubboService
public class HelloServiceImpl implements HelloService {
    @Value("${server.port}")
    private String port;

    @Override
    public String hello() {

        //throw  new RpcException("test");
        return "hello world, port:"+port;
    }
}
