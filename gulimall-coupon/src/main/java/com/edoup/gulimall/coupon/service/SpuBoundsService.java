package com.edoup.gulimall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.coupon.entity.SpuBoundsEntity;

import java.util.Map;

/**
 * 商品spu积分设置
 *
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 22:21:52
 */
public interface SpuBoundsService extends IService<SpuBoundsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

