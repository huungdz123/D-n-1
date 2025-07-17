/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baihoc.minimart.daoimpl;

import baihoc.minimart.dao.RevenueDAO;
import baihoc.minimart.entity.Revenue;
import baihoc.minimart.until.XQuery;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class RevenueDAOImpl implements RevenueDAO{

    @Override
    public List<Revenue.ByCategory> getByCategory(Date begin, Date end) {
        String sql = "SELECT c.CategoryName AS Category, "
                   + "SUM(d.UnitPrice * d.Quantity) AS Revenue, "
                   + "SUM(d.Quantity) AS Quantity, "
                   + "MIN(d.UnitPrice) AS MinPrice, "
                   + "MAX(d.UnitPrice) AS MaxPrice, "
                   + "AVG(d.UnitPrice) AS AvgPrice "
                   + "FROM InvoiceDetails d "
                   + "JOIN Products p ON p.ProductID = d.ProductID "
                   + "JOIN Categories c ON c.CategoryID = p.CategoryID "
                   + "JOIN Invoices i ON i.InvoiceID = d.InvoiceID "
                   + "WHERE i.InvoiceDate BETWEEN ? AND ? "
                   + "GROUP BY c.CategoryName "
                   + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(Revenue.ByCategory.class, sql, begin, end);
    }

    @Override
    public List<Revenue.ByCustomer> getByCustomer(Date begin, Date end) {
         String sql = "SELECT cu.FullName AS CustomerName, "
                   + "cu.Phone, "
                   + "SUM(d.UnitPrice * d.Quantity) AS Revenue, "
                   + "COUNT(DISTINCT i.InvoiceID) AS TotalInvoices, "
                   + "MAX(i.InvoiceDate) AS LastPurchaseDate "
                   + "FROM Invoices i "
                   + "JOIN Customers cu ON cu.CustomerID = i.CustomerID "
                   + "JOIN InvoiceDetails d ON d.InvoiceID = i.InvoiceID "
                   + "WHERE i.InvoiceDate BETWEEN ? AND ? "
                   + "GROUP BY cu.FullName, cu.Phone "
                   + "ORDER BY Revenue DESC";
        return XQuery.getBeanList(Revenue.ByCustomer.class, sql, begin, end);
    }
    
}
