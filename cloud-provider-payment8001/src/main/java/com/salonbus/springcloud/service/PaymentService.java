package com.salonbus.springcloud.service;

import com.salonbus.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName PaymentService
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/14 上午9:58
 * @Version 1.0
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(@Param("id")Long id);
}
