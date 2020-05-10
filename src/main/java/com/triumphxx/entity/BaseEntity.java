package com.triumphxx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author:triumphxx
 * @Date:2020/5/10
 * @Time:2:27 下午
 * @desc:所有Entity的父类
 **/
@Data
public class BaseEntity {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Date created;
    private Date modified;
}
