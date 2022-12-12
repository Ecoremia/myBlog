package com.corely.dao;

import com.corely.entity.Type;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_type】的数据库操作Mapper
* @createDate 2022-10-23 17:14:28
* @Entity com.corely.entity.Type
*/
@Repository
public interface TypeMapper extends BaseMapper<Type> {

}




