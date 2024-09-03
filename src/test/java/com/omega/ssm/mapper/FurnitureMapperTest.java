package com.omega.ssm.mapper;

import com.omega.ssm.entity.Furniture;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class FurnitureMapperTest
 *
 * @author KennySo
 * @date 2024/9/3
 */
public class FurnitureMapperTest {


    private final ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");

    private final FurnitureMapper furnitureMapper = ioc.getBean(FurnitureMapper.class);

    @Test
    public void testInsertSelective() {
        Furniture furniture = new Furniture(null, "不会坏的凳子", "宜家家居", new BigDecimal("999.99"),
                100, 500, "assets/images/product-image/default.jpg", new Date(), new Date());
        int affected = furnitureMapper.insertSelective(furniture);
        System.out.println(affected > 0 ? "添加数据成功." : "添加数据失败.");
    }

    @Test
    public void testDeleteByPrimaryKey() {
        int affected = furnitureMapper.deleteByPrimaryKey(43);
        System.out.println(affected > 0 ? "删除数据成功." : "删除数据失败.");
    }

    @Test
    public void selectByPrimaryKey() {
        Furniture furniture = furnitureMapper.selectByPrimaryKey(1);
        System.out.println("furniture = " + furniture);
        System.out.println("操作成功~");
    }
}
