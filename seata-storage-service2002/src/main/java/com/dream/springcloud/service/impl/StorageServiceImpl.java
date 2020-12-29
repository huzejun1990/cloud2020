package com.dream.springcloud.service.impl;

import com.dream.springcloud.dao.StorageDao;
import com.dream.springcloud.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by huzejun
 * on 2020/6/2 13:12
 */
@Service
public class StorageServiceImpl implements StorageService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageServiceImpl.class);

    @Resource
    private StorageDao storageDao;

    @Override
    public void decrease(Long productId, Integer count) {
        LOGGER.info("-------->storage-service中扣减库存开始");
        storageDao.decrease(productId,count);
        LOGGER.info("-------->storage-service中扣减库存结束");

    }
}
