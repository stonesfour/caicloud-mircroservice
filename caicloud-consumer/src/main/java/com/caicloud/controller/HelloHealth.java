package com.caicloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @PACKAGE_NAME：com.hello.demohello.controller
 * @DATE: 2018/7/24
 * @AURH: shilei
 * @DESC:
 */
@RestController
public class HelloHealth {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/health/{name}")
    public String health(@PathVariable("name") String name){

        return "consumer-: "+name;
    }

    @GetMapping("/k8s/{id}")
    public String findById(@PathVariable String id,
                         @HeaderParam("end-user") String user,
                         @HeaderParam("x-request-id") String xreq,
                         @HeaderParam("x-b3-traceid") String xtraceid,
                         @HeaderParam("x-b3-spanid") String xspanid,
                         @HeaderParam("x-b3-parentspanid") String xparentspanid,
                         @HeaderParam("x-b3-sampled") String xsampled,
                         @HeaderParam("x-b3-flags") String xflags,
                         @HeaderParam("x-ot-span-context") String xotspan){
        return this.restTemplate.getForObject("http://caicloud-provider:8080/health/服务提供者-" + id, String.class);
    }

    @GetMapping("/local/{url}/{name}")
    public String findBybId(@PathVariable String url,  @PathVariable String port, @PathVariable String name,
                         @HeaderParam("end-user") String user,
                         @HeaderParam("x-request-id") String xreq,
                         @HeaderParam("x-b3-traceid") String xtraceid,
                         @HeaderParam("x-b3-spanid") String xspanid,
                         @HeaderParam("x-b3-parentspanid") String xparentspanid,
                         @HeaderParam("x-b3-sampled") String xsampled,
                         @HeaderParam("x-b3-flags") String xflags,
                         @HeaderParam("x-ot-span-context") String xotspan){
        return this.restTemplate.getForObject("http://"+url+":"+port +"/health/服务提供者-" + name, String.class);
    }
}
