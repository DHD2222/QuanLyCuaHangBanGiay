/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Model.ChuongTrinhKhuyenMai;
import Model.KichThuoc;
import Model.LoaiDeGiay;
import Model.MauSac;
import Model.SPCT;
import Service.KichThuocService;
import Service.LoaiDeGiayService;
import Service.MauSacService;
import Service.QLSPService;
import Service.QuanLyChuongTrinhService;
import Service.SPCTService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author LAPTOP
 */
public class ViewSanPhamChiTiet extends javax.swing.JFrame {

    private DefaultTableModel mol = new DefaultTableModel();
    private SPCTService service = new SPCTService();
    private MauSacService sacService = new MauSacService();
    private KichThuocService thuocService = new KichThuocService();
    private LoaiDeGiayService deGiayService = new LoaiDeGiayService();
    private QuanLyChuongTrinhService kMService = new QuanLyChuongTrinhService();
    private QLSPService sanPhamService = new QLSPService();
    private int i = -1;
    private int currentPage = 1;// Trang hiện tại
    private int numberPage;
    private int limit = 5;
    private int check = 0;
    private int idSp;

    /**
     * Creates new form DemoSPCT
     */
    public ViewSanPhamChiTiet(java.awt.Frame parent, boolean modal) {
        initComponents();
        fillTable(currentPage);
        this.findComboboxKichThuoc();
        this.findComboboxLoaiDeGiay();
        this.findComboboxMauSac();
        this.findComboboxKhuyenMai();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public ViewSanPhamChiTiet(java.awt.Frame parent, boolean modal, int idSp) {
        this(parent, modal);
        this.idSp = idSp;
        this.fillTable(currentPage);
          setLocationRelativeTo(null);
          tblSPCT.setRowHeight(30);
    }

    private ViewSanPhamChiTiet() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void getPage(List<SPCT> list) {
        if (list.size() % limit == 0) {
            numberPage = list.size() / limit;
        } else {
            numberPage = (list.size() / limit) + 1;
        }

        lblPage.setText("1");
    }

    void fillTable(int page) {
        ArrayList<SPCT> list = service.getAllSanPhamCT(page, idSp);
        this.getPage(list);
        mol = (DefaultTableModel) tblSPCT.getModel();
        mol.setRowCount(0); // Xóa dữ liệu cũ trong bảng

        // Thêm các dòng mới vào bảng
        for (SPCT sanPhamCT : list) {
            mol.addRow(sanPhamCT.toDataRow());
        }
    }

    private void findComboboxMauSac() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboMauSac.getModel();
        boxModel.removeAllElements();

        List<MauSac> ms = sacService.getAllMauSac();
        for (MauSac mauSac : ms) {
            boxModel.addElement(mauSac.getTenMauSac());
        }
    }

    private void findComboboxKichThuoc() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboSize.getModel();
        boxModel.removeAllElements();

        List<KichThuoc> kt = thuocService.getAllKichThuoc();
        for (KichThuoc kichThuoc : kt) {
            boxModel.addElement(kichThuoc.getTenKichThuoc());
        }
    }

    private void findComboboxLoaiDeGiay() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboLoaidegiay.getModel();
        boxModel.removeAllElements();

        List<LoaiDeGiay> giay = deGiayService.getAllLoaiDeGiay();
        for (LoaiDeGiay deGiay : giay) {
            boxModel.addElement(deGiay.getTenLoaiDeGiay());
        }
    }

    private void findComboboxKhuyenMai() {
        DefaultComboBoxModel boxModel = (DefaultComboBoxModel) cboKhuyenMai.getModel();

        List<ChuongTrinhKhuyenMai> khuyenMai = kMService.getAllChuongTrinhKM();
        for (ChuongTrinhKhuyenMai chuongTrinhKM : khuyenMai) {
            boxModel.addElement(chuongTrinhKM.getTenChuongTrinh());
        }
    }

    void showData(SPCT spct) {
        lblid.setText(String.valueOf(spct.getId()));
        txtMaSPCT.setText(spct.getMaSPCT());
        txtSoLuong.setText(String.valueOf(spct.getSoLuong()));
        txtDonGia.setText(String.valueOf(spct.getDonGia()));
        txtMota.setText(spct.getMoTa());
        txtTenSP.setText(spct.getTenSanPham());
        cboLoaidegiay.setSelectedItem(spct.getTendeGiay());
        cboMauSac.setSelectedItem(spct.getTenMau());
        cboSize.setSelectedItem(spct.getTenkichThuoc());
        cboKhuyenMai.setSelectedItem(spct.getTenCTKM());
        if (spct.getTrangThai() == 1) {
            rdoConhang.setSelected(true);
        } else {
            rdoHethang.setSelected(true);
        }
    }

    private void editForm() {
        Integer id = (Integer) tblSPCT.getValueAt(i, 0);
        SPCT spct = service.findById(id);
        this.showData(spct);
    }

    private boolean validateInput() {
        // Kiểm tra mã sản phẩm chi tiết
        String maSanphamct = txtMaSPCT.getText().trim();
        if (maSanphamct.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm chi tiết không được để trống!");
            return false;
        }

        // Kiểm tra số lượng
        int soLuong = 0;
        try {
            soLuong = Integer.parseInt(txtSoLuong.getText().trim());
            if (soLuong <= 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên dương!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ!");
            return false;
        }

        // Kiểm tra đơn giá
        float donGia = 0;
        try {
            donGia = Float.parseFloat(txtDonGia.getText().trim());
            if (donGia <= 0) {
                JOptionPane.showMessageDialog(this, "Đơn giá phải là số thực dương!");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Đơn giá không hợp lệ!");
            return false;
        }

        // Kiểm tra mô tả
        String mota = txtMota.getText().trim();
        if (mota.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Mô tả không được để trống!");
            return false;
        }

        // Kiểm tra các lựa chọn từ ComboBox
        String tenMau = (String) cboMauSac.getSelectedItem();
        if (tenMau == null || tenMau.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn màu sắc!");
            return false;
        }
        MauSac ms = sacService.getTenMauSac(tenMau);
        int idMauSac = ms.getId();

        String tenKichthuoc = (String) cboSize.getSelectedItem();
        if (tenKichthuoc == null || tenKichthuoc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn kích thước!");
            return false;
        }
        KichThuoc kt = thuocService.getTenKichThuoc(tenKichthuoc);
        int idKichThuoc = kt.getId();

        String tenDeGiay = (String) cboLoaidegiay.getSelectedItem();
        if (tenDeGiay == null || tenDeGiay.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn loại đế giày!");
            return false;
        }
        LoaiDeGiay dg = deGiayService.getTenDeGiay(tenDeGiay);
        int idDeGiay = dg.getId();

        String tenChuongTrinhKM = (String) cboKhuyenMai.getSelectedItem();
        ChuongTrinhKhuyenMai km = kMService.getTenChuongTrinhKM(tenChuongTrinhKM);
        Integer idChuongtrinhKM;
        if (cboKhuyenMai.getSelectedIndex() == 0) {
            idChuongtrinhKM = null;
        } else {
            idChuongtrinhKM = km.getId();
        }
        
        // Kiểm tra trạng thái
        Integer trangThai = rdoConhang.isSelected() ? 1 : 0;

        // Giá trị idSanPham có thể lấy từ đâu đó, ví dụ từ form hoặc hệ thống.
        Integer idSanPham = idSp; // Bạn cần xử lý sao cho đúng

        // Tạo và trả về đối tượng SPCT nếu tất cả kiểm tra hợp lệ
        SPCT spct = new SPCT(maSanphamct, soLuong, donGia, mota, trangThai, new Date(), null, idMauSac, idKichThuoc, idDeGiay, idChuongtrinhKM, idSanPham);
        return true;
    }

    private SPCT getData() {

        if (!validateInput()) {
            return null;
        }
        String maSanphamct = txtMaSPCT.getText();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        float donGia = Float.parseFloat(txtDonGia.getText());
        String mota = txtMota.getText();

        String tenMau = (String) cboMauSac.getSelectedItem();
        MauSac ms = sacService.getTenMauSac(tenMau);
        int idMauSac = ms.getId();

        String tenKichthuoc = (String) cboSize.getSelectedItem();
        KichThuoc kt = thuocService.getTenKichThuoc(tenKichthuoc);
        System.out.println(kt.getId());
        int idKichThuoc = kt.getId();

        String tenDeGiay = (String) cboLoaidegiay.getSelectedItem();
        LoaiDeGiay dg = deGiayService.getTenDeGiay(tenDeGiay);
        int idDeGiay = dg.getId();

        String tenChuongTrinhKM = (String) cboKhuyenMai.getSelectedItem();
        ChuongTrinhKhuyenMai km = kMService.getTenChuongTrinhKM(tenChuongTrinhKM);
        Integer idChuongtrinhKM;
        if (cboKhuyenMai.getSelectedIndex() == 0) {
            idChuongtrinhKM = null;
        } else {
            idChuongtrinhKM = km.getId();
        }

        String tenSanPham = txtTenSP.getText();

        Date ngayTao = new Date();
        Integer trangThai = rdoConhang.isSelected() ? 1 : 0;

        Integer idSanPham = idSp;
        SPCT spct = new SPCT(maSanphamct, soLuong, donGia, mota, trangThai, ngayTao, null, idMauSac, idKichThuoc, idDeGiay, idChuongtrinhKM, idSanPham);

        return spct;
    }
      private SPCT getDataNgaySua() {

        if (!validateInput()) {
            return null;
        }
        String maSanphamct = txtMaSPCT.getText();
        int soLuong = Integer.parseInt(txtSoLuong.getText());
        float donGia = Float.parseFloat(txtDonGia.getText());
        String mota = txtMota.getText();

        String tenMau = (String) cboMauSac.getSelectedItem();
        MauSac ms = sacService.getTenMauSac(tenMau);
        int idMauSac = ms.getId();

        String tenKichthuoc = (String) cboSize.getSelectedItem();
        KichThuoc kt = thuocService.getTenKichThuoc(tenKichthuoc);
        System.out.println(kt.getId());
        int idKichThuoc = kt.getId();

        String tenDeGiay = (String) cboLoaidegiay.getSelectedItem();
        LoaiDeGiay dg = deGiayService.getTenDeGiay(tenDeGiay);
        int idDeGiay = dg.getId();

        String tenChuongTrinhKM = (String) cboKhuyenMai.getSelectedItem();
        ChuongTrinhKhuyenMai km = kMService.getTenChuongTrinhKM(tenChuongTrinhKM);
        Integer idChuongtrinhKM;
        if (cboKhuyenMai.getSelectedIndex() == 0) {
            idChuongtrinhKM = null;
        } else {
            idChuongtrinhKM = km.getId();
        }

        String tenSanPham = txtTenSP.getText();

        LocalDateTime ldt = LocalDateTime.now();
        Date ngaySua = java.sql.Timestamp.valueOf(ldt);
        Integer trangThai = rdoConhang.isSelected() ? 1 : 0;

        Integer idSanPham = idSp;
        SPCT spct = new SPCT(maSanphamct, soLuong, donGia, mota, trangThai,  ngaySua, idMauSac, idKichThuoc, idDeGiay, idChuongtrinhKM, idSanPham);

        return spct;
    }

    private void insert() {
        if (service.checktrungma(txtMaSPCT.getText())) {
                JOptionPane.showMessageDialog(this, "Mã sản phẩm chi tiết mãi đã tồn tại! Vui lòng chọn mã khác.");
                txtMaSPCT.requestFocus();
                return;
            }
        check = JOptionPane.showConfirmDialog(this, "Xác nhận thêm dữ liệu?");
        if (check != JOptionPane.YES_OPTION) {
             if (check != JOptionPane.YES_OPTION) {
           return;
        }
         
        }

        try {
            SPCT spct = this.getData();

            if (spct == null) {
                return;
            }

            service.addSanPhamCT(spct);
            this.fillTable(currentPage);
            JOptionPane.showMessageDialog(this, "Insert dữ liệu thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    private void insertUpdate() {
        check = JOptionPane.showConfirmDialog(this, "Xác nhận sửa dữ liệu?");
       

        try {
            SPCT sp = this.getDataNgaySua();

            if (sp == null) {
                return;
            }

            Integer id = Integer.valueOf(lblid.getText());
            service.updateSanPhamCT(getDataNgaySua(), id);
            this.fillTable(currentPage);
            JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rdoConhang = new javax.swing.JRadioButton();
        rdoHethang = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMota = new javax.swing.JTextArea();
        txtTenSP = new javax.swing.JTextField();
        txtMaSPCT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtSoLuong = new javax.swing.JTextField();
        cboSize = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLammoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSPCT = new javax.swing.JTable();
        btnPrev = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        btnStrat = new javax.swing.JButton();
        btnNect = new javax.swing.JButton();
        btnEnd = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cboLoaidegiay = new javax.swing.JComboBox<>();
        cboKhuyenMai = new javax.swing.JComboBox<>();
        lblid = new javax.swing.JLabel();
        btnsize = new javax.swing.JButton();
        btnmausac = new javax.swing.JButton();
        btnloaidegiay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 251, 246));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản Lí Sản Phẩm Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel2.setText("Tên sản phẩm:");

        jLabel3.setText("Id SPCT:");

        jLabel4.setText("Mã SPCT:");

        jLabel5.setText("Trạng Thái:");

        jLabel6.setText("Mô tả:");

        buttonGroup1.add(rdoConhang);
        rdoConhang.setSelected(true);
        rdoConhang.setText("Còn hàng");
        rdoConhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoConhangActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoHethang);
        rdoHethang.setText("Hết hàng");
        rdoHethang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHethangActionPerformed(evt);
            }
        });

        txtMota.setColumns(20);
        txtMota.setRows(5);
        jScrollPane1.setViewportView(txtMota);

        txtTenSP.setEnabled(false);
        txtTenSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSPActionPerformed(evt);
            }
        });

        jLabel7.setText("Đơn giá:");

        jLabel8.setText("Số lượng:");

        jLabel9.setText("Size:");

        jLabel10.setText("Màu sắc:");

        jLabel11.setText("Khuyến mại:");

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboMauSac.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThem.setBackground(new java.awt.Color(255, 255, 204));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThem.setText("Thêm");
        btnThem.setPreferredSize(new java.awt.Dimension(75, 25));
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 204));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnSua.setText("Sửa");
        btnSua.setPreferredSize(new java.awt.Dimension(75, 25));
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLammoi.setBackground(new java.awt.Color(255, 255, 204));
        btnLammoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnLammoi.setText("Làm mới");
        btnLammoi.setPreferredSize(new java.awt.Dimension(75, 25));
        btnLammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(btnLammoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(41, 41, 41))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLammoi, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách sản phẩm chi tiết"));

        tblSPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id sản phẩm chi tiết", "Mã SPCT", "Số lượng", "Đơn giá", "Mô tả", "Ngày sửa", "Ngày tạo", "Trạng thái", "Màu sắc", "Kích thước", "Loại đế giày", "Khuyến mại", "Tên sản phẩm"
            }
        ));
        tblSPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSPCT);

        btnPrev.setBackground(new java.awt.Color(255, 255, 204));
        btnPrev.setText("<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        lblPage.setText("Số trang SPCT");

        btnStrat.setBackground(new java.awt.Color(255, 255, 204));
        btnStrat.setText("|<");
        btnStrat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStratActionPerformed(evt);
            }
        });

        btnNect.setBackground(new java.awt.Color(255, 255, 204));
        btnNect.setText(">");
        btnNect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNectActionPerformed(evt);
            }
        });

        btnEnd.setBackground(new java.awt.Color(255, 255, 204));
        btnEnd.setText(">|");
        btnEnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(414, 414, 414)
                .addComponent(btnStrat)
                .addGap(28, 28, 28)
                .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnNect, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnEnd)
                .addGap(0, 375, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrev)
                    .addComponent(lblPage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStrat)
                    .addComponent(btnNect)
                    .addComponent(btnEnd))
                .addContainerGap())
        );

        jLabel13.setText("Loại đế giày:");

        cboLoaidegiay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cboKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khuyến Mãi" }));
        cboKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboKhuyenMaiActionPerformed(evt);
            }
        });

        lblid.setText("ID");

        btnsize.setBackground(new java.awt.Color(153, 255, 153));
        btnsize.setText("+");
        btnsize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsizeActionPerformed(evt);
            }
        });

        btnmausac.setBackground(new java.awt.Color(153, 255, 153));
        btnmausac.setText("+");
        btnmausac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmausacActionPerformed(evt);
            }
        });

        btnloaidegiay.setBackground(new java.awt.Color(153, 255, 153));
        btnloaidegiay.setText("+");
        btnloaidegiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloaidegiayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblid, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                            .addComponent(txtMaSPCT, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdoConhang)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdoHethang))
                            .addComponent(txtTenSP, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnsize, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(btnmausac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnloaidegiay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel13))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtDonGia)
                    .addComponent(txtSoLuong)
                    .addComponent(cboSize, 0, 248, Short.MAX_VALUE)
                    .addComponent(cboMauSac, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboLoaidegiay, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboKhuyenMai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(99, 99, 99)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(232, 232, 232)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cboLoaidegiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnloaidegiay)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnsize))
                                .addGap(29, 29, 29)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmausac)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblid)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtMaSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoConhang)
                                    .addComponent(jLabel5)
                                    .addComponent(rdoHethang))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cboKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStratActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStratActionPerformed

        currentPage = 1;  // Set the page to 1 (start)
        fillTable(currentPage); // Update the table with the first page of data
        lblPage.setText("" + currentPage);
    }//GEN-LAST:event_btnStratActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if (currentPage > 1) {
            currentPage--; // Giảm trang
            fillTable(currentPage);
            lblPage.setText("" + currentPage);// Cập nhật bảng với dữ liệu của trang trước
        }
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnNectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNectActionPerformed
        // TODO add your handling code here:
        int totalPages = service.getTotalPages(idSp);
        if (currentPage < totalPages) {
            currentPage++; // Tăng trang
            fillTable(currentPage);
            lblPage.setText("" + currentPage);
        }
    }//GEN-LAST:event_btnNectActionPerformed

    private void btnEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEndActionPerformed
        // TODO add your handling code here:
        int totalPages = service.getTotalPages(idSp);  // Get the total number of pages
        currentPage = totalPages;  // Set the page to the last page
        fillTable(currentPage); // Update the table with the last page of data
        lblPage.setText("" + currentPage);
    }//GEN-LAST:event_btnEndActionPerformed

    private void tblSPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPCTMouseClicked
        // TODO add your handling code here:
        this.i = tblSPCT.getSelectedRow();
        this.editForm();
             txtMaSPCT.setEnabled(false);
    }//GEN-LAST:event_tblSPCTMouseClicked

    private void btnLammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLammoiActionPerformed
        // TODO add your handling code here:
        lblid.setText("");
        txtMaSPCT.setText("");
        txtSoLuong.setText("");
        txtDonGia.setText("");
        txtMota.setText("");
        cboMauSac.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboLoaidegiay.setSelectedIndex(0);
        cboKhuyenMai.setSelectedIndex(0);
        txtTenSP.setText("");
        buttonGroup1.clearSelection();
        txtMaSPCT.setEnabled(true);
        rdoConhang.setSelected(true);
    }//GEN-LAST:event_btnLammoiActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtTenSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSPActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        this.insertUpdate();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void rdoHethangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHethangActionPerformed
        // TODO add your handling code here:
        loadtrangthai(0);
    }//GEN-LAST:event_rdoHethangActionPerformed

    private void cboKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboKhuyenMaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboKhuyenMaiActionPerformed

    private void btnsizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsizeActionPerformed
        // TODO add your handling code here:
           ViewKichThuoc br = new ViewKichThuoc();
            br.setVisible(true);
            br.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnsizeActionPerformed

    private void btnmausacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmausacActionPerformed
        // TODO add your handling code here:
        ViewMauSac br = new ViewMauSac();
            br.setVisible(true);
            br.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnmausacActionPerformed

    private void btnloaidegiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloaidegiayActionPerformed
        // TODO add your handling code here:
         ViewLoaiDeGiay br = new ViewLoaiDeGiay();
            br.setVisible(true);
            br.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnloaidegiayActionPerformed
private void loadtrangthai(int trangThai) {
    
    ArrayList<SPCT> spctList = service.getAllSanPhamCT(1, 1, trangThai); // 1 là ID sản phẩm, trạng thái là tham số lọc

    
    DefaultTableModel model = (DefaultTableModel) tblSPCT.getModel();
    model.setRowCount(0); // Xóa hết dữ liệu cũ

    for (SPCT spct : spctList) {
        model.addRow(new Object[]{
            spct.getId(), 
            spct.getMaSPCT(),
            spct.getSoLuong(),
            spct.getDonGia(),
            spct.getMoTa(),
            spct.getTrangThai() == 1 ? "Còn hàng" : "Hết hàng",  // Dùng "Còn hàng" và "Hết hàng" để hiển thị
            spct.getNgayTao(),
            spct.getNgaySua(),
            spct.getTenMau(),
            spct.getTenkichThuoc(),
            spct.getTendeGiay(),
            spct.getTenCTKM(),
            spct.getTenSanPham()
        });
    }
}
    private void rdoConhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoConhangActionPerformed
        // TODO add your handling code here:
        loadtrangthai(1);
    }//GEN-LAST:event_rdoConhangActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewSanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSanPhamChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSanPhamChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnd;
    private javax.swing.JButton btnLammoi;
    private javax.swing.JButton btnNect;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnStrat;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnloaidegiay;
    private javax.swing.JButton btnmausac;
    private javax.swing.JButton btnsize;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboKhuyenMai;
    private javax.swing.JComboBox<String> cboLoaidegiay;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblPage;
    private javax.swing.JLabel lblid;
    private javax.swing.JRadioButton rdoConhang;
    private javax.swing.JRadioButton rdoHethang;
    private javax.swing.JTable tblSPCT;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtMaSPCT;
    private javax.swing.JTextArea txtMota;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
}
