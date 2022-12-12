package com.corely.dao;

import com.corely.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* @author Administrator
* @description 针对表【t_tag】的数据库操作Mapper
* @createDate 2022-10-23 17:13:55
* @Entity com.corely.entity.Tag
*/
@Repository
public interface TagMapper extends BaseMapper<Tag> {

}




