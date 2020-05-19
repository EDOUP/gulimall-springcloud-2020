package com.edoup.gulimall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.order.entity.OrderEntity;

import java.util.Map;

/**
 * 订单
 *
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-17 00:22:16
 */
public interface OrderService extends IService<OrderEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

