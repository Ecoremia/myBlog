package com.corely.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.corely.entity.Type;
import com.baomidou.mybatisplus.extension.service.IService;
import com.corely.vo.TypeShow;

import java.util.List;

/**
* @author Administrator
* @description 针对表【t_type】的数据库操作Service
* @createDate 2022-10-23 17:14:28
*/
public interface TypeService extends IService<Type> {
    public  Page<Type> getPage(Page<Type> page);
    public Type getTypeByName(String name);
    public List<Type> getTypeTop(Page<Type> page);
    //查询并统计条数
    List<TypeShow> selectTypesAndCount(Page page);
}
