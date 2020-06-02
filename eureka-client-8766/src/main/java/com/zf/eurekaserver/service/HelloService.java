package com.zf.eurekaserver.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutionException;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    //请求熔断注解，当服务出现问题时候会执行fallbackMetho属性的名为helloFallBack的方法
    @HystrixCommand(fallbackMethod = "helloFallBack")
    public String hiService(String name) throws ExecutionException, InterruptedException{
        return restTemplate.getForObject("http://SERVICE-HELLO/hi?name=" + name, String.class);
    }

    public String helloFallBack(String name){

        return name + " error";
    }


}