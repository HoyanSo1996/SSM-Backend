package com.omega.ssm.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.omega.ssm.entity.Furniture;
import com.omega.ssm.entity.FurnitureExample;
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


    // @Override
    // public List<Furniture> pageFurniture(Integer pageNo, Integer pageSize, String name) {
    //     return furnitureMapper.selectListByBeginNoAndPageSizeAndName((pageNo - 1) * pageSize, pageSize, name);
    // }

    @Override
    public PageInfo<Furniture> pageFurniture(Integer pageNo, Integer pageSize) {
        // 1. 设置分页参数. 这里会创建一个 page 对象, 然后放入 pageNo 和 pageSize 参数, 再将 page 对象放入 ThreadLocal 中
        PageHelper.startPage(pageNo, pageSize);
        // 2. 由于在 mybatis-config.xml 中设置了 PageInterceptor 拦截器, 当 Executor 执行 query 方法时, 拦截器就会对该方法进行
        //    增强(动态代理), 在 ThreadLocal 中获取刚才放入的 page 对象, 获取 pageNo 和 pageSize 参数, 然后对 sql 语句进行拼接执行
        //    的 query 方法的 sql 语句进行拼接字符串. 如为下面的 select * from furniture 语句拼接上 limit ? ?, 当 Executor
        //    执行完 query 方法后, 返回 page 对象(Page 继承了 ArrayList), 即下面的 furnitureList 的实际运行类型是 page 对象.
        //    最后, ThreadLocal 会 remove 掉线程里的 page 对象, 从而完成一次分页的业务流程.
        List<Furniture> furnitureList = furnitureMapper.selectAll();
        System.out.println("furnitureList 的运行类型 = " + furnitureList.getClass());  // com.github.pagehelper.Page
        return new PageInfo<>(furnitureList, pageNo);
    }

    @Override
    public PageInfo<Furniture> pageFurnitureByName(Integer pageNo, Integer pageSize, String name) {
        PageHelper.startPage(pageNo, pageSize);
        // List<Furniture> furnitureList = furnitureMapper.selectListByName(name);

        // 改进: 通过 Criteria 对象可以设置各种查询条件
        FurnitureExample furnitureExample = new FurnitureExample();
        FurnitureExample.Criteria criteria = furnitureExample.createCriteria();
        criteria.andNameLike("%" + name + "%");
        List<Furniture> furnitureList = furnitureMapper.selectByExample(furnitureExample);
        return new PageInfo<>(furnitureList, pageNo);
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

    @Override
    public boolean removeById(Integer id) {
        return furnitureMapper.deleteByPrimaryKey(id) > 0;
    }
}
