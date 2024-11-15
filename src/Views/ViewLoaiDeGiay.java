/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Views;

import Model.LoaiDeGiay;
import Service.LoaiDeGiayService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Duong
 */
public class ViewLoaiDeGiay extends javax.swing.JFrame {

    private LoaiDeGiayService qlldg = new LoaiDeGiayService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private int index = -1;

    /**
     * Creates new form ViewLoaiDeGiay
     */
    public ViewLoaiDeGiay() {
        initComponents();
        fillTable(qlldg.getALLLoaiDeGiay());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaLoaiDeGiay = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTenLoaiGiay = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoHoatDong = new javax.swing.JRadioButton();
        rdoDungHoatDong = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBangLoaiDeGiay = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnLamMoiBang = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtChieuCao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại Đế Giày", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel2.setText("ID loại đế giày:");

        lblId.setText("ID");

        jLabel4.setText("Mã loại đế giày:");

        txtMaLoaiDeGiay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaLoaiDeGiayActionPerformed(evt);
            }
        });

        jLabel5.setText("Tên loại đế giày:");

        jLabel6.setText("Trạng thái:");

        buttonGroup1.add(rdoHoatDong);
        rdoHoatDong.setSelected(true);
        rdoHoatDong.setText("Hoat dong");
        rdoHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoHoatDongActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoDungHoatDong);
        rdoDungHoatDong.setText("Dung hoat dong");
        rdoDungHoatDong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDungHoatDongActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btnThem.setBackground(new java.awt.Color(255, 255, 204));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setBackground(new java.awt.Color(255, 255, 204));
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(255, 255, 204));
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách loại đế giày"));

        tblBangLoaiDeGiay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã loại đế giày", "Tên loại đế giày", "Chiều cao", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ));
        tblBangLoaiDeGiay.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBangLoaiDeGiayMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblBangLoaiDeGiay);

        btnTimKiem.setBackground(new java.awt.Color(255, 255, 204));
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        btnLamMoiBang.setBackground(new java.awt.Color(255, 255, 204));
        btnLamMoiBang.setText("Làm mới");
        btnLamMoiBang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiBangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem)
                .addGap(18, 18, 18)
                .addComponent(btnLamMoiBang)
                .addGap(9, 9, 9))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem)
                    .addComponent(btnLamMoiBang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel7.setText("Chiều cao:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblId)
                                    .addComponent(txtMaLoaiDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoHoatDong)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoDungHoatDong))))
                            .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(lblId)
                            .addComponent(jLabel5)
                            .addComponent(txtTenLoaiGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaLoaiDeGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(rdoHoatDong)
                            .addComponent(rdoDungHoatDong))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtChieuCao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void loadTrangThai(int trangThai) {
        ArrayList<LoaiDeGiay> loaiDeGiayList = qlldg.getLoaiDeGiayByStatus(trangThai);

        DefaultTableModel model = (DefaultTableModel) tblBangLoaiDeGiay.getModel();
        model.setRowCount(0);
     fillTable(loaiDeGiayList);
      
    }
    private void rdoHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoHoatDongActionPerformed
        // TODO add your handling code here:
        loadTrangThai(1);
    }//GEN-LAST:event_rdoHoatDongActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateForm()) { // Kiểm tra tính hợp lệ của form

            // Lấy mã loại đế giày từ form
            String maDeGiay = txtMaLoaiDeGiay.getText();

            if (qlldg.checkDuplicateMaLoaiDeGiay(maDeGiay)) {
                JOptionPane.showMessageDialog(this, "Mã loại đế giày đã tồn tại! Vui lòng chọn mã khác.");
                txtMaLoaiDeGiay.requestFocus();
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this,
                    "Bạn có chắc chắn muốn thêm loại đế giày này?",
                    "Xác nhận",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {

                qlldg.newLoaiDeGiay(readForm());

                fillTable(qlldg.getALLLoaiDeGiay());

                JOptionPane.showMessageDialog(this, "Loại đế giày đã được thêm thành công!");
            } else {

                JOptionPane.showMessageDialog(this, "Thêm loại đế giày bị hủy.");
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
      if (index >= 0) {
            if (!validateForm()) {
                return;
            }
            int check = JOptionPane.showConfirmDialog(this, "Xác nhận sửa dữ liệu?");
            if (check != JOptionPane.YES_OPTION) {
                return;
            }
            
            try {
                LoaiDeGiay nv = readForm1();
                
                if (nv == null) {
                    return;
                }
                
                Integer id = Integer.valueOf(lblId.getText());
                
                qlldg.updateLoaiDeGiay(readForm1(), id);
                this.fillTable(qlldg.getALLLoaiDeGiay());
                JOptionPane.showMessageDialog(this, "Sửa dữ liệu thành công!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Lỗi truy vấn dữ liệu!");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hay chon doi tuong");
        }
                 
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        clear();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String tk = txtTimKiem.getText();
        if (tk.isBlank()) {
            JOptionPane.showMessageDialog(this, "Dien ten de giay de tim kiem");
        } else {
            fillTable(qlldg.SearchLoaiDeGiay(tk));
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnLamMoiBangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiBangActionPerformed
        fillTable(qlldg.getALLLoaiDeGiay());
        index = -1;
    }//GEN-LAST:event_btnLamMoiBangActionPerformed

    private void txtMaLoaiDeGiayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaLoaiDeGiayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaLoaiDeGiayActionPerformed

    private void tblBangLoaiDeGiayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBangLoaiDeGiayMouseClicked
        index = tblBangLoaiDeGiay.getSelectedRow();
        fillForm(index);
    }//GEN-LAST:event_tblBangLoaiDeGiayMouseClicked

    private void rdoDungHoatDongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDungHoatDongActionPerformed
        // TODO add your handling code here:
        loadTrangThai(0);
    }//GEN-LAST:event_rdoDungHoatDongActionPerformed

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
            java.util.logging.Logger.getLogger(ViewLoaiDeGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewLoaiDeGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewLoaiDeGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewLoaiDeGiay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewLoaiDeGiay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiBang;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblId;
    private javax.swing.JRadioButton rdoDungHoatDong;
    private javax.swing.JRadioButton rdoHoatDong;
    private javax.swing.JTable tblBangLoaiDeGiay;
    private javax.swing.JTextField txtChieuCao;
    private javax.swing.JTextField txtMaLoaiDeGiay;
    private javax.swing.JTextField txtTenLoaiGiay;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void fillTable(ArrayList<LoaiDeGiay> allLoaiDeGiay) {
        dtm = (DefaultTableModel) tblBangLoaiDeGiay.getModel();
        dtm.setRowCount(0);
        for (LoaiDeGiay l : allLoaiDeGiay) {
            dtm.addRow(new Object[]{l.getId(), l.getMaLoaiDeGiay(), l.getTenLoaiDeGiay(), l.getChieuCaoDe(), l.getNgayTao(), l.getNgaySua(), l.getTrangThai() == 1 ? "Hoat dong" : "Dung hoat dong"});
        }
    }

    private void fillForm(int index) {
        lblId.setText(tblBangLoaiDeGiay.getValueAt(index, 0).toString());
        txtMaLoaiDeGiay.setText(tblBangLoaiDeGiay.getValueAt(index, 1).toString());
        txtTenLoaiGiay.setText(tblBangLoaiDeGiay.getValueAt(index, 2).toString());
        txtChieuCao.setText(tblBangLoaiDeGiay.getValueAt(index, 3).toString());
        if (tblBangLoaiDeGiay.getValueAt(index, 6).equals("Hoat dong")) {
            rdoHoatDong.setSelected(true);
        } else {
            rdoDungHoatDong.setSelected(true);
        }
    }

    private LoaiDeGiay readForm() {
        int a;
        LocalDateTime ldt = LocalDateTime.now();
        Date ngayTao = java.sql.Timestamp.valueOf(ldt);
        if (rdoHoatDong.isSelected()) {
            a = 1;
        } else {
            a = 0;
        }
        return new LoaiDeGiay(txtMaLoaiDeGiay.getText(), txtTenLoaiGiay.getText(), Float.parseFloat(txtChieuCao.getText()), ngayTao, a);
    }

    private LoaiDeGiay readForm1() {
        int a;
        LocalDateTime ldt = LocalDateTime.now();
        Date ngaySua = java.sql.Timestamp.valueOf(ldt);
        if (rdoHoatDong.isSelected()) {
            a = 1;
        } else {
            a = 0;
        }
        return new LoaiDeGiay(txtMaLoaiDeGiay.getText(), txtTenLoaiGiay.getText(), Float.parseFloat(txtChieuCao.getText()), a, ngaySua);
    }

    private void clear() {
        lblId.setText("ID");
        txtMaLoaiDeGiay.setText("");
        txtTenLoaiGiay.setText("");
        txtChieuCao.setText("");
        rdoHoatDong.setSelected(true);
        index = -1;
    }

    private boolean validateForm() {
        if (txtMaLoaiDeGiay.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống mã loại đế giầy");
            return false;
        }
        if (txtTenLoaiGiay.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống tên loại đế giầy");
            return false;
        }
        if (txtChieuCao.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Không được để trống nguồn gốc loại đế giầy");
            return false;
        }
        try {
            Float.valueOf(txtChieuCao.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Chiều cao phải là số");
            return false;
        }
        return true;
    }
}
