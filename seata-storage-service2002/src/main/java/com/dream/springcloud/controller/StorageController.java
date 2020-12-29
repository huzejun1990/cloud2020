package com.dream.springcloud.controller;

import com.dream.springcloud.domain.CommonResult;
import com.dream.springcloud.service.StorageService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by huzejun
 * on 2020/6/2 13:17
 */
@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    /**
     * 扣减库存
     * @param productId
     * @param count
     * @return
     */
    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count){

        storageService.decrease(productId,count);
        return new CommonResult(200,"扣减库存成功！");
    }

}
