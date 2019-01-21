package com.caicloud.controller;

import okhttp3.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @PACKAGE_NAME：com.hello.demohello.controller
 * @DATE: 2018/7/24
 * @AURH: shilei
 * @DESC:
 */
@RestController
public class HelloHealth {

    public static final MediaType type = MediaType.parse("application/x-www-form-urlencoded;charset=utf-8");
    public static final OkHttpClient httpClient = new OkHttpClient();

    @GetMapping("/www/{name}")
    public String health(@PathVariable("name") String name,
                         @HeaderParam("end-user") String user,
                         @HeaderParam("x-request-id") String xreq,
                         @HeaderParam("x-b3-traceid") String xtraceid,
                         @HeaderParam("x-b3-spanid") String xspanid,
                         @HeaderParam("x-b3-parentspanid") String xparentspanid,
                         @HeaderParam("x-b3-sampled") String xsampled,
                         @HeaderParam("x-b3-flags") String xflags,
                         @HeaderParam("x-ot-span-context") String xotspan) throws IOException {
        // 101110101
        name = "http://www.weather.com.cn/data/sk/"+name+".html";
        Request request = new Request.Builder()
                .url(name)
                .build();
        Response response = httpClient.newCall(request).execute();
        return response.body().string();// 返回的是string 类型
    }

    @GetMapping("/health/{name}")
    public String www(@PathVariable("name") String name,
                      @HeaderParam("end-user") String user,
                     @HeaderParam("x-request-id") String xreq,
                     @HeaderParam("x-b3-traceid") String xtraceid,
                     @HeaderParam("x-b3-spanid") String xspanid,
                     @HeaderParam("x-b3-parentspanid") String xparentspanid,
                     @HeaderParam("x-b3-sampled") String xsampled,
                     @HeaderParam("x-b3-flags") String xflags,
                     @HeaderParam("x-ot-span-context") String xotspan){

        return "provider参数: "+name;
    }
}
