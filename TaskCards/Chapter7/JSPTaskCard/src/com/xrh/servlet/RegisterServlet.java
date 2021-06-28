package com.xrh.servlet;


import com.xrh.service.UserService;
import com.xrh.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //注册请求发过来，这里来响应请求
        //获取请求里的用户名、密码数据
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean result = userService.addUser(username, password);
        //把数据发给数据库，(dao操作)
        //得到返回值(是否注册成功，boolean )
        if(result) {
            resp.sendRedirect("/login.jsp");
        } else {
            resp.sendRedirect("/register.jsp");
        }
        //根据返回值确定这个请求如何响应{成功index: 失败: register}




    }
}
