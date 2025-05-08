package com.jerrylin.springbootmall.service.impl;

import com.jerrylin.springbootmall.dao.ProductDao;
import com.jerrylin.springbootmall.dto.ProductRequest;
import com.jerrylin.springbootmall.modal.Product;
import com.jerrylin.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(int productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public int createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
