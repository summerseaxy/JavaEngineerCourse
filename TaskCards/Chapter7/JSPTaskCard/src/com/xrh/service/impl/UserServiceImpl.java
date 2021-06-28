package com.xrh.service.impl;

import com.xrh.dao.UserDao;
import com.xrh.dao.impl.UserDaoImpl;
import com.xrh.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean addUser(String username, String password) {
        return userDao.addUser(username, password);
    }

    @Override
    public boolean findUser(String username, String password) {
        return userDao.findUser(username, password);
    }
}
