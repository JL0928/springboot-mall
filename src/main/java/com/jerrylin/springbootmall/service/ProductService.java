package com.jerrylin.springbootmall.service;


import com.jerrylin.springbootmall.dto.ProductQueryParams;
import com.jerrylin.springbootmall.dto.ProductRequest;
import com.jerrylin.springbootmall.modal.Product;

import java.util.List;

public interface ProductService {

    int countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(int productId);

    int createProduct(ProductRequest productRequest);

    void updateProduct(int productId,ProductRequest productRequest);

    void deleteProductById(int productId);
}
