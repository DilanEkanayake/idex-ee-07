/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.im.expensemanager.control;

import com.im.expensemanager.model.Expense;
import java.util.List;

/**
 *
 * @author Nadun Liyanage
 */
public interface ExpenseDAO {
    public void save(Expense category);
    public void update(Expense category);
    public void delete(Expense category);
    public Expense get(int id);
    public List<Expense> list();
}
