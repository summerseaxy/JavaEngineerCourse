package com.xrh.service;

public interface UserService {

    boolean addUser(String username, String password);

    boolean findUser(String username, String password);
}
