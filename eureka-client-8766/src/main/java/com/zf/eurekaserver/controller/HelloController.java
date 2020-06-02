package com.zf.eurekaserver.controller;


//import com.alibaba.fastjson.JSONObject;
import com.zf.eurekaserver.service.HelloService;
import com.zf.eurekaserver.service.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
public class HelloController {

//    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private HelloService helloService;

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name) throws ExecutionException, InterruptedException{

        return helloService.hiService(name);
    }

    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name) {
        return userFeignClient.hi(name);
    }

//    @RequestMapping(value = "/log-instance")
//    public Object logInstance() {
//        ServiceInstance serviceInstance = this.loadBalancerClient.choose("SERVICE-HELLO");
//        LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(),
//                serviceInstance.getHost(),serviceInstance.getPort());
//
//        JSONObject object1 = new JSONObject();
//        object1.put("ServiceId",serviceInstance.getServiceId());
//        object1.put("Host",serviceInstance.getHost());
//        object1.put("Port",serviceInstance.getPort());
//        return object1.toJSONString();
//    }

}
