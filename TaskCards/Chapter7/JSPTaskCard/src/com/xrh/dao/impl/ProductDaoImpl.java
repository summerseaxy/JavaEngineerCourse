package com.xrh.dao.impl;

import com.xrh.bean.Product;
import com.xrh.dao.ProductDao;
import com.xrh.util.DruidUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductDaoImpl implements ProductDao {
    @Override
    public ArrayList<Product> selectList() {
        Connection con = DruidUtil.getConnection();
        String sql = "select * from products";
        ResultSet temp = null;
        ArrayList<Product> result = new ArrayList<>();
        try {
            temp = DruidUtil.query(sql, null);
            while (temp.next()) {
                int id = temp.getInt("id");
                String productName = temp.getString("productName");
                double price = temp.getDouble("price");
                String description = temp.getString("description");
                result.add(new Product(id, productName, price, description));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close();
        }
        return result;
    }

    @Override
    public boolean addProduct(String productName, double price, String description) {
        Connection con = DruidUtil.getConnection();
        String sql = "insert products (productName, price, description) values(?, ?, ?)";
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(productName, price, description));
        int result = 0;
        try {
            result = DruidUtil.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close();
        }
        return result == 0 ? false : true;
    }

    @Override
    public boolean delProduct(int id) {
        Connection con = DruidUtil.getConnection();
        String sql = "delete from products where id=?";
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(id));
        int result = 0;
        try {
            result = DruidUtil.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close();
        }
        return result == 0 ? false : true;
    }
}
