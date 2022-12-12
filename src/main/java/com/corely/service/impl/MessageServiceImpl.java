package com.corely.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.corely.entity.Message;
import com.corely.service.MessageService;
import com.corely.dao.MessageMapper;
import org.springframework.stereotype.Service;

/**
* @author Administrator
* @description 针对表【t_message】的数据库操作Service实现
* @createDate 2022-10-23 17:13:21
*/
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message>
    implements MessageService{

}




