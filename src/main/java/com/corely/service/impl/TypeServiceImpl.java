package com.corely.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.Type;
import com.corely.handler.NotFoundException;
import com.corely.service.TypeService;
import com.corely.dao.TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description 针对表【t_type】的数据库操作Service实现
 * @createDate 2022-10-23 17:14:28
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
        implements TypeService {
    @Autowired
    private TypeMapper typeMapper;

    public Page<Type> getPage(Page<Type> page) {
        //page用来定义参数，Ipage用来记录分页
        return typeMapper.selectPage(page, null);
    }

    @Override
    public Type getTypeByName(String name) {
        QueryWrapper<Type> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return typeMapper.selectOne(wrapper);
    }

}




