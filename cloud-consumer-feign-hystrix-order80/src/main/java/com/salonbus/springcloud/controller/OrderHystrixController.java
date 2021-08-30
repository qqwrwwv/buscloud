package com.salonbus.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.salonbus.springcloud.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName PaymentHystrixController
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/25 10:48 上午
 * @Version 1.0
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_global_fallback",commandProperties = {
//        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//})
public class OrderHystrixController {

    @Resource
    PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String PaymentInfo_OK(@PathVariable("id") Integer id) {
        return paymentHystrixService.PaymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallback",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
//    })
//    @HystrixCommand
    public String PaymentInfo_Timeout(@PathVariable("id") Integer id){
        return paymentHystrixService.PaymentInfo_Timeout(id);
    }

    public String paymentTimeoutFallback(Integer id){
        return "我是消费者80，对方支付系统繁忙请10s后再试或者出错请检查自己，o(╥﹏╥)o";
    }

    public String payment_global_fallback(){
        return "Global异常处理信息，请稍后再试";
    }
}
