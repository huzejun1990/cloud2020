package com.dream.springcloud.service.impl;

import com.dream.springcloud.dao.PaymentDao;
import com.dream.springcloud.entities.Payment;
import com.dream.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huzejun
 * on 2020/5/11 19:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

//    @Resource //(Resource与Autowired的区别：Resource是java自带的，Autowrited是Spring的)
    @Autowired
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
    /*@Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }*/
}
