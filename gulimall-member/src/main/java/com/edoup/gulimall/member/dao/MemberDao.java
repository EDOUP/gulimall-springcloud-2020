package com.edoup.gulimall.member.dao;

import com.edoup.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 23:50:14
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
