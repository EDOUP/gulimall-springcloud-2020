package com.edoup.gulimall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.common.utils.Query;
import com.edoup.gulimall.product.dao.CategoryDao;
import com.edoup.gulimall.product.entity.CategoryEntity;
import com.edoup.gulimall.product.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        List<CategoryEntity> categoryEntities = this.baseMapper.selectList(null);
        List<CategoryEntity> rootList = categoryEntities.stream()
                .filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(categoryEntity -> {
                    categoryEntity.setChildren(getChildCategory(categoryEntity, categoryEntities));
                    return categoryEntity;
                })
                .sorted(Comparator.comparing(CategoryEntity::getSort))
                .collect(Collectors.toList());
        return rootList;
    }

    public List<CategoryEntity> getChildCategory(CategoryEntity root, List<CategoryEntity> list) {
        List<CategoryEntity> childList = list.stream().filter(categoryEntity ->
                categoryEntity.getParentCid().equals(root.getCatId())
        ).map(categoryEntity -> {
            categoryEntity.setChildren(getChildCategory(categoryEntity, list));
            return categoryEntity;
        }).sorted(Comparator.comparing(CategoryEntity::getSort))
                .collect(Collectors.toList());
            return childList;
    }

    @Override
    public void removeMenusByIds(List<Long> asList) {
        //todo 检查菜单使用被使用
        this.baseMapper.deleteBatchIds(asList);
    }
}