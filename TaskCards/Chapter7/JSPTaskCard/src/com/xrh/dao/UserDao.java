package com.xrh.dao;

public interface UserDao {
    boolean addUser(String username, String password);

    boolean findUser(String username, String password);
}
