package com.itmuch.cloud.controller;

import com.itmuch.cloud.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import com.itmuch.cloud.entity.User;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Autowired
    private UserFeignClient userFeignClient;
    /*
    * 1.@GetMapping注解不支持，使用@RequestMapping
    * 2.@PathVariable需要设置value
    * */
    @RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable(value = "id") Integer id){
        return this.userFeignClient.findById(id);
    };

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public User testPost(User u){
        return this.userFeignClient.postUser(u);
    }

    @RequestMapping(value = "/test-get", method = RequestMethod.GET)
    public User testGet(User user){
        return this.userFeignClient.getUser(user);
    }

}
