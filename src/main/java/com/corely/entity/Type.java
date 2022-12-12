package com.corely.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 *
 * @TableName t_type
 */
@TableName(value ="t_type")
@Data
public class Type implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     *
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
