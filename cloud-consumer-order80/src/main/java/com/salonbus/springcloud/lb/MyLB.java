package com.salonbus.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @Description 呆神出品，必属精品～
 * @Author 一条大菜狗
 * @Date 2021/8/22 12:04 下午
 * @Version 1.0
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current=this.atomicInteger.get();
            next = current >=Integer.MAX_VALUE?0:current+1;
        }while(!this.atomicInteger.compareAndSet(current,next));
        System.out.println("********next:"+next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}
