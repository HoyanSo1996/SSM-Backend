package com.omega.ssm.service;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.mapper.FurnitureMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Class FurnitureServiceImpl
 *
 * @author KennySo
 * @date 2024/9/8
 */
@Service
public class FurnitureServiceImpl implements FurnitureService {

    @Resource
    private FurnitureMapper furnitureMapper;

    @Override
    public boolean add(Furniture furniture) {
        try {
            return furnitureMapper.insertSelective(furniture) > 0;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Furniture> getFurnitureList() {
        // 也可以使用
        // return furnitureMapper.selectByExample(null);
        return furnitureMapper.selectAll();
    }

    @Override
    public Furniture getFurnitureById(Integer id) {
        return furnitureMapper.selectByPrimaryKey(id);
    }

    @Override
    public boolean updateById(Furniture furniture) {
        furniture.setUpdateTime(new Date());
        return furnitureMapper.updateByPrimaryKeySelective(furniture) > 0;
    }
}
