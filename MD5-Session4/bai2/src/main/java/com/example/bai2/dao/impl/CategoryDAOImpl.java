package com.example.bai2.dao.impl;

import com.example.bai2.Util.DB;
import com.example.bai2.dao.CategoryDAO;
import com.example.bai2.dao.StudentDAO;
import com.example.bai2.model.Category;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {
    @Override
    public List<Category> getAllCategories() {
        String sql = "{CALL get_all_category()}";
        List<Category> categories = new ArrayList<>();
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement callStmt = connection.prepareCall(sql);) {
            ResultSet rs = callStmt.executeQuery();
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public Category getCategoryById(int id) {
        String sql = "{CALL get_category_by_id(id)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setDescription(rs.getString("description"));
                category.setStatus(rs.getBoolean("status"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addCategory(Category category) {
        String sql = "{CALL add_category(?,?)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setString(1, category.getName());
            stmt.setString(2, category.getDescription());
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
    public boolean updateCategory(Category category) {
        String sql = "{CALL update_category(?,?,?,?)}";
        try (Connection connection = DB.getInstance().getConnection();
             CallableStatement stmt = connection.prepareCall(sql);) {
            stmt.setInt(1, category.getId());
            stmt.setString(2, category.getName());
            stmt.setString(3, category.getDescription());
            stmt.setBoolean(4, category.isStatus());
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
    public boolean deleteCategory(int id) {
        String sql = "{CALL delete_category(?)}";
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
}
