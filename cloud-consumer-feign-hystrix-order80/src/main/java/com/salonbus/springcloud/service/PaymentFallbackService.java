package com.salonbus.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/26 2:18 下午
 * @Version 1.0
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String PaymentInfo_OK(Integer id) {
        return "PaymentFallbackService fall back-paymentInfo_Ok o(╥﹏╥)o";
    }

    @Override
    public String PaymentInfo_Timeout(Integer id) {
        return "PaymentFallbackService fall back-PaymentInfo_Timeout o(╥﹏╥)o";
    }
}
