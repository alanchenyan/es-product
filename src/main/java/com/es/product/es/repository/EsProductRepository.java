package com.es.product.es.repository;

import com.es.product.es.document.EsProduct;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2021/5/13
 */
public interface EsProductRepository extends ElasticsearchRepository<EsProduct,String> {

    /**
     * 根据价格区间查询(自定义方法-名称约定)
     * @param price1
     * @param price2
     * @return
     */
    List<EsProduct> findByOriginalPriceBetween(double price1, double price2);
}
