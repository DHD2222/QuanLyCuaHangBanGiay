/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import Model.SPCT;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import ultis.DBConnect;


/**
 *
 * @author LAPTOP
 */
public class SPCTService {

    private Connection con = null;
    private PreparedStatement pr = null;
    private ResultSet rs = null;
    private String sql = null;

    public ArrayList<SPCT> getAllSanPhamCT(int page, int idSp) {
        ArrayList<SPCT> spctList = new ArrayList<>();
        int pageSize = 5;
        int offset = (page - 1) * pageSize;

        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
           + "spct.don_gia, spct.mo_ta, spct.trang_thai, spct.ngay_tao, spct.ngay_sua, "
           + "ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
           + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.ten_chuong_trinh_khuyen_mai ELSE NULL END AS ten_khuyen_mai, "
           + "sp.ten_san_pham "
           + "FROM san_pham_chi_tiet spct "
           + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "          // Join color table
           + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "    // Join size table
           + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "     // Join shoe type table
           + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id " // Join promotion table
           + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "       // Join product table
           + "WHERE spct.id_san_pham = ? "
           + "ORDER BY spct.id "
           + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";


        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setInt(1, idSp);        // Thiết lập tham số cho id_san_pham
            pr.setInt(2, offset);      // Thiết lập tham số cho offset
            pr.setInt(3, pageSize);    // Thiết lập tham số cho pageSize

            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                String tenChuongTinhKM = rs.getString("ten_khuyen_mai");
                String tenSanPham = rs.getString("ten_san_pham");

                SPCT spct = new SPCT(id, maSanPhamCT, soLuong, donGia, moTa, trangThai, ngayTao, ngaySua, tenMauSac, tenKichThuoc, tenLoaiDG, tenChuongTinhKM, tenSanPham);
                spctList.add(spct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spctList;
    }

    public SPCT findById(int id) {
        String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, spct.don_gia, spct.mo_ta, spct.trang_thai, spct.ngay_tao, spct.ngay_sua, "
                + "ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, km.ten_chuong_trinh_khuyen_mai, sp.ten_san_pham "
                + "FROM san_pham_chi_tiet spct "
                + "inner JOIN mau_sac ms ON spct.id_mau_sac = ms.id " // Join color table
                + "inner JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id " // Join size table
                + "inner JOIN loai_de_giay dg ON spct.id_de_giay = dg.id " // Join shoe type table
                + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id " // Join promotion table
                + "inner JOIN san_pham sp ON spct.id_san_pham = sp.id " // Join product table
                + "where spct.id = ?";

        SPCT spct = null;

        try {
            Connection con = DBConnect.getConnection();
            PreparedStatement pr = con.prepareStatement(sql);
            pr.setObject(1, id);

            ResultSet rs = pr.executeQuery();

            while (rs.next()) {
                int idpct = rs.getInt("id");
                String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
                int soLuong = rs.getInt("so_luong");
                float donGia = rs.getFloat("don_gia");
                String moTa = rs.getString("mo_ta");
                int trangThai = rs.getInt("trang_thai");
                Date ngayTao = rs.getDate("ngay_tao");
                Date ngaySua = rs.getDate("ngay_sua");
                String tenMauSac = rs.getString("ten_mau");
                String tenKichThuoc = rs.getString("ten_kich_thuoc");
                String tenLoaiDG = rs.getString("ten_de_giay");
                String tenChuongTinhKM = rs.getString("ten_chuong_trinh_khuyen_mai");
                String tenSanPham = rs.getString("ten_san_pham");

                spct = new SPCT(idpct, maSanPhamCT, soLuong, donGia, moTa, trangThai, ngayTao, ngaySua, tenMauSac, tenKichThuoc, tenLoaiDG, tenChuongTinhKM, tenSanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return spct;
    }

    public int getTotalPages(int id) {
        int totalProducts = 0;
        String sql = "SELECT COUNT(*) FROM san_pham_chi_tiet WHERE id_san_pham = ?";  // Sửa lại tên cột nếu cần

        try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {

            pr.setInt(1, id);  // Thiết lập giá trị tham số trước khi gọi executeQuery
            try (ResultSet rs = pr.executeQuery()) {
                if (rs.next()) {
                    totalProducts = rs.getInt(1);  // Lấy số lượng sản phẩm
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tính số trang tổng cộng (làm tròn lên nếu cần)
        int pageSize = 5;
        return (int) Math.ceil((double) totalProducts / pageSize);
    }

    public void addSanPhamCT(SPCT spct) {
        if (spct != null) {
            String sql = """
                         INSERT INTO [dbo].[san_pham_chi_tiet]
                                    ([ma_san_pham_chi_tiet]
                                    ,[so_luong]
                                    ,[don_gia]
                                    ,[mo_ta]
                                    ,[id_mau_sac]
                                    ,[id_kich_thuoc]
                                    ,[id_de_giay]
                                    ,[id_chuong_trinh_khuyen_mai]
                                    ,[id_san_pham]
                                    ,[ngay_tao]
                                    ,[ngay_sua]
                                    ,[trang_thai])
                              VALUES
                                    (?,?,?,?,?,?,?,?,?,?,?,?)
                         """;

            try {
                con = DBConnect.getConnection();
                pr = con.prepareStatement(sql);
                pr.setObject(1, spct.getMaSPCT());
                pr.setObject(2, spct.getSoLuong());
                pr.setObject(3, spct.getDonGia());
                pr.setObject(4, spct.getMoTa());
                pr.setObject(5, spct.getIdMauSac());
                pr.setObject(6, spct.getIdKichThuoc());
                pr.setObject(7, spct.getIdDegiay());
                pr.setObject(8, spct.getIdChuongTrinhKM());
                pr.setObject(9, spct.getIdSanPham());
                pr.setObject(10, spct.getNgayTao());
                pr.setObject(11, spct.getNgaySua());
                pr.setObject(12, spct.getTrangThai());
                pr.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }

    public void updateSanPhamCT(SPCT spct, Integer id) {
        if (spct != null) {
            String sql = """
                        UPDATE [dbo].[san_pham_chi_tiet]
                           SET [ma_san_pham_chi_tiet] = ?
                              ,[so_luong] = ?
                              ,[don_gia] = ?
                              ,[mo_ta] = ?
                              ,[id_mau_sac] =? 
                              ,[id_kich_thuoc] = ?
                              ,[id_de_giay] = ?
                              ,[id_chuong_trinh_khuyen_mai] = ?
                              ,[id_san_pham] = ?
                              ,[ngay_sua] = ?
                              ,[trang_thai] = ?
                         WHERE id = ?
                         """;

            try {
                con = DBConnect.getConnection();
                pr = con.prepareStatement(sql);
                pr.setObject(1, spct.getMaSPCT());
                pr.setObject(2, spct.getSoLuong());
                pr.setObject(3, spct.getDonGia());
                pr.setObject(4, spct.getMoTa());
                pr.setObject(5, spct.getIdMauSac());
                pr.setObject(6, spct.getIdKichThuoc());
                pr.setObject(7, spct.getIdDegiay());
                pr.setObject(8, spct.getIdChuongTrinhKM());
                pr.setObject(9, spct.getIdSanPham());
                pr.setObject(10, spct.getNgaySua());
                pr.setObject(11, spct.getTrangThai());
                pr.setObject(12, id);
                pr.executeUpdate();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }
    public boolean checktrungma(String maSanPhamCT) {
    String sql = "SELECT COUNT(*) FROM san_pham_chi_tiet WHERE ma_san_pham_chi_tiet = ?";
    try (Connection con = DBConnect.getConnection(); PreparedStatement pr = con.prepareStatement(sql)) {
        pr.setString(1, maSanPhamCT); 
        try (ResultSet rs = pr.executeQuery()) {
            if (rs.next()) {
                int count = rs.getInt(1);  
                return count > 0; 
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false; 
}
public ArrayList<SPCT> getAllSanPhamCT(int page, int idSp, Integer trangThai) {
    ArrayList<SPCT> spctList = new ArrayList<>();
    int pageSize = 5;
    int offset = (page - 1) * pageSize;

    // SQL query với điều kiện lọc trạng thái cho bảng san_pham_chi_tiet
    String sql = "SELECT spct.id, spct.ma_san_pham_chi_tiet, spct.so_luong, "
            + "spct.don_gia, spct.mo_ta, spct.trang_thai, spct.ngay_tao, spct.ngay_sua, "
            + "ms.ten_mau, kt.ten_kich_thuoc, dg.ten_de_giay, "
            + "CASE WHEN spct.id_chuong_trinh_khuyen_mai IS NOT NULL THEN km.ten_chuong_trinh_khuyen_mai ELSE NULL END AS ten_khuyen_mai, "
            + "sp.ten_san_pham "
            + "FROM san_pham_chi_tiet spct "
            + "INNER JOIN mau_sac ms ON spct.id_mau_sac = ms.id "          // Join color table
            + "INNER JOIN kich_thuoc kt ON spct.id_kich_thuoc = kt.id "    // Join size table
            + "INNER JOIN loai_de_giay dg ON spct.id_de_giay = dg.id "     // Join shoe type table
            + "LEFT JOIN chuong_trinh_khuyen_mai km ON spct.id_chuong_trinh_khuyen_mai = km.id " // Join promotion table
            + "INNER JOIN san_pham sp ON spct.id_san_pham = sp.id "       // Join product table
            + "WHERE spct.id_san_pham = ? ";

    // Thêm điều kiện lọc trạng thái vào SQL nếu có
    if (trangThai != null) {
        sql += " AND spct.trang_thai = ? ";
    }

    sql += "ORDER BY spct.id "
            + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

    try {
        Connection con = DBConnect.getConnection();
        PreparedStatement pr = con.prepareStatement(sql);
        pr.setInt(1, idSp);  // Thiết lập tham số cho id_san_pham

        // Thiết lập tham số cho trạng thái nếu có
        int paramIndex = 2;
        if (trangThai != null) {
            pr.setInt(paramIndex++, trangThai);
        }

        // Thiết lập tham số cho offset và pageSize
        pr.setInt(paramIndex++, offset);
        pr.setInt(paramIndex++, pageSize);

        ResultSet rs = pr.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String maSanPhamCT = rs.getString("ma_san_pham_chi_tiet");
            int soLuong = rs.getInt("so_luong");
            float donGia = rs.getFloat("don_gia");
            String moTa = rs.getString("mo_ta");
            int trangThaiResult = rs.getInt("trang_thai");
            Date ngayTao = rs.getDate("ngay_tao");
            Date ngaySua = rs.getDate("ngay_sua");
            String tenMauSac = rs.getString("ten_mau");
            String tenKichThuoc = rs.getString("ten_kich_thuoc");
            String tenLoaiDG = rs.getString("ten_de_giay");
            String tenChuongTinhKM = rs.getString("ten_khuyen_mai");
            String tenSanPham = rs.getString("ten_san_pham");

            SPCT spct = new SPCT(id, maSanPhamCT, soLuong, donGia, moTa, trangThaiResult, ngayTao, ngaySua, tenMauSac, tenKichThuoc, tenLoaiDG, tenChuongTinhKM, tenSanPham);
            spctList.add(spct);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return spctList;
}
}
