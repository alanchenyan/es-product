package com.es.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 品牌
 * @date 2021/5/13
 */
@Data
public class Brand {

    @TableId(type = IdType.UUID)
    private String id;

    //品牌名称
    private String brandName;

    //逻辑删除标志 0:未删除；1：已删除
    @TableLogic
    private Integer deleted;
}
