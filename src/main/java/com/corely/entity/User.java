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
 * @TableName t_user
 */
@TableName(value ="t_user")
@Data
public class User  {
    /**
     * 注销了 implements Serializable
     */
    @TableId(type = IdType.AUTO)
    private Long id;

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
    private String email;

    /**
     *
     */
    private String nickname;

    /**
     *
     */
    private String password;

    /**
     *
     */
    private Integer type;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private String username;

//    @TableField(exist = false)
//    private static final long serialVersionUID = 1L;
}
