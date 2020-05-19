package com.edoup.gulimall.coupon.dao;

import com.edoup.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 22:04:30
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
