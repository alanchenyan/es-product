package com.es.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 商品分类
 * @date 2021/5/13
 */
@Data
public class Category {

    @TableId(type = IdType.UUID)
    private String id;

    //分类名称
    private String categoryName;

    //逻辑删除标志 0:未删除；1：已删除
    @TableLogic
    private Integer deleted;
}
