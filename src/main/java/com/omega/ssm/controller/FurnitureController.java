package com.omega.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.ResultInfo;
import com.omega.ssm.service.FurnitureService;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
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
        Map<String, String> map = new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        if (!map.isEmpty()) {
            return new ResultInfo(400, "fail", map);
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

    // @GetMapping("/page")
    // public ResultInfo page(Integer pageNo, Integer pageSize, String name) {
    //     try {
    //         List<Furniture> furnitureList = furnitureService.pageFurniture(pageNo, pageSize, name);
    //         return new ResultInfo(200, "success", furnitureList);
    //     } catch (Exception e) {
    //         return new ResultInfo(500, "fail");
    //     }
    // }

    /**
     * 分页查询
     * @param pageNo 起始页码, 默认值为 1
     * @param pageSize 一页数据量, 默认值为 5
     * @param name 家居名
     *
     * @return 分页的所有信息, 包括 起始页码, 一页数据量, 总数据量 等前端导航栏所需要的全部消息
     */
    @GetMapping("/page")
    public ResultInfo page(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                           @RequestParam(value = "name", defaultValue = "") String name) {
        try {
            PageInfo<Furniture> pageInfo;
            if (StringUtils.hasText(name)) {
                pageInfo = furnitureService.pageFurnitureByName(pageNo, pageSize, name);
            } else {
                pageInfo = furnitureService.pageFurniture(pageNo, pageSize);
            }
            return new ResultInfo(200, "success", pageInfo);
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
    public ResultInfo modify(@Valid @RequestBody Furniture furniture, Errors errors) {
        Map<String, String> map = new HashMap<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        if (!map.isEmpty()) {
            return new ResultInfo(400, "fail", map);
        }
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
