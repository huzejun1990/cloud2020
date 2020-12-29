package com.dream.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by huzejun
 * on 2020/6/2 12:38
 */
@Mapper
public interface StorageDao {

    /**
     * 减库存
     * @param productId
     * @param count
     * @return
     */
    int decrease(@Param("productId") Long productId,@Param("count") Integer count);
}
