package com.dream.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dream.springcloud.entities.CommonResult;

/**
 * Created by huzejun
 * on 2020/5/31 12:53
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception){

        return new CommonResult(444,"按客户自定义，global handlerException ---1");
    }

    public static CommonResult handlerException2(BlockException exception){

        return new CommonResult(444,"按客户自定义，global handlerException ---2");
    }
}
