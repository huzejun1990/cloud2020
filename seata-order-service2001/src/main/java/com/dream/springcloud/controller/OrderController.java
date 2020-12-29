package com.dream.springcloud.controller;

import com.dream.springcloud.domain.CommonResult;
import com.dream.springcloud.domain.Order;
import com.dream.springcloud.service.IdGeneratorSnowflake;
import com.dream.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huzejun
 * on 2020/6/1 23:15
 */
@RestController
public class OrderController {

    @Resource
    private OrderService orderService;

    @Resource
    private IdGeneratorSnowflake idGeneratorSnowflake;



    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功！");
    }


    /**
     * 生成id,通过雪花算法
     * @return
     */
    @GetMapping("snowflake")
    public String getIDBySnowflake(){
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            threadPool.submit(() ->{
                System.out.println(idGeneratorSnowflake.snowflakeId());
            });
        }
        threadPool.shutdown();
        return "hello snowflake";
    }

}
