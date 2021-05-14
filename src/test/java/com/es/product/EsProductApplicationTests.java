package com.es.product;

import com.es.product.es.document.EsProduct;
import com.es.product.es.service.IEsProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import java.util.List;

@SpringBootTest
class EsProductApplicationTests {

    @Autowired
    private IEsProductService esProductService;

    /**
     * 从数据库中导入商品到ES
     * @return
     */
    @Test
    public void importAll(){
        esProductService.importAll();
    }

    /**
     * 新增/修改(id存在就是修改，否则就是插入)
     */
    @Test
    public void save(){
        String id = "2e01a7b7b3cf11ebaf7000163e066303";
        esProductService.save(id);
    }

    /**
     * 根据id删除商品
     */
    @Test
    public void delete(){
        String id = "2e01a7b7b3cf11ebaf7000163e066303";
        esProductService.delete(id);
    }

    /**
     * 根据id获得商品
     * @return
     */
    @Test
    public void get(){
        String id = "2e01a7b7b3cf11ebaf7000163e066303";
        EsProduct esProduct = esProductService.get(id);
        System.out.println(esProduct);
    }

    /**
     * 批量删除
     */
    @Test
    public void deletes(){

    }

    /**
     * 所有商品(按价格排序)
     * @return
     */
    @Test
    public void listAll(){
        List<EsProduct> list = esProductService.listAll();
        System.out.println(list);
    }

    /**
     * 根据价格区间查询(自定义方法)
     * @return
     */
    @Test
    public void queryByPriceBetween(){
        List<EsProduct> list = esProductService.queryByPriceBetween(4000,5000);
        System.out.println(list);
    }

    /**
     * 名称查询
     * @return
     */
    @Test
    public void query(){
        String productName = "Apple";
        Page<EsProduct> page = esProductService.query(productName);

        // 打印总条数
        System.out.println(page.getTotalElements());
        // 打印总页数
        System.out.println(page.getTotalPages());
        page.forEach(System.out::println);
    }

    /**
     * 分页查询
     * @return
     */
    @Test
    public void pageSearch(){
        String categoryName = "手机";
        int page = 1;
        int size =2;

        Page<EsProduct> esProducts = esProductService.pageSearch(categoryName,page,size);

        // 打印总条数
        System.out.println(esProducts.getTotalElements());
        // 打印总页数
        System.out.println(esProducts.getTotalPages());
        // 每页大小
        System.out.println(esProducts.getSize());
        // 当前页
        System.out.println(esProducts.getNumber());
        esProducts.forEach(System.out::println);
    }

    /**
     * 分页查询(排序)
     * @return
     */
    @Test
    public void pageSortSearch(){
        String categoryName = "手机";
        int page = 1;
        int size =2;

        Page<EsProduct> esProducts = esProductService.pageSortSearch(categoryName,page,size);

        // 打印总条数
        System.out.println(esProducts.getTotalElements());
        // 打印总页数
        System.out.println(esProducts.getTotalPages());
        // 每页大小
        System.out.println(esProducts.getSize());
        // 当前页
        System.out.println(esProducts.getNumber());
        esProducts.forEach(System.out::println);
    }

}
