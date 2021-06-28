package com.xrh.test;

import com.xrh.bean.Product;
import com.xrh.dao.ProductDao;
import com.xrh.dao.UserDao;
import com.xrh.dao.impl.ProductDaoImpl;
import com.xrh.dao.impl.UserDaoImpl;
import org.junit.Test;

import java.util.ArrayList;

public class DBTest {

    @Test
    public void TestAddUser() {
        UserDao userDao = new UserDaoImpl();
        boolean tom = userDao.addUser("Tom", "123");
        System.out.println(tom);
    }

    @Test
    public void TestUserLogin() {
        UserDao userDao = new UserDaoImpl();
        boolean result = userDao.findUser("Bob", "123");
        System.out.println(result);
    }

    @Test
    public void TestSelectProducts() {
        ProductDao productDao = new ProductDaoImpl();
        ArrayList<Product> products = productDao.selectList();
        products.forEach(System.out::println);
    }

    @Test
    public void TestAddProduct() {
        ProductDao productDao = new ProductDaoImpl();
        boolean res = productDao.addProduct("荔枝", 25.0, "不宜存放");
        System.out.println(res);
    }

    @Test
    public void TestDelProduct() {
        ProductDao productDao = new ProductDaoImpl();
        boolean res = productDao.delProduct(4);
        System.out.println(res);
    }

}
