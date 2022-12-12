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
 * @TableName t_blog
 */
@TableName(value ="t_blog")
@Data
public class Blog implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private Boolean appreciation;

    /**
     *
     */
    private Boolean commentabled;

    /**
     *
     */
    private String content;

    /**
     *
     */
    private Date createTime;

    /**
     *
     */
    private String firstPicture;

    /**
     * 原创还是转载
     */
    private String flag;

    /**
     *
     */
    private Boolean published;

    /**
     *
     */
    private Boolean recommend;

    /**
     *
     */
    private Boolean shareStatement;

    /**
     *
     */
    private String title;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private String views;

    /**
     *
     */
    private Long typeId;

    /**
     *
     */
    private Long userId;

    /**
     *
     */
    private String description;

    /**
     *
     */
    private Integer commentCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
