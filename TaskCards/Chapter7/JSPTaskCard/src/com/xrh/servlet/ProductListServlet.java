package com.xrh.servlet;

import com.xrh.bean.Product;
import com.xrh.service.ProductService;
import com.xrh.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/productList")
public class ProductListServlet extends HttpServlet {
    private ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Product> list = productService.selectList();
        req.setAttribute("productList", list);
        req.getRequestDispatcher("/productList.jsp").forward(req, resp);
    }
}
