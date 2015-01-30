/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.im.expensemanager.control;

import com.im.expensemanager.db.DB;
import com.im.expensemanager.model.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Nadun Liyanage
 */
public class CategoryDAOImpl implements CategoryDAO{

    @Override
    public void save(Category category) {
        try {
            Connection con = DB.getConnection();
            String sql = "INSERT INTO category VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.setString(2, category.getName());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Saved!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void update(Category category) {
        try {
            Connection con = DB.getConnection();
            String sql = "UPDATE category SET name=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, category.getName());
            ps.setInt(2, category.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Updated!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public void delete(Category category) {
        try {
            Connection con = DB.getConnection();
            String sql = "DELETE FROM category WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, category.getId());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Deleted!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    @Override
    public Category get(int id) {
        Category category = new Category();
        try {
            Connection con = DB.getConnection();
            String sql = "SELECT * FROM category WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return category;
    }

    @Override
    public List<Category> list() {
        List<Category> list = new ArrayList<Category>();
        try {
            Connection con = DB.getConnection();
            String sql = "SELECT * FROM category ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                list.add(category);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error");
        }
        return list;
    }
    
}
