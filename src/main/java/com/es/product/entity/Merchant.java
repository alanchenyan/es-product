package com.es.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 店铺
 * @date 2021/5/13
 */
@Data
public class Merchant {

    @TableId(type = IdType.UUID)
    private String id;

    //店铺名称
    private String merchantName;

    //地址
    private String address;

    //联系电话
    private String phone;

    //星级
    private String star;

    //逻辑删除标志 0:未删除；1：已删除
    @TableLogic
    private Integer deleted;
}
