/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baihoc.minimart.daoimpl;

import baihoc.minimart.dao.StockDao;
import baihoc.minimart.entity.Product;
import baihoc.minimart.entity.StockTransaction;
import baihoc.minimart.until.XJdbc;
import baihoc.minimart.until.XQuery;
import java.util.List;

/**
 *
 * @author NGUYEN HUU
 */
public class StockDAOImpl implements StockDao {

     @Override
    public Product getProductById(int productID) {
        String sql = "SELECT ProductID, ProductName, Price, StockQuantity FROM Products WHERE ProductID = ?";
        return XQuery.getSingleBean(Product.class,sql, productID);
    }

       @Override
    public boolean importStock(int productID, int quantity, String note) {
        try {
            XJdbc.executeUpdate("UPDATE Products SET StockQuantity = StockQuantity + ? WHERE ProductID = ?", quantity, productID);
            XJdbc.executeUpdate("INSERT INTO StockTransactions (ProductID, Quantity, TransactionType, Note) VALUES (?,?,?,?)",
                    productID, quantity, "Import", note);
            return true;
        } catch (Exception e) {
            System.err.println("Lỗi nhập kho: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean exportStock(int productID, int quantity, String note) {
        try {
            Product p = getProductById(productID);
            if (p == null || p.getStockQuantity() < quantity) {
                System.err.println("Không đủ tồn kho hoặc sản phẩm không tồn tại.");
                return false;
            }
            XJdbc.executeUpdate("UPDATE Products SET StockQuantity = StockQuantity - ? WHERE ProductID = ?", quantity, productID);
            XJdbc.executeUpdate("INSERT INTO StockTransactions (ProductID, Quantity, TransactionType, Note) VALUES (?,?,?,?)",
                    productID, quantity, "Export", note);
            return true;
        } catch (Exception e) {
            System.err.println("Lỗi xuất kho: " + e.getMessage());
            return false;
        }
    }

      @Override
    public List<StockTransaction> getAllTransactions() {
        String sql = "SELECT * FROM StockTransactions ORDER BY TransactionDate DESC";
        return XQuery.getBeanList(StockTransaction.class,sql);
    }
    
    
}
