package com.dream.springcloud.service;

import com.dream.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huzejun
 * on 2020/5/11 19:38
 */
public interface PaymentService {
//     public int create(Payment payment);
     int create(Payment payment);


     Payment getPaymentById(@Param("id") Long id);

//     public Payment getPaymentById(@Param("id") Long id);
}