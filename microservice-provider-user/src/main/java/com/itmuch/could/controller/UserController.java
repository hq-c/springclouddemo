package com.itmuch.could.controller;

import com.itmuch.could.entity.User;
import com.itmuch.could.jpa.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserJpa userJpa;

    @Autowired
    private DiscoveryClient discoveryClient;

    //@Autowired
    //private EurekaClient eurekaClient;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Integer id){
        return userJpa.getById(id);
    }

    /**
     * 保存user
     * @param user
     * @return
     */
    @PostMapping("/saveUser")
    public User saveUser(@RequestBody User user){
        User save = userJpa.save(user);
        return save;
    }
    @GetMapping("/abc/{username}")
    public User fingByNameAndAge(@PathVariable String username){
        return userJpa.findUserByParam(username);
    }




    @GetMapping("/eureka-instance")
    public String serviceUrl(){
        //InstanceInfo serverFromEureka = this.eurekaClient.getNextServerFromEureka("microservice-provider-user", false);
        //return serverFromEureka.getHomePageUrl();
        return "123";
    }

    @GetMapping("/instance-info")
    public ServiceInstance showInfo(){
        return this.discoveryClient.getLocalServiceInstance();
    }

    @PostMapping("/user")
    public User postUser(@RequestBody User user){
        return user;
    }

    //该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会已POST方法发送请求
    @GetMapping("/get-user")
    public User getUser(User user){
        return user;
    }
}
