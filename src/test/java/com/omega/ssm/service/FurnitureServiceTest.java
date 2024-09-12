package com.omega.ssm.service;

import com.github.pagehelper.PageInfo;
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

    // @Test
    // public void testPageFurniture() {
    //     List<Furniture> furnitureList = furnitureService.pageFurniture(1, 5);
    //     for (Furniture furniture : furnitureList) {
    //         System.out.println(furniture);
    //     }
    // }

    @Test
    public void testPageFurnitureByName() {
        PageInfo<Furniture> pageInfo = furnitureService.pageFurnitureByName(1, 5, "台灯");
        for (Furniture furniture : pageInfo.getList()) {
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
        // 如果不想 update 语句对某个字段进行修改, 那就将其手动设置为 null, 跳过对它的修改.
        Furniture furniture = new Furniture(59, "大台灯", "山西照明", new BigDecimal("18.66"),
                200, 500, null, null, new Date());
        boolean flag = furnitureService.updateById(furniture);
        System.out.println(flag ? "更新数据成功." : "更新数据失败.");
    }

    @Test
    public void testRemoveById() {
        boolean flag = furnitureService.removeById(59);
        System.out.println(flag ? "删除数据成功." : "删除数据失败.");
    }
}
