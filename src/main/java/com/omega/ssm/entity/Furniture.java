package com.omega.ssm.entity;

import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class Furniture {

    private Integer id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String manufacturer;

    @DecimalMin(value = "0")
    @NotNull
    private BigDecimal price;

    @Min(value = 0)
    @NotNull
    private Integer sales;

    @Min(value = 0)
    @NotNull
    private Integer stock;

    private String imgPath = "assets/images/product-image/default.jpg";

    private Date createTime = new Date();

    private Date updateTime = new Date();

    public Furniture() {
    }

    public Furniture(Integer id, String name, String manufacturer, BigDecimal price, Integer sales, Integer stock, String imgPath, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.sales = sales;
        this.stock = stock;
        this.createTime = createTime;
        this.updateTime = updateTime;
        // imgPath 不能为 null, "", "   "
        if (StringUtils.hasText(imgPath)) {
            this.imgPath = imgPath;
        }
        if (createTime != null) {
            this.createTime = createTime;
        }
        if (updateTime != null) {
            this.updateTime = updateTime;
        }
    }

    public void setImgPath(String imgPath) {
        if (StringUtils.hasText(imgPath)) {
            this.imgPath = imgPath;
        }
    }

    public void setCreateTime(Date createTime) {
        if (createTime != null) {
            this.createTime = createTime;
        }
    }

    public void setUpdateTime(Date updateTime) {
        if (updateTime != null) {
            this.updateTime = updateTime;
        }
    }
}