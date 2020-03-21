package com.itmuch.cloud.controller;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.itmuch.cloud.entity.User;

import java.util.List;

@RestController
public class MovieController {
    public static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(MovieController.class);

    //使用restTemplate请求User服务
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/user/{id}")
    public User findById(@PathVariable Integer id){
        return restTemplate.getForObject("http://microservice-provider-user/simple/" + id, User.class);
        //return restTemplate.getForObject("http://localhost:7900/simple/" + id, User.class);
    }

    /***
     * 查询microservice-provider-user服务的信息并返回
     * @return microservice-provider-user服务的信息
     *
     * 使用DiscoveryClient.getInstances(serviceId),可查询指定微服务在Eureka上的实例列表
     */
    @GetMapping(value = "/user-instance", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    @GetMapping(value = "/user-instance", produces = MediaType.APPLICATION_XML_VALUE)
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("microservice-provider-user");
//        return this.discoveryClient.getInstances("MICROSERVIECE-CONSUMER-MOVIE");
    }


    /**=
     * 打印当前选择的是哪个节点
     */
    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
        MovieController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }

}
