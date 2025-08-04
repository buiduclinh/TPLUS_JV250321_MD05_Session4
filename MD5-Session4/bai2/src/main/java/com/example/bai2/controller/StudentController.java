package com.example.bai2.controller;

import com.example.bai2.dao.StudentDAO;
import com.example.bai2.dao.impl.StudentDAOImpl;
import com.example.bai2.model.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/StudentServlet")
public class StudentController extends HttpServlet {
    StudentDAO studentDAO;

    public StudentController() {
        studentDAO = new StudentDAOImpl();
    }

    public void findAllStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Student> studentList = studentDAO.getAll();
        req.setAttribute("studentList", studentList);
        req.getRequestDispatcher("view.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        System.out.println(action);
        if (action.equals("findAllStudent")) {
            findAllStudent(req, resp);
        } else if (action.equals("deleteStudent")) {
            int studentId = Integer.parseInt(req.getParameter("id"));
            boolean result = studentDAO.deleteStudent(studentId);
            if (result) {
                findAllStudent(req, resp);
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else if (action.equals("initUpdateStudent")) {
            int studentId = Integer.parseInt(req.getParameter("id"));
            Student student = studentDAO.getStudent(studentId);
            req.setAttribute("student", student);
            req.getRequestDispatcher("update.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action.equals("addStudent")) {
            Student student = new Student();
            student.setName(req.getParameter("name"));
            try {
                int age = Integer.parseInt(req.getParameter("age"));
                student.setAge(age);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Tuổi không hợp lệ!");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            boolean result = studentDAO.addStudent(student);
            if (result) {
                findAllStudent(req, resp);
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else if (action.equals("updateStudent")) {
            Student student = new Student();
            student.setId(Integer.parseInt(req.getParameter("studentId")));
            student.setName(req.getParameter("studentName"));
            try {
                int age = Integer.parseInt(req.getParameter("studentAge"));
                student.setAge(age);
            } catch (NumberFormatException e) {
                req.setAttribute("error", "Tuổi không hợp lệ!");
                req.getRequestDispatcher("error.jsp").forward(req, resp);
                return;
            }
            student.setAge(Integer.parseInt(req.getParameter("studentAge")));
            student.setStatus(Boolean.parseBoolean(req.getParameter("studentAct")));
            boolean result = studentDAO.updateStudent(student);
            if (result) {
                findAllStudent(req, resp);
            } else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else if (action.equals("login")) {
            String admin = "admin";
            String adminPassword = "1";
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            if(username.equals(admin) && password.equals(adminPassword)) {
                findAllStudent(req, resp);
            }else {
                req.getRequestDispatcher("error.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("error.jsp").forward(req, resp);
        }
    }


}
