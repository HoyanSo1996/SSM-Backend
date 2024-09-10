package com.omega.ssm.service;

import com.omega.ssm.entity.Furniture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Class FurnitureServiceTest
 *
 * @author KennySo
 * @date 2024/9/8
 */
public class FurnitureServiceTest {

    private ApplicationContext applicationContext;
    private FurnitureService furnitureService;


    @BeforeEach
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        furnitureService = applicationContext.getBean(FurnitureService.class);
    }

    @Test
    public void testAdd() {
        Furniture furniture = new Furniture(null, "不会坏的桌子", "宜家家居", new BigDecimal("16.66"),
                200, 500, "assets/images/product-image/default.jpg", new Date(), new Date());
        boolean flag = furnitureService.add(furniture);
        System.out.println(flag ? "添加数据成功." : "添加数据失败.");
    }

    @Test
    public void testGetFurnitureList() {
        List<Furniture> furnitureList = furnitureService.getFurnitureList();
        for (Furniture furniture : furnitureList) {
            System.out.println(furniture);
        }
    }

    @Test
    public void testGetFurnitureById() {
        Furniture furniture = furnitureService.getFurnitureById(1);
        System.out.println(furniture);
    }

    @Test
    public void testUpdateById() {
        Furniture furniture = new Furniture(59, "大台灯", "山西照明", new BigDecimal("18.66"),
                200, 500, "assets/images/product-image/default.jpg", new Date(), new Date());
        boolean flag = furnitureService.updateById(furniture);
        System.out.println(flag ? "更新数据成功." : "更新数据失败.");
    }

}
