/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.Voucher;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import ultis.DBConnect;

/**
 *
 * @author Duong
 */
public class QuanLyVoucherService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public QuanLyVoucherService() {
        con = DBConnect.getConnection();
    }

    public ArrayList<Voucher> getAllVoucher(int page) {
        ArrayList<Voucher> listVoucher = new ArrayList<>();

        // Set page size (e.g., 5 vouchers per page)
        int pageSize = 5;
        int offset = (page - 1) * pageSize; // Calculate the offset for pagination

        sql = "SELECT id, ma_voucher, ten_voucher, mo_ta, ngay_bat_dau, ngay_ket_thuc, giam_gia, giam_toi_da, don_toi_thieu, ngay_tao, ngay_sua, trang_thai "
                + "FROM voucher "
                + "ORDER BY id "
                + // You can modify the ordering as needed
                "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            pr = con.prepareStatement(sql);
            pr.setInt(1, offset);  // Set offset (starting row for pagination)
            pr.setInt(2, pageSize); // Set number of rows to fetch

            rs = pr.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String moTa = rs.getString(4);
                Date ngayBatDau = rs.getDate(5);
                Date ngayKetThuc = rs.getDate(6);
                int giamGia = rs.getInt(7);
                int giamToiDa = rs.getInt(8);
                int donToiThieu = rs.getInt(9);
                Date ngayTao = rs.getDate(10);
                Date ngaySua = rs.getDate(11);
                int trangThai = rs.getInt(12);

                Voucher v = new Voucher(id, ma, ten, moTa, ngayBatDau, ngayKetThuc, giamGia, giamToiDa, donToiThieu, ngayTao, ngaySua, trangThai);
                listVoucher.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listVoucher;
    }

    // Method to get the total number of pages for pagination
    public int getTotalPages() {
        int totalVouchers = 0;
        sql = "SELECT COUNT(*) FROM voucher";

        try {
            pr = con.prepareStatement(sql);
            rs = pr.executeQuery();
            if (rs.next()) {
                totalVouchers = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        int pageSize = 5; // Page size (same as in getAllVoucher)
        return (int) Math.ceil((double) totalVouchers / pageSize);
    }

    public int newVoucher(Voucher v) {
        sql = "INSERT INTO [dbo].[voucher] ([ma_voucher], [ten_voucher], [mo_ta], [ngay_bat_dau], [ngay_ket_thuc], [giam_gia], [giam_toi_da], [don_toi_thieu], [ngay_tao], [trang_thai]) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, v.getMaVoucher());
            pr.setObject(2, v.getTenVocher());
            pr.setObject(3, v.getMoTa());
            pr.setObject(4, v.getNgayBatDau());
            pr.setObject(5, v.getNgayKetThuc());
            pr.setObject(6, v.getGiamGia());
            pr.setObject(7, v.getGiamToiDa());
            pr.setObject(8, v.getDonToiThieu());
            pr.setObject(9, v.getNgayTao());
            pr.setObject(10, v.getTrangThai());
            return pr.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateVoucher(Voucher v, int id) {
        // Cập nhật câu lệnh SQL để khớp với số lượng tham số
        sql = "UPDATE [dbo].[voucher] SET [ma_voucher] = ?, [ten_voucher] = ?, [mo_ta] = ?, "
                + "[ngay_bat_dau] = ?, [ngay_ket_thuc] = ?, [giam_gia] = ?, [giam_toi_da] = ?, "
                + "[don_toi_thieu] = ?, [ngay_sua] = ?, [trang_thai] = ? WHERE [id] = ?";

        try {
            // Khởi tạo PreparedStatement và gán các tham số
            pr = con.prepareStatement(sql);
            pr.setObject(1, v.getMaVoucher());     // ma_voucher
            pr.setObject(2, v.getTenVocher());     // ten_voucher
            pr.setObject(3, v.getMoTa());          // mo_ta
            pr.setObject(4, v.getNgayBatDau());    // ngay_bat_dau
            pr.setObject(5, v.getNgayKetThuc());   // ngay_ket_thuc
            pr.setObject(6, v.getGiamGia());       // giam_gia
            pr.setObject(7, v.getGiamToiDa());     // giam_toi_da
            pr.setObject(8, v.getDonToiThieu());   // don_toi_thieu
            pr.setObject(9, v.getNgaySua());       // ngay_sua
            pr.setObject(10, v.getTrangThai());    // trang_thai
            pr.setObject(11, id);                  // id (sử dụng tham số thứ 11 cho id)

            // Thực thi câu lệnh SQL
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;  // Trả về 0 nếu có lỗi
        }
    }

    public int anVoucher(int id) {
        sql = "update [dbo].[voucher] set [trang_thai]=? where [id]=?";
        try {
            pr = con.prepareStatement(sql);
            pr.setObject(1, 0);
            pr.setObject(2, id);
            return pr.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean checkDuplicateMaVoucher(String maVoucher) {

        String sql = "SELECT COUNT(*) FROM voucher WHERE ma_voucher = ?";

        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setString(1, maVoucher);

            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {

                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public ArrayList<Voucher> searchVoucherByName(String tenVoucher) {
    ArrayList<Voucher> listVoucher = new ArrayList<>();
    
    sql = "SELECT id, ma_voucher, ten_voucher, mo_ta, ngay_bat_dau, ngay_ket_thuc, giam_gia, giam_toi_da, don_toi_thieu, ngay_tao, ngay_sua, trang_thai "
            + "FROM voucher "
            + "WHERE ten_voucher LIKE ?";  // Sử dụng LIKE để tìm kiếm theo tên

    try {
        pr = con.prepareStatement(sql);
        pr.setString(1, "%" + tenVoucher + "%"); // Thêm dấu % vào để tìm kiếm chuỗi con trong tên voucher

        rs = pr.executeQuery();
        while (rs.next()) {
            int id = rs.getInt(1);
            String ma = rs.getString(2);
            String ten = rs.getString(3);
            String moTa = rs.getString(4);
            Date ngayBatDau = rs.getDate(5);
            Date ngayKetThuc = rs.getDate(6);
            int giamGia = rs.getInt(7);
            int giamToiDa = rs.getInt(8);
            int donToiThieu = rs.getInt(9);
            Date ngayTao = rs.getDate(10);
            Date ngaySua = rs.getDate(11);
            int trangThai = rs.getInt(12);

            Voucher v = new Voucher(id, ma, ten, moTa, ngayBatDau, ngayKetThuc, giamGia, giamToiDa, donToiThieu, ngayTao, ngaySua, trangThai);
            listVoucher.add(v);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return listVoucher;
}
    
}
