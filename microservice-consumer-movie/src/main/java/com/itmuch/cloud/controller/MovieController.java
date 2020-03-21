package com.itmuch.cloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.itmuch.cloud.entity.User;

import javax.annotation.Resource;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${user.userServicePath}")
    @Resource
    private String userServicePath;

    @GetMapping(value = "/movie/{id}")
    public User findById(@PathVariable Integer id){
        return restTemplate.getForObject(this.userServicePath + id, User.class);
    };

}
