package com.hello.consumer;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class SentinelDatasource {

    @PostConstruct
    public void initialize(){
        final String address="127.0.0.1:8848";
        // 引入groupId和dataId的概念，是为了方便和Nacos进行切换
        final String groupId = "Sentinel-Demo";
        final String flowDataId = "SYSTEM-CODE-DEMO-FLOW";
        // final String degradeDataId = "SYSTEM-CODE-DEMO-DEGRADE";
        // final String systemDataId = "SYSTEM-CODE-DEMO-SYSTEM";


        // 规则会持久化到zk的/groupId/flowDataId节点
        // groupId和和flowDataId可以用/开头也可以不用
        // 建议不用以/开头，目的是为了如果从Zookeeper切换到Nacos的话，只需要改数据源类名就可以
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(address, groupId, flowDataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());

    }
}
