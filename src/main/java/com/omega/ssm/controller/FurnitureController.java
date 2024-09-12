package com.omega.ssm.controller;

import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.ResultInfo;
import com.omega.ssm.service.FurnitureService;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/add")
    public ResultInfo add(@Valid @RequestBody Furniture furniture, Errors errors) {
        System.out.println(furniture);
        Map<String, String> map = new HashMap<>();
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                String fieldName = error.getObjectName() + "_" + ((FieldError) error).getField();
                map.put(fieldName, error.getDefaultMessage());
            }
            return new ResultInfo(500, "fail", map);
        }
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

    @GetMapping("/page")
    public ResultInfo page(Integer pageNo, Integer pageSize, String name) {
        try {
            List<Furniture> furnitureList = furnitureService.pageFurniture(pageNo, pageSize, name);
            return new ResultInfo(200, "success", furnitureList);
        } catch (Exception e) {
            return new ResultInfo(500, "fail");
        }
    }

    @GetMapping("/queryById")
    public ResultInfo queryById(Integer id) {
        try {
            Furniture furniture = furnitureService.getFurnitureById(id);
            return new ResultInfo(200, "success", furniture);
        } catch (Exception e) {
            return new ResultInfo(500, "fail");
        }
    }

    @PutMapping("/modify")
    public ResultInfo modify(@RequestBody Furniture furniture) {
        boolean flag = furnitureService.updateById(furniture);
        if (flag) {
            return new ResultInfo(200, "success");
        }
        return new ResultInfo(500, "fail");
    }

    @DeleteMapping("/remove")
    public ResultInfo remove(Integer id) {
        boolean flag = furnitureService.removeById(id);
        if (flag) {
            return new ResultInfo(200, "success");
        }
        return new ResultInfo(500, "fail");
    }
}
