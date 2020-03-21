package com.itmuch.cloud;

import com.itmuch.cloud.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.web.bind.annotation.*;

//configuration = FeignClientsConfiguration.class为指定的feign配置类
@FeignClient(name = "microservice-provider-user", configuration = FeignClientsConfiguration.class)
public interface UserFeignClient {

    //@GetMapping("/simple/{id}")
    @RequestMapping(value = "/simple/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable(name = "id") Integer id);


    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    @RequestMapping(value = "/get-user", method = RequestMethod.GET)
    public User getUser(@RequestBody User user);

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public User saveUser(@RequestBody User user);

}
