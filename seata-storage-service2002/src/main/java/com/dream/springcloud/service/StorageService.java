package com.dream.springcloud.service;

/**
 * Created by huzejun
 * on 2020/6/2 13:11
 */
public interface StorageService {

    /**
     * 扣减库存
     * @param productId
     * @param count
     */
    void decrease(Long productId, Integer count);
}
