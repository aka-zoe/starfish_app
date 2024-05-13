package com.zoe.starfish_server.controller;

import com.zoe.starfish_server.bean.TestPostBean;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
//校验请求参数
@Validated
public class TestController {

    @RequestMapping(value = "/testMethod",method = RequestMethod.GET)
    public String testMethod() {
        return "testMethod request success!";
    }

    //GET请求示例
    @GetMapping("/testGet")
    public String testGet() {
        return "testGet request success!";
    }

    //POST请求示例
    @PostMapping("/testPost")
    public String testPost(@RequestBody String param) {
        System.out.println("testPost param=" + param);
        return param;
    }

    //GET请求url中携带参数以及携带拼接参数示例
    @GetMapping("/testGet/{id}/list")
    public String testGetList(@PathVariable("id") Long id, @RequestParam(value = "name", required = true) String name) {
        System.out.println("testGetList id=" + +id + ", name=" + name);
        return "testGetList request success! id=" + id + ", name=" + name;
    }

    //POST请求json参数示例
    @PostMapping("/testPost/jsonParam")
    public ResponseEntity postJsonParam(@RequestBody TestPostBean bean) {
        System.out.println("testGetList bean=" + bean.toString());
        return ResponseEntity.ok().build();
    }
}
