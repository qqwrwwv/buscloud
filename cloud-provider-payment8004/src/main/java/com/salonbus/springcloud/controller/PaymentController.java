package com.salonbus.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @ClassName PaymentController
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/18 8:49 上午
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/zk")
    public String paymentzk(){
        return "springCloud with zookeeper:"+serverPort+ "\t"+UUID.randomUUID().toString();
    }
}
