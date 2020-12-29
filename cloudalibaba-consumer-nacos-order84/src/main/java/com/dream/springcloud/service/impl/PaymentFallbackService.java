package com.dream.springcloud.service.impl;

import com.dream.springcloud.entities.CommonResult;
import com.dream.springcloud.entities.Payment;
import com.dream.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * Created by huzejun
 * on 2020/5/31 17:52
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444,"服务降级返回，--PaymentFallbackService",new Payment(id,"error"));
    }
}
