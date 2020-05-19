package com.edoup.gulimall.product;

import com.edoup.gulimall.product.entity.BrandEntity;
import com.edoup.gulimall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GuliMallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Test
    void contextLoads() {
        BrandEntity brandEntity = new BrandEntity();
        brandEntity.setName("华为1");
        System.out.println(brandService.save(brandEntity));
        System.out.println(brandService.remove(null));
        System.out.println(brandService.list());
    }

}
