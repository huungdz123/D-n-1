/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baihoc.minimart.controller;

import baihoc.minimart.entity.Product;
import baihoc.minimart.entity.StockTransaction;
import java.util.List;

/**
 *
 * @author NGUYEN HUU
 */
public interface StockController {
    Product findProductById(int productID);
    boolean importStock(int productID, int quantity, String note);
    boolean exportStock(int productID, int quantity, String note);
    List<StockTransaction> getAllTransactions();
}
