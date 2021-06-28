package com.xrh.servlet;

import com.xrh.service.ProductService;
import com.xrh.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delProduct")
public class DelProductServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置post编码格式，否则解析数据会乱码，报错
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        int id = Integer.valueOf(req.getParameter("id"));
        boolean result = productService.delProduct(id);
        req.getRequestDispatcher("/delProduct.jsp").forward(req, resp);
    }
}
