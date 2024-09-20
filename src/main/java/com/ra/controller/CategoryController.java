package com.ra.controller;

import com.ra.model.dao.CategoryDAO;
import com.ra.model.dao.CategoryDAOImp;
import com.ra.model.entity.Category;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "categoryController",value = "/category")
public class CategoryController extends HttpServlet {
    private static CategoryDAO categoryDAO = new CategoryDAOImp();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // goij den DAO de lay du lieu
        List<Category> categories = categoryDAO.getAllCategory();
        // mang du lieu sang view de hien thi
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/category.jsp").forward(req,resp);
    }
}
