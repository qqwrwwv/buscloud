package com.salonbus.cloud.controller;

import com.salonbus.cloud.service.PaymentFeignService;
import com.salonbus.springcloud.entities.CommonResult;
import com.salonbus.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName OderFeignController
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/23 8:02 下午
 * @Version 1.0
 */
@RestController
@Slf4j
public class OderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
        return paymentFeignService.getPaymentById(id);
    }

    @GetMapping(("/consumer/payment/feign/timeout"))
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }
}
