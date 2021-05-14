package com.es.product.es.service;

import com.es.product.es.document.EsProduct;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2021/5/13
 */
public interface IEsProductService {

    /**
     * 从数据库中导入商品到ES
     * @return
     */
    void importAll();

    /**
     * 新增/修改(id存在就是修改，否则就是插入)
     * @param id
     */
    void save(String id);

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(String id);

    /**
     * 根据id获得商品
     * @param id
     * @return
     */
    EsProduct get(String id);

    /**
     * 批量删除
     * @param ids
     */
    void deletes(List<String> ids);

    /**
     * 所有商品(按价格排序)
     * @return
     */
    List<EsProduct> listAll();

    /**
     * 根据价格区间查询(自定义方法)
     * @param price1
     * @param price2
     * @return
     */
    List<EsProduct> queryByPriceBetween(double price1, double price2);

    /**
     * 名称查询（高级查询）
     * @param productName
     * @return
     */
    Page<EsProduct> query(String productName);

    /**
     * 分页查询
     * @param categoryName
     * @param page
     * @param size
     * @return
     */
    Page<EsProduct> pageSearch(String categoryName,int page ,int size);

    /**
     * 分页查询(排序)
     * @param categoryName
     * @param page
     * @param size
     * @return
     */
    Page<EsProduct> pageSortSearch(String categoryName,int page ,int size);
}
