/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baihoc.minimart.dao;

import baihoc.minimart.entity.PendingUser;

/**
 *
 * @author NGUYEN HUU
 */
public interface PendingUserDao {
    boolean insert(PendingUser user);
    PendingUser findByUsername(String username);
    boolean delete(String username);

     void save(PendingUser pendingUser);
}
