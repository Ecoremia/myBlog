package com.corely.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName t_message
 */
@TableName(value ="t_message")
@Data
public class Message implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private String avatar;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Long parentMessageId;

    /**
     * 
     */
    private Boolean adminMessage;

    /**
     * 
     */
    private String parentEmail;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}