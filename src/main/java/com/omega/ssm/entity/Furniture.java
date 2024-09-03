package com.omega.ssm.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Furniture {

    private Integer id;

    private String name;

    private String manufacturer;

    private BigDecimal price;

    private Integer sales;

    private Integer stock;

    private String imgPath;

    private Date createTime;

    private Date updateTime;

}