package com.omega.ssm.controller;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.ResultInfo;
import com.omega.ssm.service.FurnitureService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @GetMapping("/query")
    public ResultInfo query() {
        try {
            List<Furniture> furnitureList = furnitureService.getFurnitureList();
            return new ResultInfo(200, "success", furnitureList);
        } catch (Exception e) {
            return new ResultInfo(500, "fail");
        }
    }
}
