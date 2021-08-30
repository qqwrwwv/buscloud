package com.salonbus.cloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/24 7:30 下午
 * @Version 1.0
 */
@Service
public class PaymentService {
    public String PaymentInfo_OK(Integer id) {
        return "线程池：" + Thread.currentThread().getName() + " PaymentInfo_OK,Id:" + "\t" + id + "O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String PaymentInfo_Timeout(Integer id) {

        int timeNumber = 3;

        try {
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " PaymentInfo_TimeOut,Id:" + "\t"
                + id + "O(∩_∩)O哈哈~" + " 耗时(s):"+timeNumber;
    }

    public String paymentInfo_TimeoutHandler(Integer id){
        return "线程池：" + Thread.currentThread().getName() + " PaymentInfo_TimeOut,Id:" + "\t"
                + id + "o(╥﹏╥)o";
    }
    /**
     *
     * @param id
     * @return
     * 服务熔断
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value="60"),//失败率达到多少熔断
    })
    public String paymentCircuitBreaker(@PathVariable("id")Integer id){
        if (id<0){
            throw new RuntimeException("*****id不能为负");
        }
        String serialNumber= IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"\t调用成功，流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id")Integer id){
        return "id不能为负，请调试 o(╥﹏╥)o";
    }

}
