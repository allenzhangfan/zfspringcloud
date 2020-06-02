package com.zf.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServer8763Application {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer8763Application.class, args);
    }

}
