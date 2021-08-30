package com.salonbus.springcloud.controller;

import com.salonbus.springcloud.entities.CommonResult;
import com.salonbus.springcloud.entities.Payment;
import com.salonbus.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentController
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/14 上午10:27
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("****插入结果****" + result);
        if (result > 0) {
            return new CommonResult(200, "插入成功,serverPort:"+serverPort, result);
        } else {
            return new CommonResult(444, "插入失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id")Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果****" + payment);
        if (payment != null) {
            return new CommonResult(200, "查询成功,serverPort:"+serverPort, payment);
        } else {
            return new CommonResult(444, "查询失败"+id, null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery(){
        List<String> services=discoveryClient.getServices();
        for (String element:services){
            log.info("*********element: "+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getInstanceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }

    @GetMapping(("/payment/feign/timeout"))
    public String paymentFeignTimeout(){
        try{
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
