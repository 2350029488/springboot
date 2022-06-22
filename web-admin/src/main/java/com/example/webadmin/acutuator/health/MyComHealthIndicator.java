package com.example.webadmin.acutuator.health;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 79 定制Endpoint
 *
 * HealthIndicator健康指标        extends AbstractHealthIndicator
 */
@Component
public class MyComHealthIndicator extends AbstractHealthIndicator {
    /**
     * 编写真实的健康检查方法
     * @param builder
     * @throws Exception
     */
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Map<String,Object> map=new HashMap<>();
        /*
        * 主要是这个判断时自己的业务  这里是模拟业务
        * */
        if (1==1){
            builder.status(Status.UP);//返回健康信息
            map.put("count",1);
            map.put("ms",100);

        }else {
            builder.status(Status.OUT_OF_SERVICE);//不健康
            map.put("err","连接超时");
        }
    }
}
