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
        //lay action tren url
        String acction = req.getParameter("action");
        if(acction != null){
            switch (acction){
                case "add":
                    req.getRequestDispatcher("/views/add.jsp").forward(req,resp);
                    break;
                case "edit":
                    resp.sendRedirect("edit.jsp");
                    break;
                case "delete":
                    break;
            }
        }
        // goij den DAO de lay du lieu
        List<Category> categories = categoryDAO.getAllCategory();
        // mang du lieu sang view de hien thi
        req.setAttribute("categories",categories);
        req.getRequestDispatcher("/views/category.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // nhan du lieu tu form
        String name = req.getParameter("name");
        Category category = new Category();
        category.setCategoryName(name);
        category.setCategoryStatus(true);
        // goi den DAO de them moi
        categoryDAO.create(category);
    }
}
