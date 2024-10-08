package com.ra.model.dao;

import com.ra.model.entity.Category;
import com.ra.util.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImp implements CategoryDAO{
    @Override
    public List<Category> getAllCategory() {
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        connection = ConnectDB.open();
        try {
            String sql = "SELECT * FROM cagegories";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Category category = new Category();
                category.setCategoryId(resultSet.getInt("id"));
                category.setCategoryName(resultSet.getString("name"));
                category.setCategoryStatus(resultSet.getBoolean("status"));
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.close(connection);
        }
        return categories;
    }

    @Override
    public Boolean create(Category category) {
        // ghi de [huong thuc them moi va lam them moi giong Javacore
        return null;
    }


}
