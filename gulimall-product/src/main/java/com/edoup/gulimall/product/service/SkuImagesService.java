package com.edoup.gulimall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.product.entity.SkuImagesEntity;

import java.util.Map;

/**
 * sku图片
 *
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 17:05:12
 */
public interface SkuImagesService extends IService<SkuImagesEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

