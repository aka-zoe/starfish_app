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

    @GetMapping("/testGet")
    public String testGet() {
        return "testGet request success!";
    }

    @PostMapping("/testPost")
    public String testPost(@RequestBody String param) {
        System.out.println("testPost param=" + param);
        return param;
    }

    @GetMapping("/testGet/{id}/list")
    public String testGetList(@PathVariable("id") Long id, @RequestParam(value = "name", required = true) String name) {
        System.out.println("testGetList id=" + +id + ", name=" + name);
        return "testGetList request success! id=" + id + ", name=" + name;
    }

    @PostMapping("/testPost/jsonParam")
    public ResponseEntity postJsonParam(@RequestBody TestPostBean bean) {
        System.out.println("testGetList bean=" + bean.toString());
        return ResponseEntity.ok().build();
    }
}
