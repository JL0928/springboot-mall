package com.jerrylin.springbootmall.service;

import com.jerrylin.springbootmall.dto.ProductRequest;
import com.jerrylin.springbootmall.modal.Product;

public interface ProductService {
    Product getProductById(int productId);

    int createProduct(ProductRequest productRequest);

    void updateProduct(int productId,ProductRequest productRequest);

    void deleteProductById(int productId);
}
