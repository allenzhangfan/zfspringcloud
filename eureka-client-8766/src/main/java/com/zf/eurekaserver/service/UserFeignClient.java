package com.zf.eurekaserver.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-hello")
public interface UserFeignClient {

    @RequestMapping(value="/hi",method = RequestMethod.GET)
    String hi(@RequestParam String name);

}
