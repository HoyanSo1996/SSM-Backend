package com.omega.ssm.controller;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.ResultInfo;
import com.omega.ssm.service.FurnitureService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Class FurnitureController
 *
 * @author KennySo
 * @date 2024/9/8
 */
@RestController
@RequestMapping("/furniture")
public class FurnitureController {

    @Resource
    private FurnitureService furnitureService;

    @PostMapping("/save")
    public ResultInfo save(@RequestBody Furniture furniture) {
        boolean flag = furnitureService.add(furniture);
        if (flag) {
            return new ResultInfo(200, "success");
        }
        return new ResultInfo(500, "fail");
    }
}
