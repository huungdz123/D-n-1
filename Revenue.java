/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baihoc.minimart.entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;
/**
 *
 * @author ADMIN
 */
public class Revenue {
     @lombok.AllArgsConstructor
    @lombok.NoArgsConstructor
    @lombok.Builder
    @lombok.Data
    public static class ByCategory {
        private String category;
        private double revenue;
        private int quantity;
        private double minPrice;
        private double maxPrice;
        private double avgPrice;
    }

    @lombok.AllArgsConstructor
    @lombok.NoArgsConstructor
    @lombok.Builder
    @lombok.Data
    public static class ByCustomer {
        private String customerName;
        private String phone;
        private double revenue;
        private int totalInvoices;
        private Date lastPurchaseDate;
    }
}
