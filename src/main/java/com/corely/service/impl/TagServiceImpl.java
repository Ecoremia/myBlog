package com.corely.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.Tag;
import com.corely.service.TagService;
import com.corely.dao.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_tag】的数据库操作Service实现
* @createDate 2022-10-23 17:13:55
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




