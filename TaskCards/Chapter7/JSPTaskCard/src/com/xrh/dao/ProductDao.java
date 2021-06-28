package com.xrh.dao;

import com.xrh.bean.Product;

import java.util.ArrayList;

public interface ProductDao {
    ArrayList<Product> selectList();

    boolean addProduct(String productName, double price, String description);

    boolean delProduct(int id);
}
