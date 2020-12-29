package com.dream.springcloud.controller;

import com.dream.springcloud.entities.CommonResult;
import com.dream.springcloud.entities.Payment;
import com.dream.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created by huzejun
 * on 2020/5/11 19:44
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("****插入结果：" + result);

        if (result > 0){
            return new CommonResult(200,"插入数据成功！,serverPort:" + serverPort,result);
        }
        else {
            return new CommonResult(444,"插入失败！",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****插入结果：" + payment+"\t"+"哈哈！！！");


        if (payment != null){
            return new CommonResult(200,"查询成功！,serverPort:" + serverPort,payment);
        }
        else {
            return new CommonResult(444,"没有对应记录，查询Id: "+id,null);
        }
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
}
