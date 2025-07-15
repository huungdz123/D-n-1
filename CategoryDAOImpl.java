/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baihoc.minimart.daoimpl;

import baihoc.minimart.dao.CategoryDAO;
import baihoc.minimart.entity.Category;
import baihoc.minimart.until.XJdbc;
import baihoc.minimart.until.XQuery;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CategoryDAOImpl implements CategoryDAO{
    String createSql = "INSERT INTO Categories(CategoryID, CategoryName) VALUES(?, ?)";
    String updateSql = "UPDATE Categories SET CategoryName=? WHERE CategoryID=?";
    String deleteSql = "DELETE FROM Categories WHERE CategoryID=?";
    String findAllSql = "SELECT * FROM Categories";
    String findByIdSql = "SELECT * FROM Categories WHERE CategoryID=?";

    @Override
    public Category create(Category entity) {
        Object[] values={
            entity.getCategoryID(),
            entity.getCategoryName()
        };
        XJdbc.executeUpdate(createSql, values);
        return entity;
    }

    @Override
    public void update(Category entity) {
        Object[] values={
            entity.getCategoryID(),
            entity.getCategoryName()
        };
        XJdbc.executeUpdate(updateSql, values);
    }

    @Override
    public void deleteById(Integer categoryID) {
        XJdbc.executeUpdate(deleteSql, categoryID);
    }

    @Override
    public List<Category> findAll() {
        return XQuery.getBeanList(Category.class,findAllSql);
    }

    @Override
    public Category findById(Integer categoryID) {
        return XQuery.getSingleBean(Category.class,findByIdSql,categoryID);
    }
    
}
