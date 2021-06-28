package com.xrh.service.impl;

import com.xrh.bean.Product;
import com.xrh.dao.ProductDao;
import com.xrh.dao.impl.ProductDaoImpl;
import com.xrh.service.ProductService;

import java.util.ArrayList;

public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public ArrayList<Product> selectList() {
        return productDao.selectList();
    }

    @Override
    public boolean addProduct(String productName, double price, String description) {
        return productDao.addProduct(productName, price, description);
    }

    @Override
    public boolean delProduct(int id) {
        return productDao.delProduct(id);
    }


}
