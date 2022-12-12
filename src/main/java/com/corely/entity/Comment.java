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
 * @TableName t_comment
 */
@TableName(value ="t_comment")
@Data
public class Comment implements Serializable {
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
    private Long blogId;

    /**
     * 
     */
    private Long parentCommentId;

    /**
     * 
     */
    private Boolean adminComment;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}