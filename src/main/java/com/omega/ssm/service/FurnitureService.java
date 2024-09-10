package com.omega.ssm.service;

import com.omega.ssm.entity.Furniture;

import java.util.List;

/**
 * Class FurnitureService
 *
 * @author KennySo
 * @date 2024/9/8
 */
public interface FurnitureService {

    boolean add(Furniture furniture);

    List<Furniture> getFurnitureList();

    Furniture getFurnitureById(Integer id);

    boolean updateById(Furniture furniture);
}
