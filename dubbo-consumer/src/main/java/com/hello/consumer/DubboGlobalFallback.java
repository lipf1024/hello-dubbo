package com.hello.consumer;

import com.alibaba.csp.sentinel.adapter.dubbo.config.DubboAdapterGlobalConfig;
import com.alibaba.csp.sentinel.adapter.dubbo.fallback.DubboFallback;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.dubbo.rpc.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DubboGlobalFallback implements DubboFallback {

    @PostConstruct
    public  void registerGlobalFallback(){
        DubboAdapterGlobalConfig.setConsumerFallback(this);
    }

    @Override
    public Result handle(Invoker<?> invoker, Invocation invocation, BlockException ex) {
        // sentinel抛出的异常为BlockException
        // dubbo mock只有在异常为RPCException类型时才会生效
        return AsyncRpcResult.newDefaultAsyncResult(new RpcException(ex), invocation);
    }
}
