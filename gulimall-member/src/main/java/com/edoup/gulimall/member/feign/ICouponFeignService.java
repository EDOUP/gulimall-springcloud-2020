package com.edoup.gulimall.member.feign;

import com.edoup.gulimall.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *      远程调用Coupon服务接口
 *      @FeignClient”服务名“)
 *
 * </p>
 *
 * @author edoup
 * @date 2020/5/19 23:09
 */
@FeignClient("gulimail-coupon")
public interface ICouponFeignService {

    /**
     * 完整路径
     *
     * @return
     */
    @GetMapping("/coupon/coupon/getOne")
    R getOneCoupon();
}
