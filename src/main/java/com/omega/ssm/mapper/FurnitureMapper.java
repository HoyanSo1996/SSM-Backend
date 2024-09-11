package com.omega.ssm.mapper;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.FurnitureExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

// @Repository  //这里不需要注解
public interface FurnitureMapper {

    List<Furniture> selectAll();

    List<Furniture> selectByExample(FurnitureExample example);

    List<Furniture> selectListByBeginNoAndPageSizeAndName(@Param("beginNo") Integer beginNo,
                                                          @Param("pageSize") Integer pageSize,
                                                          @Param("name") String name);

    Furniture selectByPrimaryKey(Integer id);

    int insert(Furniture record);

    int insertSelective(Furniture record);

    int deleteByPrimaryKey(Integer id);

    int deleteByExample(FurnitureExample example);

    int updateByExampleSelective(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByExample(@Param("record") Furniture record, @Param("example") FurnitureExample example);

    int updateByPrimaryKeySelective(Furniture record);

    int updateByPrimaryKey(Furniture record);

    long countByExample(FurnitureExample example);
}