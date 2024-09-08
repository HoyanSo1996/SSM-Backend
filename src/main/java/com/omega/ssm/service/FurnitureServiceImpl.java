package com.omega.ssm.service;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.mapper.FurnitureMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
