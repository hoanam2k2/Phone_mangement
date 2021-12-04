/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusHoaDon;
import BUS.Models.BusImeiModel;
import BUS.Models.BusSanPham;
import BUS.Services.BusImeiService;
import BUS.Services.HoaDonService;
import BUS.Services.SanPhamService;
import DAL.Models.DalImeiModel;
import GUI.Models.CartModel;
import static GUI.QuanLyBanHang.currentMahd;
import static GUI.QuanLyBanHang.tblHoaDon;
import GUI.Services.ButtonColumn;
import GUI.Services.MessageService;
import GUI.Services.UtilityService;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QuanLyHoaDon extends javax.swing.JInternalFrame {

    Icon iconBackUp = new ImageIcon(getClass().getResource("/icon/curve-arrow.png"));
    Icon iconDelete = new ImageIcon(getClass().getResource("/icon/bin.png"));

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
       tblImei.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
         tblImei.getTableHeader().setOpaque(false);
       tblImei.getTableHeader().setBackground(new Color(25, 29, 74));
        tblImei.getTableHeader().setForeground(Color.WHITE);
          tblSanPham.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
     tblSanPham.getTableHeader().setOpaque(false);
        tblSanPham.getTableHeader().setBackground(new Color(25, 29, 74));
       tblSanPham.getTableHeader().setForeground(Color.WHITE);
        
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
        jLabel1 = new javax.swing.JLabel();
        cboStatusGiaoHang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblImei = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        btnTraHang = new javax.swing.JButton();
        btnMoiForm = new javax.swing.JButton();
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

        setBackground(new java.awt.Color(255, 255, 255));

        tblHoaDon.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblHoaDon.setForeground(new java.awt.Color(25, 29, 74));
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaHD", "Khách hàng + SĐT", "Mã nv", "Ngày tạo", "Ngày thanh toán", "SL", "Tổng tiền hàng", "Địa chỉ nhận hàng", "Phí vận chuyển", "Trạng thái giao hàng", "Thành tiền", "Tiền khách trả", "Xóa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.setGridColor(new java.awt.Color(25, 29, 74));
        tblHoaDon.setRowHeight(30);
        tblHoaDon.setRowMargin(0);
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
            tblHoaDon.getColumnModel().getColumn(2).setMinWidth(60);
            tblHoaDon.getColumnModel().getColumn(2).setMaxWidth(60);
            tblHoaDon.getColumnModel().getColumn(3).setMinWidth(100);
            tblHoaDon.getColumnModel().getColumn(3).setMaxWidth(100);
            tblHoaDon.getColumnModel().getColumn(4).setMinWidth(100);
            tblHoaDon.getColumnModel().getColumn(4).setMaxWidth(100);
            tblHoaDon.getColumnModel().getColumn(5).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(5).setMaxWidth(40);
            tblHoaDon.getColumnModel().getColumn(7).setMinWidth(250);
            tblHoaDon.getColumnModel().getColumn(7).setMaxWidth(250);
            tblHoaDon.getColumnModel().getColumn(12).setMinWidth(40);
            tblHoaDon.getColumnModel().getColumn(12).setMaxWidth(40);
        }

        txtSearchHD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchHD.setForeground(new java.awt.Color(25, 29, 74));
        txtSearchHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtSearchHD.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchHDKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Trạng thái giao hàng");

        cboStatusGiaoHang.setEditable(true);
        cboStatusGiaoHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboStatusGiaoHang.setForeground(new java.awt.Color(25, 29, 74));
        cboStatusGiaoHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đã giao hàng", "Chưa giao hàng", "Đang giao" }));
        cboStatusGiaoHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cboStatusGiaoHang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboStatusGiaoHangItemStateChanged(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(25, 29, 74));
        jButton1.setForeground(new java.awt.Color(25, 29, 74));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/excel.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

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
        tblImei.setRowMargin(0);
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

        btnTraHang.setBackground(new java.awt.Color(25, 29, 74));
        btnTraHang.setForeground(new java.awt.Color(25, 29, 74));
        btnTraHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/returnsgood.png"))); // NOI18N
        btnTraHang.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnTraHang.setBorderPainted(false);
        btnTraHang.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTraHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnTraHangMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTraHangMouseExited(evt);
            }
        });
        btnTraHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraHangActionPerformed(evt);
            }
        });

        btnMoiForm.setBackground(new java.awt.Color(25, 29, 74));
        btnMoiForm.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnMoiForm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnMoiForm.setBorderPainted(false);
        btnMoiForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMoiForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiFormActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Sản phẩm");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Imei");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Ghi chú");

        cboStatusHoadon.setEditable(true);
        cboStatusHoadon.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboStatusHoadon.setForeground(new java.awt.Color(25, 29, 74));
        cboStatusHoadon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Chưa thanh toán", "Đã thanh toán", "Đã xóa" }));
        cboStatusHoadon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(5, 10, 46), 2));
        cboStatusHoadon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboStatusHoadonItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(5, 10, 46));
        jLabel5.setText("Tìm kiếm");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(5, 10, 46));
        jLabel6.setText("Trạng thái hóa đơn");

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
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        tblSanPham.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        tblSanPham.setForeground(new java.awt.Color(25, 29, 74));
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
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
        tblSanPham.setRowMargin(0);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(650, 650, 650)
                        .addComponent(jLabel3)
                        .addGap(253, 253, 253)
                        .addComponent(jLabel4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 720, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(btnMoiForm, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(63, 63, 63)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(cboStatusHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(31, 31, 31)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(cboStatusGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1320, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(4, 4, 4)
                            .addComponent(txtSearchHD, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addGap(4, 4, 4)
                            .addComponent(cboStatusHoadon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(4, 4, 4)
                            .addComponent(cboStatusGiaoHang, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTraHang, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMoiForm, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboStatusHoadonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboStatusHoadonItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            currentSelectedHoaDon = cboStatusHoadon.getSelectedIndex();
            filterHoaDon();
        }
    }//GEN-LAST:event_cboStatusHoadonItemStateChanged

    private void cboStatusGiaoHangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboStatusGiaoHangItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            currentSelectedGiaoHang = cboStatusGiaoHang.getSelectedIndex();
            filterHoaDon();
        }
    }//GEN-LAST:event_cboStatusGiaoHangItemStateChanged

    private void txtSearchHDKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchHDKeyReleased
        this.getDataHoaDon();
        filterHoaDon();
    }//GEN-LAST:event_txtSearchHDKeyReleased

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblHoaDon.getSelectedRow();
            this.currentMaHd = (int) tblHoaDon.getValueAt(row, 0);
            this.getDataSanPhamByMahd();
        }
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tblSanPham.getSelectedRow();
            this.currentMactsp = (int) tblSanPham.getValueAt(row, 0);
            this.getDataImeiByMactsp();
        }
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnMoiFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiFormActionPerformed
        clearForm();
    }//GEN-LAST:event_btnMoiFormActionPerformed

    private void txtGhiChuKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtGhiChuKeyReleased
        if(!txtGhiChu.getText().trim().isBlank() && !txtGhiChu.getText().trim().isEmpty()) {
            btnTraHang.setEnabled(true);
        } else {
            btnTraHang.setEnabled(false);
        }
    }//GEN-LAST:event_txtGhiChuKeyReleased

    private void btnTraHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraHangActionPerformed
        traHang();
    }//GEN-LAST:event_btnTraHangActionPerformed

    private void tblImeiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblImeiMouseClicked
       txtGhiChu.setEditable(true);
    }//GEN-LAST:event_tblImeiMouseClicked

    private void btnTraHangMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraHangMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraHangMouseEntered

    private void btnTraHangMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraHangMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTraHangMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMoiForm;
    private javax.swing.JButton btnTraHang;
    private javax.swing.JComboBox<String> cboStatusGiaoHang;
    private javax.swing.JComboBox<String> cboStatusHoadon;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblImei;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtSearchHD;
    // End of variables declaration//GEN-END:variables
    int currentSelectedHoaDon = 0;
    int currentSelectedGiaoHang = 0;
    int currentMaHd = -1;
    int currentMactsp = -1;
    int currentImei = -1;
    HoaDonService hoaDonService = new HoaDonService();
    SanPhamService sanPhamService = new SanPhamService();
    DefaultTableModel modelHoaDon;
    DefaultTableModel modelSanPham;
    DefaultTableModel modelImei;
    List<BusHoaDon> listHoaDon = new ArrayList<>();
    List<BusHoaDon> listFilterHoaDon = new ArrayList<>();
    List<CartModel> listCart = new ArrayList<>();
    List<DalImeiModel> listImei = new ArrayList<>();

    void init() {
        buttonRemoveHoaDon();
        getDataHoaDon();
        filterHoaDon();
    }

    void getDataHoaDon() {
        try {
            String term = this.txtSearchHD.getText();
            this.listHoaDon = this.hoaDonService.getAllHoaDon(term);
        } catch (Exception e) {
        }
    }

    void fillTableHoaDon(List<BusHoaDon> listShow) {
        modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        modelHoaDon.setRowCount(0);
        if (listShow != null) {
            listShow.forEach((hd) -> {
                String giaoHang = "";
                switch (hd.getTrangThaiGiaoHang()) {
                    case 0: {
                        giaoHang = "Chưa giao";
                    }
                    break;
                    case 2: {
                        giaoHang = "Đang giao";
                    }
                    break;
                    case 1: {
                        giaoHang = "Đã giao";
                    }
                    break;
                }
                modelHoaDon.addRow(new Object[]{
                    hd.getMahd(),
                    hd.getKhachHangModel().getTenKH() + hd.getKhachHangModel().getSDT(),
                    hd.getNhanVienModel().getMaNV(),
                    hd.getNgayTao(),
                    hd.getNgayThanhToan(),
                    hd.getSoLuong(),
                    UtilityService.toVnd(hd.getTongTien()),
                    hd.getDiaChiNhanHang(),
                    hd.getPhiVanChuyen(),
                    giaoHang,
                    UtilityService.toVnd(hd.getTongTien() + hd.getPhiVanChuyen()),
                    UtilityService.toVnd(hd.getTienKhachTra()),
                    this.currentSelectedHoaDon == 3 ? iconBackUp : iconDelete
                });
            });
        }
        clearForm();
    }

    void getDataSanPhamByMahd() {
        try {
            this.listCart = sanPhamService.selectSpByMahd(currentMaHd);
            fillTableSanPham();
        } catch (Exception e) {
        }
    }

    void fillTableSanPham() {
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
            listImei = BusImeiService.getImeisByMactspAndMahd(currentMactsp, currentMaHd);
            fillTableImei();
        } catch (Exception e) {
        }

    }

    void fillTableImei() {
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
        this.listImei.forEach(imei -> {
            modelImei.addRow(new Object[]{
                imei.getMaImei(),
                imei.getTenImei()
            });
        });
    }

    void traHang() {
        if(txtGhiChu.getText().length() > 30) {
            
        } else {
            MessageService.alert(this, "Vui lòng nhập lý do trả hàng tối thiểu 30 ký tự");
        }
    }

    void clearForm() {
        currentMactsp = -1;
        currentImei = -1;
        txtSearchHD.setEditable(false);
        tblImei.setRowSelectionInterval(0, 0);
        tblSanPham.setRowSelectionInterval(0, 0);
        modelImei = (DefaultTableModel) tblImei.getModel();
        modelImei.setRowCount(0);
        txtGhiChu.setText("");
        btnTraHang.setEnabled(false);
    }

    void exportFileExcel() {

    }

    void filterHoaDon() {
        this.listFilterHoaDon = this.listHoaDon;
        switch (this.currentSelectedHoaDon) {
            case 0: { // tat ca
            }
            break;
            case 1: { // chua thanh toan
                this.listFilterHoaDon = this.listFilterHoaDon.stream().filter(hd -> hd.getNgayThanhToan() == null).toList();
            }
            break;
            case 2: { // da thanh toan
                this.listFilterHoaDon = this.listFilterHoaDon.stream().filter(hd -> hd.getTienKhachTra() == hd.getPhiVanChuyen() + hd.getTongTien()).toList();
            }
            break;
            case 3: { // da xoa
                this.listFilterHoaDon = this.listFilterHoaDon.stream().filter(hd -> !hd.isTrangThai()).toList();
            }
            break;
        }
        switch (this.currentSelectedGiaoHang) {
            case 0: { // tat ca
//                this.listFilterHoaDon = this.listHoaDon;
            }
            break;
            case 1: { // da giao hang
                this.listFilterHoaDon = this.listFilterHoaDon.stream().filter(hd -> hd.getTrangThaiGiaoHang() == 1).toList();
            }
            break;
            case 2: { // chua giao hang
                this.listFilterHoaDon = this.listFilterHoaDon.stream().filter(hd -> hd.getTrangThaiGiaoHang() == 0).toList();
            }
            break;
            case 3: { // dang giao
                this.listFilterHoaDon = this.listFilterHoaDon.stream().filter(hd -> hd.getTrangThaiGiaoHang() == 2).toList();
            }
            break;
        }
        fillTableHoaDon(listFilterHoaDon);
    }

    private void buttonRemoveHoaDon() {
        Action add = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = tblHoaDon.getSelectedRow();
                currentMahd = (int) tblHoaDon.getValueAt(row, 0);
                if (currentSelectedHoaDon == 3) {
                    if (MessageService.confirm(null, "Co muon khoi phuc hoa don ko")) {
                        hoaDonService.updateStatus(1, currentMahd);
                        MessageService.alert(null, "back up  ok");
                    }
                } else {
                    if (MessageService.confirm(null, "Co muon xoa hoa don ko")) {
                        hoaDonService.updateStatus(0, currentMahd);
                        MessageService.alert(null, "Xoa ok");
                    }
                }
                getDataHoaDon();
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tblHoaDon, add, 12);
        buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
}
