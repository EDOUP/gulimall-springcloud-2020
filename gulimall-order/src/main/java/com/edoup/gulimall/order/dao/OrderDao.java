package com.edoup.gulimall.order.dao;

import com.edoup.gulimall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-17 00:22:16
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}
