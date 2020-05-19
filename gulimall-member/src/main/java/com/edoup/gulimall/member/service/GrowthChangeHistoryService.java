package com.edoup.gulimall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.member.entity.GrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 成长值变化历史记录
 *
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 23:50:14
 */
public interface GrowthChangeHistoryService extends IService<GrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

