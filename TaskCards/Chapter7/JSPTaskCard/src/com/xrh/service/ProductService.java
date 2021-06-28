package com.xrh.service;

import com.xrh.bean.Product;

import java.util.ArrayList;

public interface ProductService {
    ArrayList<Product> selectList();

    boolean addProduct(String productName, double price, String description);

    boolean delProduct(int id);
}
