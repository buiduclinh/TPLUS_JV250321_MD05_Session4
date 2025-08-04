package com.example.bai2.dao.impl;

import com.example.bai2.Util.DB;
import com.example.bai2.dao.StudentDAO;
import com.example.bai2.model.Student;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    @Override
    public List<Student> getAll() {
        String sql = "{CALL get_all_student()}";
        List<Student> list = new ArrayList<>();
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addStudent(Student student) {
        String sql = "{CALL add_student(?,?)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setString(1, student.getName());
            stmt.setInt(2, student.getAge());
            int row = stmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateStudent(Student student) {
        String sql = "{CALL update_student(?,?,?,?)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setInt(1, student.getId());
            stmt.setString(2, student.getName());
            stmt.setInt(3, student.getAge());
            stmt.setBoolean(4, student.isStatus());
            int row = stmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        String sql = "{CALL delete_student(?)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setInt(1, id);
            int row = stmt.executeUpdate();
            if (row > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Student getStudent(int id) {
        String sql = "{CALL find_by_id(?)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("id"));
                student.setName(rs.getString("name"));
                student.setAge(rs.getInt("age"));
                student.setStatus(rs.getBoolean("status"));
                return student;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
