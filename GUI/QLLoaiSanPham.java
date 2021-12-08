/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusDongSpModel;
import BUS.Models.BusHangModel;
import BUS.Models.BusSanPham;
import BUS.Services.DongSPService;
import BUS.Services.HangService;
import BUS.Services.LoaiSPService;
import BUS.Services.SanPhamService;
import DAL.Models.DalLoaiSanPham;
import GUI.Services.IEditService;
import GUI.Services.MessageService;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLLoaiSanPham extends javax.swing.JFrame implements IEditService<BusSanPham> {

    /**
     * Creates new form QLLoaiSanPham
     */
    int currentId;
    public QLLoaiSanPham() {
        initComponents();
         getContentPane().setBackground(Color.WHITE);
         desginTable();
        this.init();
    }
    public void desginTable() {
        tblHoatDong.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
       tblHoatDong.getTableHeader().setOpaque(false);
        tblHoatDong.getTableHeader().setBackground(new Color(25, 29, 74));
       tblHoatDong.getTableHeader().setForeground(Color.WHITE);
        
        tblXOa.getTableHeader().setDraggedColumn(null);
            tblXOa.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
         tblXOa.getTableHeader().setOpaque(false);
             tblXOa.getTableHeader().setBackground(new Color(25, 29, 74));
             tblXOa.getTableHeader().setForeground(Color.WHITE);
    }
 public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoatDong = new javax.swing.JTable();
        jPanel53 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtTensp = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cboHangsp = new javax.swing.JComboBox<>();
        cboDongsp = new javax.swing.JComboBox<>();
        txtSearchBox = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnBackup = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblXOa = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblHoatDong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHoatDong.setForeground(new java.awt.Color(25, 29, 74));
        tblHoatDong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã loại sản phẩm", "Tên loại sp", "Hãng sản xuất", "Dòng sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoatDong.setGridColor(new java.awt.Color(25, 29, 74));
        tblHoatDong.setRowHeight(25);
        tblHoatDong.setRowMargin(0);
        tblHoatDong.getTableHeader().setReorderingAllowed(false);
        tblHoatDong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoatDongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoatDong);
        if (tblHoatDong.getColumnModel().getColumnCount() > 0) {
            tblHoatDong.getColumnModel().getColumn(0).setMinWidth(0);
            tblHoatDong.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        jPanel53.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        btnThem.setBackground(new java.awt.Color(25, 29, 74));
        btnThem.setForeground(new java.awt.Color(25, 29, 74));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnThem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnThem.setBorderPainted(false);
        btnThem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnThemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnThemMouseExited(evt);
            }
        });
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        jPanel53.add(btnThem);

        btnSua.setBackground(new java.awt.Color(25, 29, 74));
        btnSua.setForeground(new java.awt.Color(25, 29, 74));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnSua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnSua.setBorderPainted(false);
        btnSua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSuaMouseExited(evt);
            }
        });
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        jPanel53.add(btnSua);

        btnXoa.setBackground(new java.awt.Color(25, 29, 74));
        btnXoa.setForeground(new java.awt.Color(25, 29, 74));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete1.png"))); // NOI18N
        btnXoa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnXoa.setBorderPainted(false);
        btnXoa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnXoaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnXoaMouseExited(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        jPanel53.add(btnXoa);

        btnLamMoi.setBackground(new java.awt.Color(25, 29, 74));
        btnLamMoi.setForeground(new java.awt.Color(25, 29, 74));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnLamMoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnLamMoi.setBorderPainted(false);
        btnLamMoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLamMoiMouseExited(evt);
            }
        });
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        jPanel53.add(btnLamMoi);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(5, 10, 46));
        jLabel2.setText("Hãng sản phẩm");

        txtTensp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTensp.setForeground(new java.awt.Color(25, 29, 74));
        txtTensp.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(5, 10, 46));
        jLabel1.setText("Tên loại sản phẩm");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(5, 10, 46));
        jLabel3.setText("Dòng sản phẩm");

        cboHangsp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboHangsp.setForeground(new java.awt.Color(25, 29, 74));
        cboHangsp.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboHangspItemStateChanged(evt);
            }
        });

        cboDongsp.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cboDongsp.setForeground(new java.awt.Color(25, 29, 74));

        txtSearchBox.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSearchBox.setForeground(new java.awt.Color(25, 29, 74));
        txtSearchBox.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));
        txtSearchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSearchBoxKeyTyped(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(5, 10, 46));
        jLabel4.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(cboHangsp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3)
                            .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(85, 85, 85))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTensp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(9, 9, 9)
                .addComponent(cboHangsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(9, 9, 9)
                .addComponent(cboDongsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cboDongsp, cboHangsp, txtSearchBox, txtTensp});

        jTabbedPane1.addTab("Danh sách", jPanel1);

        btnBackup.setBackground(new java.awt.Color(25, 29, 74));
        btnBackup.setForeground(new java.awt.Color(25, 29, 74));
        btnBackup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/restore1.png"))); // NOI18N
        btnBackup.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 70));
        btnBackup.setBorderPainted(false);
        btnBackup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackupMouseExited(evt);
            }
        });
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });

        tblXOa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblXOa.setForeground(new java.awt.Color(25, 29, 74));
        tblXOa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã loại sản phẩm", "Tên loại sp", "Hãng sản xuất", "Dòng sản phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblXOa.setGridColor(new java.awt.Color(25, 29, 74));
        tblXOa.setRowHeight(25);
        tblXOa.setRowMargin(0);
        tblXOa.getTableHeader().setReorderingAllowed(false);
        tblXOa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblXOaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblXOa);
        if (tblXOa.getColumnModel().getColumnCount() > 0) {
            tblXOa.getColumnModel().getColumn(0).setMinWidth(0);
            tblXOa.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(90, 90, 90))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(btnBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Đã xóa", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoatDongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoatDongMouseClicked
        this.row = tblHoatDong.getSelectedRow();
        this.currentId = (int) tblHoatDong.getValueAt(row, 0);
       this.edit();
    }//GEN-LAST:event_tblHoatDongMouseClicked

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        if (MessageService.confirm(this, "xoa ko")) {
            this.delete();
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        this.update();
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        this.insert();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        this.clearForm();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        this.backup();
    }//GEN-LAST:event_btnBackupActionPerformed

    private void tblXOaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblXOaMouseClicked
        this.rowRecycle = tblXOa.getSelectedRow();
        
    }//GEN-LAST:event_tblXOaMouseClicked

    private void txtSearchBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchBoxKeyTyped
        this.fillTable();
    }//GEN-LAST:event_txtSearchBoxKeyTyped

    private void cboHangspItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboHangspItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            this.fillDongCombo();
        }
    }//GEN-LAST:event_cboHangspItemStateChanged

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        System.out.println("closed");
        QuanLySanPham.fillTenSanPhamCombo();
    }//GEN-LAST:event_formWindowClosed

    private void btnThemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseEntered
         changeColor(btnThem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnThemMouseEntered

    private void btnThemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMouseExited
           changeColor(btnThem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnThemMouseExited

    private void btnSuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseEntered
             changeColor(btnSua, new Color(102, 0, 102));
    }//GEN-LAST:event_btnSuaMouseEntered

    private void btnSuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMouseExited
        changeColor(btnSua, new Color(25, 29, 74));
    }//GEN-LAST:event_btnSuaMouseExited

    private void btnXoaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseEntered
          changeColor(btnXoa, new Color(102, 0, 102));
    }//GEN-LAST:event_btnXoaMouseEntered

    private void btnXoaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMouseExited
          changeColor(btnXoa, new Color(25, 29, 74));
    }//GEN-LAST:event_btnXoaMouseExited

    private void btnLamMoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseEntered
        changeColor(btnLamMoi, new Color(102, 0, 102));
    }//GEN-LAST:event_btnLamMoiMouseEntered

    private void btnLamMoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoiMouseExited
         changeColor(btnLamMoi, new Color(25, 29, 74));
    }//GEN-LAST:event_btnLamMoiMouseExited

    private void btnBackupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMouseEntered
      changeColor(btnBackup, new Color(102, 0, 102));
    }//GEN-LAST:event_btnBackupMouseEntered

    private void btnBackupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMouseExited
        changeColor(btnBackup, new Color(25, 29, 74));
    }//GEN-LAST:event_btnBackupMouseExited

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QLLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLLoaiSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLLoaiSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JComboBox<String> cboDongsp;
    private javax.swing.JComboBox<String> cboHangsp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblHoatDong;
    private javax.swing.JTable tblXOa;
    private javax.swing.JTextField txtSearchBox;
    private javax.swing.JTextField txtTensp;
    // End of variables declaration//GEN-END:variables

    int row = -1;
    int rowRecycle = -1;
    
    List<BusSanPham> listSanPham = new ArrayList<>();
    List<BusSanPham> listRecycle = new ArrayList<>();
    DefaultTableModel modelChinh, modelXoa;
    LoaiSPService loaiSPService = new LoaiSPService();
    HangService hangService = new HangService();
    DongSPService dongSPService = new DongSPService();
    List<BusDongSpModel> listDong = new ArrayList<>();
    List<BusHangModel> listHang = new ArrayList<>();
    DefaultComboBoxModel<BusDongSpModel> dongspModel;
    DefaultComboBoxModel<BusHangModel> hangspModel;

    @Override
    public void init() {
        this.setTitle("Quan ly sp");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.fillTable();
        this.fillHangCombo();
        this.fillTableRecycle();
        this.fillTable();
    }

    public void fillTableRecycle() {
        this.modelXoa = (DefaultTableModel) tblXOa.getModel();
        modelXoa.setRowCount(0);
        try {
            this.listRecycle = loaiSPService.selectInRecycle();
            if(this.listRecycle!= null) {
                this.listRecycle.forEach(sp -> {
                    this.modelXoa.addRow(new Object[]{
                        sp.getMasp(),
                        sp.getTensp(),
                        sp.getBusDongSpModel().getBusHangModel().getTenHang(),
                        sp.getBusDongSpModel().getTenDong()
                    });
                });
            }
        } catch (Exception e) {
            MessageService.alert(this, "loi fill");
        }
    }

    void fillDongCombo() {
        this.dongspModel = (DefaultComboBoxModel) cboDongsp.getModel();
        this.dongspModel.removeAllElements();
        BusHangModel busHangModel = (BusHangModel) cboHangsp.getSelectedItem();
        int id = busHangModel.getMaHang();
        try {
            this.listDong = dongSPService.selectByHangsp(id);
            if (this.listDong != null) {
                this.listDong.forEach(dong -> {
                    this.dongspModel.addElement(dong);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void fillHangCombo() {
        this.hangspModel = (DefaultComboBoxModel) cboHangsp.getModel();
        this.hangspModel.removeAllElements();
        try {
            this.listHang = hangService.selectAll();
            if (this.listHang != null) {
                this.listHang.forEach(hang -> {
                    this.hangspModel.addElement(hang);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.fillDongCombo();
    }

    @Override
    public void fillTable() {
        this.modelChinh = (DefaultTableModel) tblHoatDong.getModel();
        modelChinh.setRowCount(0);
        String keyWord = txtSearchBox.getText();
        try {
            this.listSanPham = loaiSPService.selectBySearch(keyWord);
            if(this.listSanPham != null) {
                this.listSanPham.forEach(sp -> {
                    this.modelChinh.addRow(new Object[]{
                        sp.getMasp(),
                        sp.getTensp(),
                        sp.getBusDongSpModel().getBusHangModel().getTenHang(),
                        sp.getBusDongSpModel().getTenDong()
                    });
                });
                
            }
        } catch (Exception e) {
            MessageService.alert(this, "loi");
        }
    }

    public DalLoaiSanPham getInfoForm() {
        DalLoaiSanPham dalLoaiSanPham = new DalLoaiSanPham();
        dalLoaiSanPham.setTensp(txtTensp.getText());
        BusDongSpModel busDongSpModel = (BusDongSpModel) cboDongsp.getSelectedItem();
        dalLoaiSanPham.setMaDong(busDongSpModel.getMaDong());
        return dalLoaiSanPham;
    }

    void backup() {
        int id = (int) tblXOa.getValueAt(this.rowRecycle, 0);
        try {
            loaiSPService.backup(id);
            this.fillTable();
            this.fillTableRecycle();
            this.clearForm();
            this.updateRecycle();
            this.updateStatus();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "err");
        }
    }

    public void updateRecycle() {
        boolean edit = (this.rowRecycle >= 0);
        btnBackup.setEnabled(edit);
    }

    @Override
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        btnThem.setEnabled(!edit);
        btnSua.setEnabled(edit);
        btnXoa.setEnabled(edit);
    }

    @Override
    public BusSanPham getForm() {
        return null;
    }

    @Override
    public void setForm(BusSanPham busSanPham) {
        txtTensp.setText(busSanPham.getTensp());
        cboHangsp.getModel().setSelectedItem(busSanPham.getBusDongSpModel().getBusHangModel());
        cboDongsp.getModel().setSelectedItem(busSanPham.getBusDongSpModel());
    }

    @Override
    public void insert() {
        DalLoaiSanPham dalLoaiSanPham = this.getInfoForm();
        try {
            loaiSPService.insert(dalLoaiSanPham);
            this.clearForm();
            this.fillTable();
        } catch (Exception e) {
            MessageService.alert(this, "errr");
        }
    }

    @Override
    public void update() {
        DalLoaiSanPham dalLoaiSanPham = this.getInfoForm();
        dalLoaiSanPham.setMasp(this.currentId);
        try {
            loaiSPService.update(dalLoaiSanPham);
            this.fillTable();
        } catch (Exception e) {
            MessageService.alert(this, "errr");
        }
    }

    @Override
    public void delete() {
//        int id = (int) tblHoatDong.getValueAt(row, 0);
        try {
            loaiSPService.delete(currentId);
            this.clearForm();
            this.fillTableRecycle();
            this.fillTable();
            MessageService.alert(this, "ok");
        } catch (Exception e) {
            MessageService.alert(this, "error");
        }
    }

    @Override
    public void edit() {
        BusSanPham busSanPham = new BusSanPham();
//        int id = (int) tblHoatDong.getValueAt(this.row, 0);
        try {
            busSanPham = loaiSPService.selectID(this.currentId);
            this.setForm(busSanPham);
            this.updateStatus();
        } catch (Exception e) {
        }
    }

    @Override
    public void clearForm() {
        this.row = -1;
        txtTensp.setText("");
        this.updateStatus();
    }

    @Override
    public void first() {
    }

    @Override
    public void last() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void previous() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean validateForm(boolean isEdit) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
