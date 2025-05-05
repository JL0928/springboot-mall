package com.jerrylin.springbootmall.dao;

import com.jerrylin.springbootmall.modal.Product;

public interface ProductDao {

    Product getProductById(int productId);
}
