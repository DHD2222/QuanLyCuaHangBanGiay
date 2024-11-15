/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ultis.DBConnect;

/**
 *
 * @author Admin
 */
public class ServiceLoGin {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public int login(String username, String password, String role) {
        try {
            con = DBConnect.getConnection(); // Kết nối cơ sở dữ liệu
            sql = "SELECT trang_thai FROM nhan_vien WHERE ten_dang_nhap = ? AND mat_khau = ? AND vai_tro = ?";
            pr = con.prepareStatement(sql);
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setString(3, role);
            rs = pr.executeQuery();

            if (rs.next()) {
                int status = rs.getInt("trang_thai");
                if (status == 1) {
                    return 1; 
                } else {
                    return 2; 
                }
            } else {
                return 3; 
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 4; 
        }
    }
}
