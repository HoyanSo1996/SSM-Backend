package com.omega.ssm.mapper;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.FurnitureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// @Repository  //这里不需要注解
public interface FurnitureMapper {
    long countByExample(FurnitureExample example);

    int deleteByExample(FurnitureExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Furniture record);

    int insertSelective(Furniture record);

    List<Furniture> selectByExample(FurnitureExample example);

    Furniture selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByExample(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByPrimaryKeySelective(Furniture record);

    int updateByPrimaryKey(Furniture record);
}