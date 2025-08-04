package com.example.bai2.dao;

import com.example.bai2.model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAll();

    boolean addStudent(Student student);

    boolean updateStudent(Student student);

    boolean deleteStudent(int id);

    Student getStudent(int id);
}
