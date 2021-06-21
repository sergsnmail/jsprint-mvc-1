package com.sergsnmail.spring.mvc.repository;

import com.sergsnmail.spring.mvc.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getProducts();
    Product getProduct(long id);
    void create (Product product);
    void update (Product product);
    void delete(long id);
}
