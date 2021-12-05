/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Models.BusHangModel;

import BUS.Services.HangService;
import GUI.Services.IEditService;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class QLHangsp extends javax.swing.JFrame implements IEditService<Object> {

    public QLHangsp() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        desginTable();
        init();
    }

    public void changeColor(JButton hover, Color rand) {
        hover.setBackground(rand);
    }

    public void desginTable() {
        tblHang.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblHang.getTableHeader().setOpaque(false);
        tblHang.getTableHeader().setBackground(new Color(25, 29, 74));
        tblHang.getTableHeader().setForeground(Color.WHITE);

        tblHang.getTableHeader().setDraggedColumn(null);
        tblhang2.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
        tblhang2.getTableHeader().setOpaque(false);
        tblhang2.getTableHeader().setBackground(new Color(25, 29, 74));
        tblhang2.getTableHeader().setForeground(Color.WHITE);
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
        jPanel53 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHang = new javax.swing.JTable();
        jPanel20 = new javax.swing.JPanel();
        btnthem = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        txtTenHang = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jrdioDangKD = new javax.swing.JRadioButton();
        JradioNgungKD = new javax.swing.JRadioButton();
        btnsua = new javax.swing.JButton();
        btnlammoi = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblhang2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel53.setLayout(new java.awt.GridLayout(1, 0, 3, 0));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setForeground(new java.awt.Color(102, 0, 102));
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tblHang.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblHang.setForeground(new java.awt.Color(25, 29, 74));
        tblHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hãng", "Tên hãng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHang.setGridColor(new java.awt.Color(25, 29, 74));
        tblHang.setRowHeight(25);
        tblHang.setRowMargin(0);
        tblHang.getTableHeader().setReorderingAllowed(false);
        tblHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHang);

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        btnthem.setBackground(new java.awt.Color(25, 29, 74));
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add1.png"))); // NOI18N
        btnthem.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnthem.setBorderPainted(false);
        btnthem.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnthemMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnthemMouseExited(evt);
            }
        });
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(5, 10, 46));
        jLabel21.setText("Tên hãng:");

        txtTenHang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtTenHang.setForeground(new java.awt.Color(25, 29, 74));
        txtTenHang.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(5, 10, 46)));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(5, 10, 46));
        jLabel22.setText("Trạng thái:");

        jrdioDangKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(jrdioDangKD);
        jrdioDangKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jrdioDangKD.setForeground(new java.awt.Color(25, 29, 74));
        jrdioDangKD.setSelected(true);
        jrdioDangKD.setText("Đang kinh doanh");

        JradioNgungKD.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(JradioNgungKD);
        JradioNgungKD.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        JradioNgungKD.setForeground(new java.awt.Color(25, 29, 74));
        JradioNgungKD.setText("Ngừng kinh doanh");

        btnsua.setBackground(new java.awt.Color(25, 29, 74));
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
        btnsua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnsua.setBorderPainted(false);
        btnsua.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnsuaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnsuaMouseExited(evt);
            }
        });
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnlammoi.setBackground(new java.awt.Color(25, 29, 74));
        btnlammoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/neww.png"))); // NOI18N
        btnlammoi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        btnlammoi.setBorderPainted(false);
        btnlammoi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnlammoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlammoiMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlammoiMouseExited(evt);
            }
        });
        btnlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlammoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addComponent(jrdioDangKD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JradioNgungKD))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel22)
                            .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem});

        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTenHang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrdioDangKD)
                    .addComponent(JradioNgungKD))
                .addGap(18, 18, 18)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnlammoi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsua, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnthem, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel20Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnlammoi, btnsua, btnthem});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Danh sách", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        tblhang2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        tblhang2.setForeground(new java.awt.Color(25, 29, 74));
        tblhang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã hãng", "Tên hãng", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblhang2.setGridColor(new java.awt.Color(25, 29, 74));
        tblhang2.setRowHeight(25);
        tblhang2.setRowMargin(0);
        tblhang2.getTableHeader().setReorderingAllowed(false);
        tblhang2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblhang2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblhang2);

        jButton1.setBackground(new java.awt.Color(25, 29, 74));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/restore1.png"))); // NOI18N
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(25, 29, 74), 30));
        jButton1.setBorderPainted(false);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(105, 105, 105)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 108, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Ngừng kinh doanh", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 276, Short.MAX_VALUE)
                        .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed
        // TODO add your handling code here:
        insert();
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        // TODO add your handling code here:
        update();
    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlammoiActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_btnlammoiActionPerformed

    private void tblHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHangMouseClicked
        // TODO add your handling code here:
        //this.row = tblHang.rowAtPoint(evt.getPoint());
        this.row = tblHang.getSelectedRow();
        this.edit();
    }//GEN-LAST:event_tblHangMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        khoiphuc();
        fillTable2();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblhang2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblhang2MouseClicked
        // TODO add your handling code here:
        this.row = tblhang2.getSelectedRow();

    }//GEN-LAST:event_tblhang2MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        QuanLySanPham.fillHangCombo();
    }//GEN-LAST:event_formWindowClosed

    private void btnthemMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseEntered
      changeColor(btnthem, new Color(102, 0, 102));
    }//GEN-LAST:event_btnthemMouseEntered

    private void btnthemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemMouseExited
         changeColor(btnthem, new Color(25, 29, 74));
    }//GEN-LAST:event_btnthemMouseExited

    private void btnsuaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseEntered
       changeColor(btnsua, new Color(102, 0, 102));
    }//GEN-LAST:event_btnsuaMouseEntered

    private void btnsuaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsuaMouseExited
          changeColor(btnsua, new Color(25, 29, 74));
    }//GEN-LAST:event_btnsuaMouseExited

    private void btnlammoiMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlammoiMouseEntered
         changeColor(btnlammoi, new Color(102, 0, 102));
    }//GEN-LAST:event_btnlammoiMouseEntered

    private void btnlammoiMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnlammoiMouseExited
        changeColor(btnlammoi, new Color(25, 29, 74));
    }//GEN-LAST:event_btnlammoiMouseExited

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
     changeColor(jButton1, new Color(102, 0, 102));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
            changeColor(jButton1, new Color(25, 29, 74));
    }//GEN-LAST:event_jButton1MouseExited

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
            java.util.logging.Logger.getLogger(QLHangsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLHangsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLHangsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLHangsp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLHangsp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton JradioNgungKD;
    private javax.swing.JButton btnlammoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JRadioButton jrdioDangKD;
    private javax.swing.JTable tblHang;
    private javax.swing.JTable tblhang2;
    private javax.swing.JTextField txtTenHang;
    // End of variables declaration//GEN-END:variables
     int row = -1;
    int rowRecycle = -1;
    List<BusHangModel> list = new ArrayList<>();
    List<BusHangModel> listRecycle = new ArrayList<>();
    DefaultTableModel model, modelRecycle;
    HangService hang = new HangService();

    @Override
    public void init() {
        this.setLocationRelativeTo(this);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setTitle("");
        this.fillTable();
        this.fillTable2();

    }

    public void khoiphuc() {
        BusHangModel modell = this.getForm();
        int id = (int) tblhang2.getValueAt(this.row, 0);
        modell.setMaHang(id);
        try {
            hang.khoiphuc(modell);
            this.fillTable();
            JOptionPane.showMessageDialog(this, "khôi phục thành công");
        } catch (Exception e) {
        }
    }

    @Override
    public BusHangModel getForm() {
        BusHangModel modell = new BusHangModel();
        modell.setTenHang(txtTenHang.getText());
        boolean trangthai;
        if (JradioNgungKD.isSelected()) {
            trangthai = false;
        } else {
            trangthai = true;
        }
        modell.setTrangThai(trangthai);

        return modell;
    }

    public void setForm(BusHangModel bushangmodel) {
//        txtTenHang.setText(bushangmodel.getTenHang());
//         boolean trangthai = bushangmodel.isTrangThai();
//        if(trangthai = true){
//            jrdioDangKD.setSelected(true);
//        }
//        //jrdioDangKD.setSelected(bushangmodel.isTrangThai());
        txtTenHang.setText(bushangmodel.getTenHang());
        jrdioDangKD.setSelected(bushangmodel.isTrangThai());
        JradioNgungKD.setSelected(!bushangmodel.isTrangThai());
    }

    @Override
    public void updateStatus() {
        boolean edit = (this.row >= 0);
        btnthem.setEnabled(!edit);
        btnsua.setEnabled(edit);
        btnlammoi.setEnabled(edit);

    }

    @Override
    public void insert() {
        BusHangModel busHangModel = getForm();
        try {
            hang.insert(busHangModel);
            this.fillTable();
            this.clearForm();
            this.updateStatus();
            JOptionPane.showMessageDialog(this, "Thêm thành công");
        } catch (Exception e) {
        }

    }

    @Override
    public void update() {
        BusHangModel modell = this.getForm();
        int id = (int) tblHang.getValueAt(this.row, 0);
        modell.setMaHang(id);
        try {
            hang.update(modell);
            this.fillTable();
            JOptionPane.showMessageDialog(this, "cập nhật thành công");
        } catch (Exception e) {
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit() {
        int id = (int) tblHang.getValueAt(this.row, 0);
        BusHangModel bushangmodel = this.hang.selectByID(id);
        this.setForm(bushangmodel);
        this.updateStatus();
    }

    @Override
    public void clearForm() {
        BusHangModel bus = new BusHangModel();
        setForm(bus);
        row = -1;
        this.updateStatus();

    }

    @Override
    public void fillTable() {
        row = -1;
        model = (DefaultTableModel) tblHang.getModel();
        model.setRowCount(0);
        try {
            this.list = hang.selectAll();
            if (this.list != null) {
                for (BusHangModel sp : list) {
                    model.addRow(new Object[]{sp.getMaHang(), sp.getTenHang(), sp.isTrangThai() ? "đang kinh doanh" : "ngừng kính doanh"});
                }
            }
            this.updateStatus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void first() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    private void fillTable2() {
        row = -1;
        modelRecycle = (DefaultTableModel) tblhang2.getModel();
        modelRecycle.setRowCount(0);

        try {
            listRecycle = hang.selectStatus();
            for (BusHangModel sp : listRecycle) {
                modelRecycle.addRow(new Object[]{
                    sp.getMaHang(), sp.getTenHang(), sp.isTrangThai() ? "đang kinh doanh" : "ngừng kính doanh"
                });
            }
            updateStatus();
        } catch (Exception e) {
        }
    }

    @Override
    public void setForm(Object entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
