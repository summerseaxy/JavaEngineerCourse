package com.xrh.dao.impl;

import com.xrh.dao.UserDao;
import com.xrh.util.DruidUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

public class UserDaoImpl implements UserDao {
    @Override
    public boolean addUser(String username, String password) {
        Connection con = DruidUtil.getConnection();
        String sql = "insert users (username, password) values(?, ?)";
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(username, password));
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
    public boolean findUser(String username, String password) {
        Connection con = DruidUtil.getConnection();
        String sql = "select * from users where username=? and password=?";
        ArrayList<Object> params = new ArrayList<>(Arrays.asList(username, password));
        try {
            return DruidUtil.query(sql, params).next();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DruidUtil.close();
        }
        return false;
    }
}
