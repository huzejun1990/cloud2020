package com.dream.springcloud.service.impl;

import com.dream.springcloud.dao.OrderDao;
import com.dream.springcloud.domain.Order;
import com.dream.springcloud.service.AccountService;
import com.dream.springcloud.service.OrderService;
import com.dream.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huzejun
 * on 2020/6/1 22:16
 *
 * 创建订单->调用库存服务扣减库存->调用账户服务扣减余额->修改订单状态
 * 简单说：
 * 下订单->减库存->减余额->改状态
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    /**
     * 创建订单->调用库存服务扣减库存->调用账户服务扣减账户余额->修改订单状态
     * 简单说：下订单->扣库存->减余额->改状态
     */

    @Override
    @GlobalTransactional(name="fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        //1.新建订单
        log.info("---->开始新建订单");

        orderDao.create(order);

        log.info("---->订单微服务开始调用库存，做扣减Count");
        //2.扣减库存
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("---->订单微服务开始调用库存，做扣减end");

        log.info("---->订单微服务开始调用账户，做扣减Money");
        //3.扣减账户
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("---->订单微服务开始调用账户，做扣减end");

        //4.修改订单状态，从0到1，1代表已经完成
        log.info("---->修改订单状态开始");
        orderDao.update(order.getUserId(),0);
        log.info("---->修改订单状态结束");

        log.info("---->下订单结束了，O(∩_∩)O哈哈~");
    }
}
