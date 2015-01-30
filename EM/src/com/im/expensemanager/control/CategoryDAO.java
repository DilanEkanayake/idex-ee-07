/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.im.expensemanager.control;

import com.im.expensemanager.model.Category;
import java.util.List;

/**
 *
 * @author Nadun Liyanage
 */
public interface CategoryDAO {
    
    public void save(Category category);
    public void update(Category category);
    public void delete(Category category);
    public Category get(int id);
    public List<Category> list();
    
}
