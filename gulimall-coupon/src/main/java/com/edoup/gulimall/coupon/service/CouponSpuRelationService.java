package com.edoup.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.coupon.entity.CouponSpuRelationEntity;

import java.util.Map;

/**
 * 优惠券与产品关联
 *
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 22:21:52
 */
public interface CouponSpuRelationService extends IService<CouponSpuRelationEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

