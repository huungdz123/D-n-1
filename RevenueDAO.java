/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baihoc.minimart.dao;

import baihoc.minimart.entity.Revenue;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public interface RevenueDAO {
     List<Revenue.ByCategory> getByCategory(Date begin, Date end);
    List<Revenue.ByCustomer> getByCustomer(Date begin, Date end);
}
