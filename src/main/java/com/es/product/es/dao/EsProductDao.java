package com.es.product.es.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.es.product.es.document.EsProduct;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2021/5/13
 */
@Repository
@Mapper
public interface EsProductDao extends BaseMapper {

    /**
     * 获取所有商品数据
     * @return
     */
    List<EsProduct> listAll();

    /**
     * 获取信息
     * @param id
     * @return
     */
    EsProduct selectById(String id);
}
