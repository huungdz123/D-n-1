/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package baihoc.minimart.controller;

/**
 *
 * @author NGUYEN HUU
 */
public interface PendingUserControler {
    boolean handleRegister(String username, String password, String fullname);
     boolean verifyOtp(String username, String inputOtp);
}
