package com.example.webadmin.acutuator.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Map;

/**
 * 自定义端点  类似health info 端点
 *
 *
 */
@Component
@Endpoint(id = "service")
public class MyEndpoint {
    @ReadOperation//端点的读操作
    public Map getDockerInfo(){
        return Collections.singletonMap("DockerInfo","启动了");
    }

    @WriteOperation
    public void stopDocker(){
        System.out.println("socker stop........");
    }
}
