package com.edoup.gulimall.coupon.controller;

import com.edoup.gulimall.common.utils.PageUtils;
import com.edoup.gulimall.common.utils.R;
import com.edoup.gulimall.coupon.entity.CouponEntity;
import com.edoup.gulimall.coupon.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

//import org.apache.shiro.authz.annotation.RequiresPermissions;


/**
 * 优惠券信息
 *
 * @author edoup
 * @email edsinseven@163.com
 * @date 2020-05-16 22:04:30
 */
@RefreshScope
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    private CouponService couponService;

    @Value("${coupon.user.name}")
    private String name;

    @Value("${coupon.user.age}")
    private String age;

    @GetMapping("/test")
    public R test() {
        return R.ok().put("name", name).put("age", age);
    }

    @GetMapping("/getOne")
    public R getOneCoupon() {
        CouponEntity couponEntity = new CouponEntity();
        couponEntity.setId(0L);
        couponEntity.setCouponType(0);
        couponEntity.setCouponImg("");
        couponEntity.setCouponName("满减优惠");
        couponEntity.setNum(0);
        couponEntity.setAmount(new BigDecimal("0"));
        couponEntity.setPerLimit(0);
        couponEntity.setMinPoint(new BigDecimal("0"));
        couponEntity.setStartTime(new Date());
        couponEntity.setEndTime(new Date());
        couponEntity.setUseType(0);
        couponEntity.setNote("");
        couponEntity.setPublishCount(0);
        couponEntity.setUseCount(0);
        couponEntity.setReceiveCount(0);
        couponEntity.setEnableStartTime(new Date());
        couponEntity.setEnableEndTime(new Date());
        couponEntity.setCode("");
        couponEntity.setMemberLevel(0);
        couponEntity.setPublish(0);

        return R.ok().put("coupons", Arrays.asList(couponEntity));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
//    @RequiresPermissions("coupon:coupon:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = couponService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
//   @RequiresPermissions("coupon:coupon:info")
    public R info(@PathVariable("id") Long id) {
        CouponEntity coupon = couponService.getById(id);

        return R.ok().put("coupon", coupon);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    //  @RequiresPermissions("coupon:coupon:save")
    public R save(@RequestBody CouponEntity coupon) {
        couponService.save(coupon);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    //@RequiresPermissions("coupon:coupon:update")
    public R update(@RequestBody CouponEntity coupon) {
        couponService.updateById(coupon);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    //@RequiresPermissions("coupon:coupon:delete")
    public R delete(@RequestBody Long[] ids) {
        couponService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
