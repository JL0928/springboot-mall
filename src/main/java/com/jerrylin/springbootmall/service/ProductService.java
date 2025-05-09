package com.jerrylin.springbootmall.service;

import com.jerrylin.springbootmall.dto.ProductRequest;
import com.jerrylin.springbootmall.modal.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(int productId);

    int createProduct(ProductRequest productRequest);

    void updateProduct(int productId,ProductRequest productRequest);

    void deleteProductById(int productId);
}
