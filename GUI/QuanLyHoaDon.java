/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusHoaDon;
import BUS.Services.BusImeiService;
import BUS.Services.CTHoaDonService;
import BUS.Services.HoaDonService;
import BUS.Services.SanPhamService;
import DAL.Models.DalImeiModel;
import GUI.Models.CartModel;
import static GUI.QuanLyBanHang.currentMahd;
import GUI.Services.AuthService;
import GUI.Services.DateService;
import GUI.Services.MessageService;
import GUI.Services.UtilityService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLyHoaDon extends javax.swing.JInternalFrame {

    Icon iconBackUp = new ImageIcon(getClass().getResource("/icon/curve-arrow.png"));
    Icon iconDelete = new ImageIcon(getClass().getResource("/icon/bin.png"));
    CTHoaDonService cTHoaDonService = new CTHoaDonService();

    public QuanLyHoaDon() {
        initComponents();
        initComponents();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension d = t.getScreenSize();
        int h = d.height;
        int w = d.width;
        this.setSize(w, h);

        desginTable();
        this.init();
    }

    public void desginTable() {
        tblHoaDon.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblHoaDon.getTableHeader().setOpaque(false);
        tblHoaDon.getTableHeader().setBackground(new Color(25, 29, 74));
        tblHoaDon.getTableHeader().setForeground(Color.WHITE);
        tblHoaDon.setGridColor(new Color(25,29,74));
         tblHoaDon.setSelectionBackground(new Color(38,117,191));
      tblHoaDon.setShowGrid(true);
        tblImei.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblImei.getTableHeader().setOpaque(false);
        tblImei.getTableHeader().setBackground(new Color(25, 29, 74));
        tblImei.getTableHeader().setForeground(Color.WHITE);
         tblImei.setGridColor(new Color(25,29,74));
          tblImei.setSelectionBackground(new Color(38,117,191));
       tblImei.setShowGrid(true);
        tblSanPham.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblSanPham.getTableHeader().setOpaque(false);
        tblSanPham.getTableHeader().setBackground(new Color(25, 29, 74));
        tblSanPham.getTableHeader().setForeground(Color.WHITE);
        tblSanPham.setGridColor(new Color(25,29,74));
          tblSanPham.setSelectionBackground(new Color(38,117,191));
      tblSanPham.setShowGrid(true);

    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        txtSearchHD = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnTraHang = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboStatusHoadon = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        lblCount = new javax.swing.JLabel();
        cboImei = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnXoa2 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblHoaDon.setForeground(new java.awt.Color(25, 29, 74));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHD", "Khách hàng", "Sđt KH", "Mã nv", "Ngày tạo", "Ngày thanh toán", "SL", "Tổng tiền hàng", "Phí vận chuyển", "Số tiền giảm giá", "Tổng tiền hóa đơn"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setGridColor(new java.awt.Color(25, 29, 74));
        tblHoaDon.setRowHeight(30);
        tblHoaDon.getTableHeader().setReorderingAllowed(false);
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setMinWidth(0);
            tblHoaDon.getColumnModel().getColumn(0).setMaxWidth(0);
            tblHoaDon.getColumnModel().getColumn(1).setMinWidth(200);
            tblHoaDon.getColumnModel().getColumn(1).setMaxWidth(200);
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(70);
            tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(70);
            tblHoaDon.getColumnModel().getColumn(4).setMinWidth(150);
            tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(150);
            tblHoaDon.getColumnModel().getColumn(5).setMinWidth(150);
            tblHoaDon.getColumnModel().getColumn(5).setMaxWidth(150);
            tblHoaDon.getColumnModel().getColumn(6).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(6).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 1600, 450));

        txtSearchHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchHD.setForeground(new java.awt.Color(25, 29, 74));
        txtSearchHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtSearchHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchHDKeyReleased(evt);
            }
        });
        getContentPane().add(txtSearchHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 377, 36));

        jButton1.setBackground(new java.awt.Color(25, 29, 74));
        jButton1.setForeground(new java.awt.Color(25, 29, 74));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 140, 180, 41));

        tblImei.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblImei.setForeground(new java.awt.Color(25, 29, 74));
        tblImei.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "MaImei", "Imei"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblImei.setGridColor(new java.awt.Color(25, 29, 74));
        tblImei.setRowHeight(30);
        tblImei.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblImeiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblImei);
        if (tblImei.getColumnModel().getColumnCount() > 0) {
            tblImei.getColumnModel().getColumn(0).setMinWidth(0);
            tblImei.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 680, 380, 240));

        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Monospaced", 1, 12)); // NOI18N
        txtGhiChu.setForeground(new java.awt.Color(25, 29, 74));
        txtGhiChu.setRows(5);
        txtGhiChu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46)));
        txtGhiChu.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtGhiChuKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtGhiChu);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 680, 330, 100));

        btnTraHang.setBackground(new java.awt.Color(25, 29, 74));
        btnTraHang.setForeground(new java.awt.Color(25, 29, 74));
        btnTraHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/returnsgood.png"))); // NOI18N
        btnTraHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnTraHang.setBorderPainted(false);
        btnTraHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraHangActionPerformed(evt);
            }
        });
        getContentPane().add(btnTraHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 880, 330, 41));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Sản phẩm");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 80, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Imei");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 660, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Lý do đổi máy");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 660, -1, -1));

        cboStatusHoadon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboStatusHoadon.setForeground(new java.awt.Color(25, 29, 74));
        cboStatusHoadon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hiện tại", "Đã xóa" }));
        cboStatusHoadon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));
        cboStatusHoadon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboStatusHoadonItemStateChanged(evt);
            }
        });
        getContentPane().add(cboStatusHoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 229, 36));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Tìm kiếm");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Trạng thái hóa đơn");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));

        jPanel3.setBackground(new java.awt.Color(25, 29, 74));
        jPanel3.setPreferredSize(new java.awt.Dimension(1870, 100));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Hóa đơn");

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 50));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 1903, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 114));

        tblSanPham.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblSanPham.setForeground(new java.awt.Color(25, 29, 74));
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Masp", "Tên sp", "Giá bán", "SL", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setGridColor(new java.awt.Color(25, 29, 74));
        tblSanPham.setRowHeight(30);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setMinWidth(0);
            tblSanPham.getColumnModel().getColumn(0).setMaxWidth(0);
            tblSanPham.getColumnModel().getColumn(2).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(2).setMaxWidth(120);
            tblSanPham.getColumnModel().getColumn(3).setMinWidth(50);
            tblSanPham.getColumnModel().getColumn(3).setMaxWidth(50);
            tblSanPham.getColumnModel().getColumn(4).setMinWidth(120);
            tblSanPham.getColumnModel().getColumn(4).setMaxWidth(120);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 680, 870, 240));

        lblCount.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblCount.setForeground(new java.awt.Color(5, 10, 46));
        getContentPane().add(lblCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 780, 308, 28));

        cboImei.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboImei.setForeground(new java.awt.Color(25, 29, 74));
        cboImei.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cboImei.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboImeiItemStateChanged(evt);
            }
        });
        getContentPane().add(cboImei, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 830, 330, 36));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(5, 10, 46));
        jLabel8.setText("Chọn Imei máy muốn đổi");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 810, -1, -1));

        btnXoa2.setBackground(new java.awt.Color(25, 29, 74));
        btnXoa2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        btnXoa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete1.png"))); // NOI18N
        btnXoa2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 90));
        btnXoa2.setBorderPainted(false);
        btnXoa2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXoa2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXoa2MouseExited(evt);
            }
        });
        btnXoa2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnXoa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1540, 140, 70, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboStatusHoadonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboStatusHoadonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            currentSelectedHoaDon = cboStatusHoadon.getSelectedIndex();
            getDataHoaDon();
        }
    }//GEN-LAST:event_cboStatusHoadonItemStateChanged

    private void txtSearchHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchHDKeyReleased
        this.getDataHoaDon();
    }//GEN-LAST:event_txtSearchHDKeyReleased

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 1) {
            clearForm();
            currentRowHoaDon = tblHoaDon.getSelectedRow();
            this.currentMaHd = (int) tblHoaDon.getValueAt(currentRowHoaDon, 0);
            this.getDataSanPhamByMahd();
            if(cboStatusHoadon.getSelectedIndex() == 0) {
                btnXoa2.setEnabled(true);
            }
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (evt.getClickCount() == 1) {
            int currentRowSanPham = tblSanPham.getSelectedRow();
            this.currentMactsp = (int) tblSanPham.getValueAt(currentRowSanPham, 0);
            this.getDataImeiByMactsp();
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void txtGhiChuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGhiChuKeyReleased
        if (!txtGhiChu.getText().trim().isBlank() && !txtGhiChu.getText().trim().isEmpty()) {
            btnTraHang.setEnabled(true);
            lblCount.setText("Số ký tự: " + txtGhiChu.getText().trim().length() + "/30");
        } else {
            lblCount.setText("");
            btnTraHang.setEnabled(false);
        }
    }//GEN-LAST:event_txtGhiChuKeyReleased

    private void tblImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImeiMouseClicked
        txtGhiChu.setEnabled(true);
        int row = tblImei.getSelectedRow();
        if (row >= 0) {
            currentMaImei = (int) tblImei.getValueAt(row, 0);
            txtGhiChu.setEnabled(true);
        }
    }//GEN-LAST:event_tblImeiMouseClicked

    private void cboImeiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboImeiItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {

        }
    }//GEN-LAST:event_cboImeiItemStateChanged

    private void btnTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraHangActionPerformed
        if (validateForm()) {
            doiHang();
        }
    }//GEN-LAST:event_btnTraHangActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        xuatfile();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnXoa2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoa2MouseEntered
        changeColor(btnXoa2, new Color(102, 0, 102));
    }//GEN-LAST:event_btnXoa2MouseEntered

    private void btnXoa2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoa2MouseExited
        changeColor(btnXoa2, new Color(25, 29, 74));
    }//GEN-LAST:event_btnXoa2MouseExited

    private void btnXoa2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa2ActionPerformed
        delete();
    }//GEN-LAST:event_btnXoa2ActionPerformed

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTraHang;
    private javax.swing.JButton btnXoa2;
    private javax.swing.JComboBox<String> cboImei;
    private javax.swing.JComboBox<String> cboStatusHoadon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCount;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtSearchHD;
    // End of variables declaration//GEN-END:variables
    int currentSelectedHoaDon = 0;
    int currentMaHd = -1;
    int currentMactsp = -1;
    int currentMaImei = -1;
    int currentRowHoaDon = -1;
    Date currentDate = new Date();
    HoaDonService hoaDonService = new HoaDonService();
    SanPhamService sanPhamService = new SanPhamService();
    DefaultComboBoxModel<DalImeiModel> imeiModel;
    DefaultTableModel modelHoaDon;
    DefaultTableModel modelSanPham;
    DefaultTableModel modelImei;
    List<BusHoaDon> listHoaDon = new ArrayList<>();
    List<BusHoaDon> listFilterHoaDon = new ArrayList<>();
    List<CartModel> listCart = new ArrayList<>();
    List<DalImeiModel> listImei = new ArrayList<>();

    void init() {
        getDataHoaDon();
    }

    void getDataHoaDon() {
        try {
            btnXoa2.setEnabled(false);
            String term = this.txtSearchHD.getText();
            int statusHoaDon = cboStatusHoadon.getSelectedIndex();
            this.listHoaDon = this.hoaDonService.getAllHoaDon(term, statusHoaDon);
        } catch (Exception e) {
        }
        fillTableHoaDon(listHoaDon);
    }

    void clearForm() {
        currentSelectedHoaDon = 0;
        currentMaHd = -1;
        currentMactsp = -1;
        currentMaImei = -1;
        currentRowHoaDon = -1;
        modelSanPham = (DefaultTableModel) tblSanPham.getModel();
        modelSanPham.setRowCount(0);
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
        txtGhiChu.setText("");
        txtGhiChu.setEnabled(false);
        btnTraHang.setEnabled(false);
        lblCount.setText("");
        cboImei.removeAllItems();
    }

    void fillTableHoaDon(List<BusHoaDon> listShow) {
        clearForm();
        modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        modelHoaDon.setRowCount(0);
        if (listShow != null) {
            listShow.forEach((hd) -> {
                modelHoaDon.addRow(new Object[]{
                    hd.getMahd(),
                    hd.getKhachHangModel().getTenKH(),
                    hd.getKhachHangModel().getSDT(),
                    hd.getNhanVienModel().getMaNV(),
                    DateService.toString(hd.getNgayTao(), "dd-MM-yyyy"),
                    DateService.toString(hd.getNgayThanhToan(), "dd-MM-yyyy"),
                    hd.getSoLuong(),
                    UtilityService.toVnd(hd.getTongTien()),
                    UtilityService.toVnd(hd.getPhiVanChuyen()),
                    UtilityService.toVnd(hd.getTiemKhuyenMai()),
                    UtilityService.toVnd(hd.getTienKhachTra()),
                    this.currentSelectedHoaDon == 1 ? iconBackUp : iconDelete
                });
            });
        }
    }

    void getDataSanPhamByMahd() {
        try {
            this.listCart = sanPhamService.selectSpByMahd(currentMaHd);
            fillTableSanPham();
        } catch (Exception e) {
        }
    }

    void fillTableSanPham() {
        currentMactsp = -1;
        modelSanPham = (DefaultTableModel) tblSanPham.getModel();
        modelSanPham.setRowCount(0);
        this.listCart.forEach(sp -> {
            modelSanPham.addRow(new Object[]{
                sp.getMactsp(),
                sp.getTensp(),
                UtilityService.toVnd(sp.getGia()),
                sp.getSoLuong(),
                UtilityService.toVnd(sp.getTongTien())
            });
        });
    }

    void getDataImeiByMactsp() {
        try {
            BusImeiService.fillComboImeiDoihang(imeiModel, cboImei, currentMactsp);
            listImei = BusImeiService.getImeisByMactspAndMahd(currentMactsp, currentMaHd);
            fillTableImei();
        } catch (Exception e) {
        }
    }

    void fillTableImei() {
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
        txtGhiChu.setText("");
        lblCount.setText("");
        btnTraHang.setEnabled(false);
        currentMaImei = -1;
        this.listImei.forEach(imei -> {
            modelImei.addRow(new Object[]{
                imei.getMaImei(),
                imei.getTenImei()
            });
        });
    }

    void doiHang() {
        try {
            DalImeiModel newImei = (DalImeiModel) cboImei.getSelectedItem();
            String ghiChu = txtGhiChu.getText();
            String commit = AuthService.user.getMaNV() + " " + DateService.toString(new Date(), "ss:mm:hh dd/MM/yyyy");
            if (BusImeiService.updateGhiChuImei(currentMaImei, newImei.getMaImei(), ghiChu + "\n " + commit)) {
                MessageService.alert(rootPane, "Đổi sản phẩm thành công");
                getDataImeiByMactsp();
            } else {
                MessageService.alert(this, "Error");
            }
        } catch (Exception e) {
            MessageService.alert(this, "Error");
        }
    }

    public boolean validateForm() {
        if (txtGhiChu.getText().length() < 30) {
            MessageService.alert(this, "Vui lòng nhập lý do trả hàng tối thiểu 30 ký tự");
            return false;
        }
        Date ngayThanhToan = DateService.toDate(tblHoaDon.getValueAt(currentRowHoaDon, 4) + "", "dd-MM-yyyy");
        long diff = currentDate.getTime() - ngayThanhToan.getTime();
        int khoangNgay = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        if (khoangNgay > 30) {
            MessageService.alert(this, "Hóa đơn này đã hết hạn trả hàng");
            return false;
        }
        return true;
    }

    void exportFileExcel() {

    }

    void delete() {
        int row = tblHoaDon.getSelectedRow();
        currentMahd = (int) tblHoaDon.getValueAt(row, 0);
        if (currentSelectedHoaDon == 1) {
            if (MessageService.confirm(null, "Bạn có thực sự muốn xóa hóa đơn này không")) {
                hoaDonService.updateStatus(0, currentMahd);
                MessageService.alert(null, "Xóa hóa đơn thành công");
            }
        }
        getDataHoaDon();
    }
//    private void buttonRemoveHoaDon() {
//        Action add = new AbstractAction() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                int row = tblHoaDon.getSelectedRow();
//                currentMahd = (int) tblHoaDon.getValueAt(row, 0);
//                if (currentSelectedHoaDon == 1) {
//                    if (MessageService.confirm(null, "Bạn có muốn khôi phục hóa đơn này không")) {
//                        hoaDonService.updateStatus(1, currentMahd);
//                        getDataHoaDon();
//                        MessageService.alert(null, "Khôi phục hóa đơn thành công");
//                    }
//                } else {
//                    if (MessageService.confirm(null, "Bạn có thực sự muốn xóa hóa đơn này không")) {
//                        hoaDonService.updateStatus(0, currentMahd);
//                        MessageService.alert(null, "Xóa hóa đơn thành công");
//                    }
//                }
//                getDataHoaDon();
//            }
//        };
//        ButtonColumn buttonColumn = new ButtonColumn(tblHoaDon, add, 10);
//        buttonColumn.setMnemonic(KeyEvent.VK_D);
//    }

    public void xuatfile() {
        JFileChooser chooser = new JFileChooser();
        int i = chooser.showSaveDialog(chooser);
        if (i == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                FileWriter out = new FileWriter(file + ".xls");
                BufferedWriter bwrite = new BufferedWriter(out);
                DefaultTableModel model = (DefaultTableModel) tblHoaDon.getModel();
                // ten Cot
                for (int j = 0; j < tblHoaDon.getColumnCount(); j++) {
                    bwrite.write(model.getColumnName(j) + "\t");
                }
                bwrite.write("\n");
                // Lay du lieu dong
                for (int j = 0; j < tblHoaDon.getRowCount(); j++) {
                    for (int k = 0; k < tblHoaDon.getColumnCount(); k++) {
                        bwrite.write(model.getValueAt(j, k) + "\t");
                    }
                    bwrite.write("\n");
                }
                bwrite.close();

                JOptionPane.showMessageDialog(null, "Lưu file thành công!");
            } catch (Exception e2) {
                JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
            }
        }
    }
}
