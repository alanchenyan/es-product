package com.es.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author Alan Chen
 * @description 商品
 * @date 2020-01-04
 */
@Data
public class Product{

    @TableId(type = IdType.UUID)
    private String id;

    //店铺ID
    private String merchantId;

    //品牌ID
    private String brandId;

    //商品分类ID
    private String categoryId;

    //商品名称
    private String productName;

    //商品编号(barcode)
    private String productNo;

    //图片
    private String images;

    //商品原价
    private double originalPrice;

    //商品折扣价
    private double discountPrice;

    //库存
    private Integer stock;

    //销量
    private Integer salesVolume;

    //浏览量
    private Integer views;

    //简介
    private String synopsis;

    //详细介绍
    private String introduction;

    //发布状态
    private int publishState;

    //逻辑删除标志 0:未删除；1：已删除
    @TableLogic
    private Integer deleted;
}
