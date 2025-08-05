package com.example.bai2.controller;

import com.example.bai2.dao.CategoryDAO;
import com.example.bai2.dao.impl.CategoryDAOImpl;
import com.example.bai2.model.Category;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/CategoryController")
public class CategoryController extends HttpServlet {
    CategoryDAO categoryDAO;

    public CategoryController() {
        categoryDAO = new CategoryDAOImpl();
    }

    public void getAllCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> categories = categoryDAO.getAllCategories();
        request.setAttribute("categories", categories);
        request.getRequestDispatcher("Category/view.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("getAllCategories")) {
            getAllCategories(request, response);
        } else if (action.equals("deleteCategory")) {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = categoryDAO.deleteCategory(id);
            if (result) {
                getAllCategories(request, response);
            } else {
                request.getRequestDispatcher("Category/error.jsp").forward(request, response);
            }
        } else if (action.equals("initUpdate")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Category category = categoryDAO.getCategoryById(id);
            request.setAttribute("category", category);
            request.getRequestDispatcher("Category/update.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("Category/error.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("addCategory")) {
            Category category = new Category();
            category.setName(request.getParameter("name"));
            category.setDescription(request.getParameter("description"));
            boolean result = categoryDAO.addCategory(category);
            System.out.println(result);
            if (result) {
                getAllCategories(request, response);
            } else {
                request.getRequestDispatcher("Category/error.jsp").forward(request, response);
            }
        } else if (action.equals("updateCategory")) {
            Category category = new Category();
            category.setId(Integer.parseInt(request.getParameter("categoryId")));
            category.setName(request.getParameter("categoryName"));
            category.setDescription(request.getParameter("categoryDescription"));
            category.setStatus(Boolean.parseBoolean(request.getParameter("categoryAct")));
            boolean result = categoryDAO.updateCategory(category);
            if (result) {
                getAllCategories(request, response);
            } else {
                request.getRequestDispatcher("Category/error.jsp").forward(request, response);
            }
        } else if (action.equals("login")) {
            String admin = "admin";
            String adminPassword = "1";
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (admin.equals(username) && adminPassword.equals(password)) {
                getAllCategories(request, response);
            } else {
                request.getRequestDispatcher("Category/error.jsp").forward(request, response);
            }
        } else {
            request.getRequestDispatcher("Category/error.jsp").forward(request, response);
        }
    }
}
