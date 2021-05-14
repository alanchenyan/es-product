package com.es.product.es.service.impl;

import com.es.product.es.dao.EsProductDao;
import com.es.product.es.document.EsProduct;
import com.es.product.es.repository.EsProductRepository;
import com.es.product.es.service.IEsProductService;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Alan Chen
 * @description
 * @date 2021/5/13
 */
@Service
public class EsProductServiceImpl implements IEsProductService {

    @Autowired
    EsProductDao esProductDao;

    @Autowired
    EsProductRepository esProductRepository;

    /**
     * 从数据库中导入商品到ES
     * @return
     */
    @Override
    public void importAll() {
        List<EsProduct> list = esProductDao.listAll();
        esProductRepository.saveAll(list);
    }

    /**
     * 新增/修改(id存在就是修改，否则就是插入)
     * @param id
     */
    @Override
    public void save(String id) {
        EsProduct esProduct = esProductDao.selectById(id);
        esProductRepository.save(esProduct);
    }

    /**
     * 根据id删除商品
     * @param id
     */
    @Override
    public void delete(String id) {
        esProductRepository.deleteById(id);
    }

    /**
     * 根据id获得商品
     * @param id
     * @return
     */
    @Override
    public EsProduct get(String id) {
        return esProductDao.selectById(id);
    }

    /**
     * 批量删除
     * @param ids
     */
    @Override
    public void deletes(List<String> ids) {
        for(String id : ids){
            esProductRepository.deleteById(id);
        }
    }

    /**
     * 所有商品(按价格排序)
     * @return
     */
    @Override
    public List<EsProduct> listAll() {
        Iterable<EsProduct> items = this.esProductRepository.findAll(Sort.by(Sort.Direction.DESC, "discountPrice"));

        List<EsProduct> list = new ArrayList<>();
        items.forEach(esProduct -> list.add(esProduct));

        return list;
    }

    /**
     * 根据价格区间查询(自定义方法)
     * @param price1
     * @param price2
     * @return
     */
    @Override
    public List<EsProduct> queryByPriceBetween(double price1, double price2) {
        return esProductRepository.findByOriginalPriceBetween(price1,price2);
    }

    /**
     * 名称查询（高级查询）
     * @param productName
     * @return
     */
    @Override
    public Page<EsProduct> query(String productName) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("productName", productName));
        // 执行搜索，获取结果
        Page<EsProduct> esProducts = esProductRepository.search(queryBuilder.build());

        return esProducts;
    }

    /**
     * 分页查询
     * @param categoryName
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<EsProduct> pageSearch(String categoryName, int page, int size) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("categoryName", categoryName));

        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 执行搜索，获取结果
        Page<EsProduct> esProducts = esProductRepository.search(queryBuilder.build());

        return esProducts;
    }

    /**
     * 分页查询(排序)
     * @param categoryName
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<EsProduct> pageSortSearch(String categoryName, int page, int size) {
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本的分词查询
        queryBuilder.withQuery(QueryBuilders.termQuery("categoryName", categoryName));

        // 设置分页参数
        queryBuilder.withPageable(PageRequest.of(page, size));

        // 排序
        queryBuilder.withSort(SortBuilders.fieldSort("originalPrice").order(SortOrder.DESC));

        // 执行搜索，获取结果
        Page<EsProduct> esProducts = esProductRepository.search(queryBuilder.build());

        return esProducts;
    }

}
