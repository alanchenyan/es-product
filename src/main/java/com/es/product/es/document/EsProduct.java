package com.es.product.es.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Alan Chen
 * @description ES类-商品
 * @date 2021/5/13
 */
@Data
@Document(indexName = "es_product",shards = 1, replicas = 0)
public class EsProduct {

    @Id
    private String id;

    //店铺名称
    @Field(type = FieldType.Keyword)
    private String merchantName;

    //品牌名称
    @Field(type = FieldType.Keyword)
    private String brandName;

    //商品分类名称
    @Field(type = FieldType.Keyword)
    private String categoryName;

    //商品名称
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String productName;

    //商品编号(barcode)
    @Field(type = FieldType.Keyword)
    private String productNo;

    //图片
    @Field(type = FieldType.Keyword)
    private String images;

    //商品原价
    @Field(type = FieldType.Double)
    private double originalPrice;

    //商品折扣价
    @Field(type = FieldType.Double)
    private double discountPrice;

    //库存
    @Field(type = FieldType.Integer)
    private Integer quantity;

    //销量
    @Field(type = FieldType.Integer)
    private Integer salesVolume;

    //简介
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String synopsis;
}
