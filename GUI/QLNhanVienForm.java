/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BUS.Services.NhanVienService;
import DAL.Models.NhanVienModel;
import GUI.Services.DateService;
import GUI.Services.ImageService;
import GUI.Services.MessageService;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.SheetCollate;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 84349
 */
public class QLNhanVienForm extends javax.swing.JFrame {

    /**
     * Creates new form QLNhanVienForm
     */
    NhanVienService nvdao = new NhanVienService();
    int today = LocalDate.now().getYear();
    int lastday;
    int j=0;
    @Override
    public void layout() {
        super.layout(); //To change body of generated methods, choose Tools | Templates.
    }
    LocalDate dateNgay = LocalDate.now();
    int index =0;
    Date d;
    public QLNhanVienForm() {
        initComponents();
        setLocationRelativeTo(null);
        filltableNVON();
        filltableNVOFF();
//        System.out.println(tblDSNVON.getRowCount());
        
        try {
            //        System.out.println(today);
//        lastday=LocalDate.parse(txtNgayBD.getText()).getYear();
//        System.out.println(lastday);
//        Date date=jDateChooser1.getDate();
//        txtNgayBD.setDate(DateService.addDays(date,today ));
//        System.out.println(date);
            d= new SimpleDateFormat("yyyy-MM-dd").parse(dateNgay.toString());
            txtNgaySinh.setDate(d);
        } catch (ParseException ex) {
            Logger.getLogger(QLNhanVienForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void filltableNVON() {
        DefaultTableModel model = (DefaultTableModel) tblDSNVON.getModel();
        model.setRowCount(0);
        try {

            List<NhanVienModel> list = nvdao.selectAllON();
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getNgaySinh(),
                    nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(),
                    nv.getGhiChu(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.getNgayBD()
                        
                };
                model.addRow(row);
                
            }
            tblDSNVON.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }

    }

    private void filltableNVOFF() {
        DefaultTableModel model = (DefaultTableModel) tblDSNVOFF.getModel();
        model.setRowCount(0);
        try {

            List<NhanVienModel> list = nvdao.selectAllOFF();
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getDiaChi(),
                    nv.getNgayKT(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.NamLamViec()
                };
                
                model.addRow(row);
            }
            tblDSNVOFF.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }
    private boolean ChekTrung(){
        List<NhanVienModel> list = nvdao.selectAll();
        for (int i = 0; i < list.size(); i++) {
            if (txtMaNV.getText().equals(list.get(i).getMaNV())) {
                JOptionPane.showMessageDialog(this, "Đã có mã nhân viên "+txtMaNV.getText()+" .Mời bạn nhập mã khác.");
                txtMaNV.requestFocus();
                return false;
            }
        }
        return true;
    }

    private boolean chekrong() {
        String ngaysing;
        ngaysing = DateService.toString(txtNgaySinh.getDate(), "yyyy-MM-dd");
        if (txtMaNV.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Mã nhân viên mời bạn nhập Mã nhân viên");
            txtMaNV.requestFocus();
            return false;
        } else if (txtmatkhau.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Mật khẩu mời bạn nhập Mật khẩu");
            txtmatkhau.requestFocus();
            return false;
        } else if (!(txtChekMatKhau.getText().equals(txtmatkhau.getText()))) {
            MessageService.alert(rootPane, "Mật khẩu nhập lại không đúng với Mật khẩu mời bạn kiểm tra lại");
            txtMaNV.requestFocus();
            return false;
        } else if (txtDiaChi.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Địa chỉ mời bạn nhập Địa chỉ");
            txtDiaChi.requestFocus();
            return false;
        } //        else if(txtGhiChu.getText().equals("")){
        //            MessageService.alert(rootPane, "Không thể bỏ trống Ghi Chú mời bạn nhập Ghi chú");
        //            txtGhiChu.requestFocus();
        //            return false ;
        //        }
        else if (txtHoTen.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Họ tên mời bạn nhập Họ tên");
            txtHoTen.requestFocus();
            return false;
        } else if (txtemail.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống email mời bạn nhập email");
        } else if (ngaysing.length() == 0) {
            MessageService.alert(rootPane, "Không thể bỏ trống Ngày sinh mời bạn chọn ngày sinh");
            txtNgaySinh.requestFocus();
            return false;
        } else if (txtSDT.getText().equals("")) {
            MessageService.alert(rootPane, "Không thể bỏ trống Số điện thoại mời bạn nhập Số điện thoại");
            txtSDT.requestFocus();
            return false;
        } else if (imgAnh.getIcon() == null) {
            MessageService.alert(rootPane, "Không thể bỏ trống ảnh mời bạn click vào hình ảnh để chọn ảnh");
            return false;
        }
        return true;
    }

    private boolean valid() {
        if (txtMaNV.getText().length() < 3) {
            MessageService.alert(this, "Mã nhân viên phải có từ 3 kí tự trở lên");
            txtMaNV.requestFocus();
            return false;
        } else if (txtmatkhau.getText().length() < 6) {
            MessageService.alert(this, "Mật khẩu phải có từ 6 kí tự trở lên");
            txtmatkhau.requestFocus();
            return false;
        } else if (!(txtSDT.getText()).matches("[0-9]{10}")) {
            MessageService.alert(rootPane, "Số điện thoại phải nhập đúng 10 số");
            txtSDT.requestFocus();
            return false;
        } else if (!(txtemail.getText()).matches("^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng email", "Error", 1);
            txtemail.requestFocus();
            return false;
        }
        else if (!(txtNgayBD.getText()).matches("^((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])$")) {
            JOptionPane.showMessageDialog(rootPane, "Sai định dạng ngày sinh \nĐịnh dạng năm-tháng-ngày(năm từ 19xx-20xx)", "Error", 1);
            txtemail.requestFocus();
            return false;
        }
        return true;
    }

    public void update() {
        NhanVienModel model = getEntity();
        String confirm = new String(txtChekMatKhau.getPassword());
        if (!confirm.equals(model.getMatKhau())) {
            MessageService.alert(this, "xác nhận mật khẩu không đúng");
        } else {
            try {
                nvdao.update(model);
                filltableNVON();
                filltableNVOFF();
                MessageService.alert(this, "Cập nhập Thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Cập nhập thất bại!");
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        Grupsex = new javax.swing.ButtonGroup();
        GrupVaiTro = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        tabs = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        rdoVTruongPhong = new javax.swing.JRadioButton();
        rdoVTNhanVien = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnMoi = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();
        btnPrev = new javax.swing.JButton();
        btnnext = new javax.swing.JButton();
        btnLast = new javax.swing.JButton();
        txtmatkhau = new javax.swing.JPasswordField();
        txtChekMatKhau = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        rdoGTNam = new javax.swing.JRadioButton();
        rdoGTNu = new javax.swing.JRadioButton();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblNgaybatdau = new javax.swing.JLabel();
        txtNgayBD = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        imgAnh = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDSNVON = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtTimKiemON = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSNVOFF = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtTimKiemOFF = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextField1.setText("jTextField1");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hệ thống cửa hàng điện thoại");

        jLabel2.setText("Mã nhân viên");

        jLabel3.setText("Mật khẩu");

        jLabel4.setText("Xác nhận mật khẩu");

        jLabel5.setText("Họ và tên");

        jLabel6.setText("Vai trò");

        GrupVaiTro.add(rdoVTruongPhong);
        rdoVTruongPhong.setSelected(true);
        rdoVTruongPhong.setText("Trưởng phòng");
        rdoVTruongPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoVTruongPhongActionPerformed(evt);
            }
        });

        GrupVaiTro.add(rdoVTNhanVien);
        rdoVTNhanVien.setText("Nhân viên");
        rdoVTNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoVTNhanVienActionPerformed(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/updating.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add.png"))); // NOI18N
        btnMoi.setText("Mới");
        btnMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoiActionPerformed(evt);
            }
        });

        btnFirst.setText("|<");
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });

        btnPrev.setText("<<");
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevActionPerformed(evt);
            }
        });

        btnnext.setText(">>");
        btnnext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnextActionPerformed(evt);
            }
        });

        btnLast.setText(">|");
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });

        txtChekMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtChekMatKhauActionPerformed(evt);
            }
        });

        jLabel7.setText("Số Điện Thoại");

        jLabel8.setText("Giới Tính");

        jLabel9.setText("Ngày Sinh");

        jLabel10.setText("Địa Chỉ");

        Grupsex.add(rdoGTNam);
        rdoGTNam.setSelected(true);
        rdoGTNam.setText("Nam");

        Grupsex.add(rdoGTNu);
        rdoGTNu.setText("Nữ");

        txtNgaySinh.setDateFormatString("y-MM-d");

        jLabel11.setText("Hình Ảnh");

        jLabel12.setText("Ghi Chú");

        lblNgaybatdau.setText("Ngày Bắt Đầu");

        txtNgayBD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayBDActionPerformed(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        imgAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane4.setViewportView(txtGhiChu);

        jLabel14.setText("Email");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdoGTNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoGTNu)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                                    .addComponent(txtemail, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtChekMatKhau, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtmatkhau, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMaNV, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(218, 218, 218))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(rdoVTruongPhong)
                                    .addGap(18, 18, 18)
                                    .addComponent(rdoVTNhanVien))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSDT)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                                    .addComponent(lblNgaybatdau, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(382, 382, 382)
                        .addComponent(btnFirst)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPrev)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnnext)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLast))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(2, 2, 2)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMoi)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChekMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdoVTruongPhong)
                    .addComponent(rdoVTNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgaybatdau)
                    .addComponent(jLabel14))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoGTNam)
                            .addComponent(rdoGTNu))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(153, 153, 153))
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa)
                    .addComponent(btnMoi)
                    .addComponent(btnFirst, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPrev, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnnext, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLast, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        tabs.addTab("CẬP NHẬP", jPanel1);

        tblDSNVON.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NV", "HỌ VÀ TÊN", "Số Điện Thoại", "Email", "Ngày Sinh", "Giới Tính", "Địa Chỉ", "Ghi Chú", "VAI TRÒ", "Ngày Bắt Đầu Làm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNVON.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDSNVONAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDSNVON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVONMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDSNVON);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 255));
        jButton1.setText("Xem Chi Tiết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 255));
        jButton2.setText("Xóa");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setText("Tìm Kiếm:");

        jButton4.setText("Tìm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel13)
                .addGap(26, 26, 26)
                .addComponent(txtTimKiemON, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH NHÂN VIÊN ĐANG LÀM VIỆC", jPanel2);

        tblDSNVOFF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MÃ NV", "HỌ VÀ TÊN", "Số Điện Thoại", "Email", "Địa Chỉ", "Ngày Nghỉ", "Vai Trò", "Số Năm Làm Việc"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNVOFF.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDSNVOFFAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDSNVOFF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSNVOFFMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblDSNVOFF);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 255));
        jButton3.setText("Khôi Phục");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(51, 51, 255));
        jButton5.setText("Xem Chi Tiết");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel15.setText("Tìm Kiếm:");

        jButton6.setText("Tìm");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jLabel15)
                                .addGap(26, 26, 26)
                                .addComponent(txtTimKiemOFF, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemOFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        tabs.addTab("DANH SÁCH NHÂN VIÊN ĐÃ NGHỈ VIÊC", jPanel3);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(tabs, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabs)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rdoVTruongPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoVTruongPhongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoVTruongPhongActionPerformed

    private void rdoVTNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoVTNhanVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoVTNhanVienActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
//        if (check()) {
//            this.insert();
//        }

        if (chekrong() == true) {
            if (valid() == true) {
                if(ChekTrung()){
                try {
//                nvdao.insert(entity);
                    NhanVienModel entity = getEntity();

                    try {
                        nvdao.insert(entity);
                        this.filltableNVON();
                        filltableNVOFF();
                        this.clear();
                        MessageService.alert(this, "Thêm mới thành công!");
//                            System.out.println(jDateChooser1.getDate());
                        String hi = DateService.toString(txtNgaySinh.getDate(), "yyyy-MM-dd");
                        System.out.println(hi);
                    } catch (Exception e) {
                        MessageService.alert(this, "Thêm mới thất bại!");
                    }

                } catch (Exception e) {
                }
                }
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        if(chekrong()==true){
            if(valid()==true){
                update();
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
//        String checkmanv = txtMaNV.getText();
//        //        if (ShareHelper.USER.getMaNV().equals(checkmanv)) {
//            //            DialogHelper.alert(this, "không xóa chính mình");
//            //        } else {
//            //            this.delete();
//            //        }
//        //        if (!Auth.isManager()) {
//            //           DialogHelper.alert(this, "Ban k co quyen xoa");
//            //        }else{
//            if(checkmanv.equals(Auth.user.getMaNV())){
//                DialogHelper.alert(this, "ban k xoa duoc ban");
//            }else{
//                DialogHelper.confirm(this, "Ban muon xoa chu ?");
//                this.delete();
//                //            }
//        }
            this.xoatrenForm();

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoiActionPerformed
        // TODO add your handling code here:
//        this.clear();
                clear();
                sttCTtap3();
//        txtnhanvien.setEditable(true);
    }//GEN-LAST:event_btnMoiActionPerformed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed
        // TODO add your handling code here:
        this.index = 0;
        this.edit();
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevActionPerformed
        // TODO add your handling code here:
        if(index==0){
            index=tblDSNVON.getRowCount()-1;
            
        }else if(index<0){
            
        }
        index--;
            this.edit();
//        System.out.println(index);
    }//GEN-LAST:event_btnPrevActionPerformed

    private void btnnextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnextActionPerformed
        // TODO add your handling code here:
        
        
        if(index==tblDSNVON.getRowCount()-1){
            index=0;
            
        }
        index++;
            this.edit();
        
    }//GEN-LAST:event_btnnextActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        // TODO add your handling code here:
        this.index = tblDSNVON.getRowCount()-1;
        this.edit();
    }//GEN-LAST:event_btnLastActionPerformed

    private void txtChekMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtChekMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtChekMatKhauActionPerformed

    private void tblDSNVONAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDSNVONAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSNVONAncestorAdded

    private void tblDSNVONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVONMouseClicked
        // TODO add your handling code here:
//        if (evt.getClickCount() == 2) {
//            this.index = tblQLNV.rowAtPoint(evt.getPoint());
//            if (this.index >= 0) {
//                this.edit();
//                tabs.setSelectedIndex(0);
//            }
//        }
    }//GEN-LAST:event_tblDSNVONMouseClicked

    private void tblDSNVOFFAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDSNVOFFAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSNVOFFAncestorAdded

    private void tblDSNVOFFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSNVOFFMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblDSNVOFFMouseClicked
    String imageName;

    public void ResizeImage(String imageName) {
        ImageIcon icon = new ImageIcon("image\\" + imageName);
        Image image = icon.getImage();
        ImageIcon icon1 = new ImageIcon(image.getScaledInstance(imgAnh.getWidth(), imgAnh.getHeight(), image.SCALE_SMOOTH));
        imgAnh.setIcon(icon1);

    }
    private void imgAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgAnhMouseClicked
        // TODO add your handling code here:
        try {
            JFileChooser file = new JFileChooser("image\\");
            int kq = file.showOpenDialog(file);
            if (kq == JFileChooser.APPROVE_OPTION) {
                imageName = file.getSelectedFile().getName();
                ResizeImage(imageName);
                imgAnh.setToolTipText(imageName);
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bạn chưa chọn ảnh...");
            }

        } catch (Exception a) {

        }
//            try {
//                ImageService.getAppIcon();
//        } catch (Exception e) {
//        }
    }//GEN-LAST:event_imgAnhMouseClicked

    private void txtNgayBDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayBDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayBDActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        index = tblDSNVON.getSelectedRow();
        if (index < 0) {
            MessageService.alert(rootPane, "Bạn phải trọn nhân viên trên bảng để sử dụng chức năng");
        } else {
            this.edit();
            tabs.setSelectedIndex(0);
            sttCTtap2();
        }
    }//GEN-LAST:event_jButton1ActionPerformed
//    int j;
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        j = tblDSNVOFF.getSelectedRow();
        if (j < 0) {
            MessageService.alert(rootPane, "Bạn phải trọn nhân viên trên bảng để sử dụng chức năng");
        } else {
            this.edit1();
            tabs.setSelectedIndex(0);
            sttOff();
        }
    }//GEN-LAST:event_jButton5ActionPerformed
    int hi = -1;
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        hi = tblDSNVON.getSelectedRow();
        if (hi < 0) {
            MessageService.alert(rootPane, "Bạn phải trọn nhân viên trên bảng để sử dụng chức năng");
        } else {
            this.xoa();
//            MessageService.alert(rootPane, "Xóa Thành Công");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    private void KhoiPhuc(){
        if (MessageService.confirm(rootPane, "Bạn chắc chắn khôi phục chứ ???")) {
            String maNV = (String) tblDSNVOFF.getValueAt(j, 0);
            try {
                nvdao.KhoiPhuc(maNV);
                nvdao.Ngaynghi("", maNV);
                this.filltableNVON();
                this.filltableNVOFF();
//                this.clear();
                MessageService.alert(this, "Khôi phục thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Khôi phục Thất bại!");
            }
        }
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        j = tblDSNVOFF.getSelectedRow();
        if (j < 0) {
            MessageService.alert(rootPane, "Bạn phải trọn nhân viên trên bảng để sử dụng chức năng");
        } else {
            KhoiPhuc();
//            MessageService.alert(rootPane, "Xóa Thành Công");
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        timNhanVienON();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        timNhanVienOFF();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhanVienForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhanVienForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupVaiTro;
    private javax.swing.ButtonGroup Grupsex;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnMoi;
    private javax.swing.JButton btnPrev;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnnext;
    private javax.swing.JLabel imgAnh;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblNgaybatdau;
    private javax.swing.JRadioButton rdoGTNam;
    private javax.swing.JRadioButton rdoGTNu;
    private javax.swing.JRadioButton rdoVTNhanVien;
    private javax.swing.JRadioButton rdoVTruongPhong;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.JTable tblDSNVOFF;
    private javax.swing.JTable tblDSNVON;
    private javax.swing.JPasswordField txtChekMatKhau;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextArea txtGhiChu;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTimKiemOFF;
    private javax.swing.JTextField txtTimKiemON;
    private javax.swing.JTextField txtemail;
    private javax.swing.JPasswordField txtmatkhau;
    // End of variables declaration//GEN-END:variables

    private NhanVienModel getEntity() {
        NhanVienModel entity = new NhanVienModel();
        entity.setMaNV(txtMaNV.getText());
        entity.setMatKhau(txtmatkhau.getText());
        entity.setHoTen(txtHoTen.getText());
        entity.setSDT(txtSDT.getText());
        entity.setGioiTinh(rdoGTNam.isSelected());
        entity.setNgaySinh(txtNgaySinh.getDate());
        entity.setDiaChi(txtDiaChi.getText());
        entity.setVaiTro(rdoVTruongPhong.isSelected());
        entity.setGhiChu(txtGhiChu.getText());
        entity.setHinh(imgAnh.getToolTipText());
        entity.setNgayBD(DateService.toDate(txtNgayBD.getText(), "yyyy-MM-dd"));
        entity.setEmail(txtemail.getText());
        return entity;
    }

    private void clear() {
        try {
            
            txtChekMatKhau.setText("");
            txtDiaChi.setText("");
            txtGhiChu.setText("");
            txtHoTen.setText("");
            txtMaNV.setText("");
            txtNgayBD.setText("");
            txtNgaySinh.setDate(d);
            txtSDT.setText("");
            txtemail.setText("");
            txtmatkhau.setText("");
            rdoGTNam.setSelected(true);
            rdoVTruongPhong.setSelected(true);
            imgAnh.setIcon(null);
            sttCTtap3();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void sttOff(){
    lblNgaybatdau.setText("Năm làm việc");
    txtMaNV.setFocusable(false);
    btnThem.setEnabled(false);
    btnSua.setEnabled(false);
    btnXoa.setEnabled(false);
    }
    private void sttCTtap3(){
    lblNgaybatdau.setText("Ngày bắt đầu");
    txtMaNV.setFocusable(true);
    btnThem.setEnabled(true);
    btnSua.setEnabled(true);
    btnXoa.setEnabled(true);
    }
    private void sttCTtap2(){
    lblNgaybatdau.setText("Ngày bắt đầu");
    txtMaNV.setFocusable(false);
    btnThem.setEnabled(false);
    btnSua.setEnabled(true);
    btnXoa.setEnabled(true);
    }
    
    
    

    private void edit() {
        try {
            String manv = (String) tblDSNVON.getValueAt(this.index, 0);
            NhanVienModel model = nvdao.selectByID(manv);
            if (model != null) {
                this.setModel(model);
            }
        } catch (Exception a) {
            MessageService.alert(this, "lỗi truy vấn dữ liệu!");
            a.printStackTrace();
        }
    }

    private void edit1() {
        try {
            String manv = (String) tblDSNVOFF.getValueAt(this.j, 0);
            NhanVienModel model = nvdao.selectByID(manv);
            if (model != null) {
                this.setModel(model);
//                this.setStatus(false);
            }
        } catch (Exception a) {
            MessageService.alert(this, "lỗi truy vấn dữ liệu!");
            a.printStackTrace();
        }
    }

    private void setModel(NhanVienModel model) {

        txtMaNV.setText(model.getMaNV());
        txtHoTen.setText(model.getHoTen());
        txtmatkhau.setText(model.getMatKhau());
        txtChekMatKhau.setText(model.getMatKhau());
        rdoVTruongPhong.setSelected(model.isVaiTro());
        rdoVTNhanVien.setSelected(!model.isVaiTro());
        rdoGTNam.setSelected(model.isGioiTinh());
        rdoGTNu.setSelected(model.isGioiTinh());
        txtNgaySinh.setDate(model.getNgaySinh());
        txtSDT.setText(model.getSDT());
        txtemail.setText(model.getEmail());
        txtDiaChi.setText(model.getDiaChi());
        txtNgayBD.setText(model.getNgayBD() + "");
        imgAnh.setToolTipText(model.getHinh());
        if (model.getHinh() != null) {
            imgAnh.setIcon(ImageService.readLogo(model.getHinh()));
        }
        txtGhiChu.setText(model.getGhiChu());
//        setMaNV(txtMaNV.getText());
//        setMatKhau(txtmatkhau.getText());
//        entity.setHoTen(txtHoTen.getText());
//        entity.setSDT(txtSDT.getText());
//        entity.setGioiTinh(rdoGTNam.isSelected());
//        entity.setNgaySinh(txtNgaySinh.getDate());
//        entity.setDiaChi(txtDiaChi.getText());
//        entity.setVaiTro(rdoVTruongPhong.isSelected());
//        entity.setGhiChu(txtGhiChu.getText());
//         entity.setHinh(imgAnh.getToolTipText());
//        entity.setNgayBD(DateService.toDate(txtNgayBD.getText(), "yyyy-MM-dd"));
//        entity.setEmail(txtemail.getText());
    }
//    private void capnhapngatnghi(){
//        try {
//            nvdao.Ngaynghi(e);
//            
//        } catch (Exception e) {
//        }
//    }

    private void xoa() {
        
        if (MessageService.confirm(rootPane, "Bạn chắc chắn muốn xóa chứ ???")) {
            String maNV = (String) tblDSNVON.getValueAt(hi, 0);
            try {
                
                nvdao.delete(maNV);
                nvdao.Ngaynghi(dateNgay.toString(), maNV);
                this.filltableNVON();
                this.filltableNVOFF();
                this.clear();
                MessageService.alert(this, "Xóa thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Xóa Thất bại!");
            }
        }

    }
    private void xoatrenForm() {
        if (MessageService.confirm(rootPane, "Bạn chắc chắn muốn xóa chứ ???")) {
            String maNV = txtMaNV.getText();
            try {
                nvdao.delete(maNV);
                nvdao.Ngaynghi(dateNgay.toString(), maNV);
                this.filltableNVON();
                this.filltableNVOFF();
                this.clear();
                MessageService.alert(this, "Xóa thành công!");
            } catch (Exception a) {
                MessageService.alert(this, "Xóa Thất bại!");
            }
        }

    }

    private void timNhanVienON() {
       DefaultTableModel model = (DefaultTableModel) tblDSNVON.getModel();
        model.setRowCount(0);
        try {
            List<NhanVienModel> list = nvdao.selectByKeywordON(txtTimKiemON.getText());
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getNgaySinh(),
                    nv.isGioiTinh() ? "Nam" : "Nữ",
                    nv.getDiaChi(),
                    nv.getGhiChu(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.getNgayBD()
                        
                };
                model.addRow(row);
                
            }
            tblDSNVON.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }

    private void timNhanVienOFF() {
         DefaultTableModel model = (DefaultTableModel) tblDSNVOFF.getModel();
        model.setRowCount(0);
        try {

            List<NhanVienModel> list = nvdao.selectByKeywordOFF(txtTimKiemOFF.getText());
            for (NhanVienModel nv : list) {
                Object[] row = {
                    nv.getMaNV(),
                    nv.getHoTen(),
                    nv.getSDT(),
                    nv.getEmail(),
                    nv.getDiaChi(),
                    nv.getNgayKT(),
                    nv.isVaiTro() ? "Trưởng phòng" : "Nhân viên",
                    nv.NamLamViec()
                };
                
                model.addRow(row);
            }
            tblDSNVOFF.setRowSelectionInterval(0, 0);
        } catch (Exception e) {
            System.out.println("er");
            e.printStackTrace();
        }
    }
}