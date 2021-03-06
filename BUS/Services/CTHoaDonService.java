/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import BUS.IServices.ICTHoaDonService;
import BUS.Models.BusCTHoaDon;
import BUS.Models.BusCTSanPhamModel;
import BUS.Models.BusHoaDon;
import BUS.Models.BusSanPham;
import BUS.Models.KhachHangModel;
import BUS.Models.NhanVienModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Models.DalChiTietHoaDon;

import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class CTHoaDonService implements ICTHoaDonService, IPhoneMangementService<DalChiTietHoaDon, Integer> {
    
    @Override
    public void insert(DalChiTietHoaDon entity) {
        boolean isInsert = true;
//        
        try {
            ResultSet rs = JDBCHelper.executeQuery("select * from ChiTietHoaDon where MaImei = ? and trangThai = 1", entity.getMaImei());
            while (rs.next()) {
                isInsert = false;
            }
            rs.getStatement().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(isInsert) {
            try {
                JDBCHelper.executeUpdate(INSERT,
                        entity.getMahd(),
                        entity.getMaImei(),
                        entity.getGiaBanSauSale(),
                        entity.getGiaBan()
                );
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(DalChiTietHoaDon entity) {
        try {
            JDBCHelper.executeUpdate(UPDATE,
                    entity.getMahd(),
                    entity.getMaImei(),
                    entity.getGiaBanSauSale(),
                    entity.getGiaBan(),
                    entity.getMacthd()
            );
        } catch (SQLException e) {
        }
    }
    public boolean updateByMaImei(int maImei) {
        try {
            JDBCHelper.executeUpdate(UPDATE_BY_MAIMEI,
                    maImei
            );
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(Integer maImei) {
//        try {
//            JDBCHelper.executeUpdate(UPDATE_BY_MAIMEI, maImei);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
    public void updateStatus(Integer status, Integer idHoaDon) {
        try {
            JDBCHelper.executeUpdate(UPDATE_STATUS, status, idHoaDon);
//            BusImeiService.updateStatusSellByMahd(status == 0 ? 1 : 0  , idHoaDon);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public DalChiTietHoaDon selectByID(Integer id) {
        return null;
    }

    public List<BusCTHoaDon> selectAll1() {
        if (this.selectSql(SELECT_ALL1) == null) {
            return null;
        }
        return this.selectSql(SELECT_ALL1);
    }
    public List<BusCTHoaDon> selectAll0() {
        if (this.selectSql(SELECT_ALL0) == null) {
            return null;
        }
        return this.selectSql(SELECT_ALL0);
    }

    public List<BusCTHoaDon> selectSql(String sql, Object... args) {
        List<BusCTHoaDon> listHDCT = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusCTHoaDon busCTHoaDon = this.getResultSet(rs);
                listHDCT.add(busCTHoaDon);
            }
            rs.getStatement().close();
            return listHDCT;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private BusCTHoaDon getResultSet(ResultSet rs) {
        try {
            BusCTHoaDon busCTHoaDon = new BusCTHoaDon();
            BusHoaDon busHoaDon = new BusHoaDon();
            BusCTSanPhamModel busCTSanPhamModel = new BusCTSanPhamModel();
            KhachHangModel khachHangModel = new KhachHangModel();
            khachHangModel.setMaKH(rs.getInt("makh"));
            khachHangModel.setSDT(rs.getString("sdt"));
            khachHangModel.setTenKH(rs.getString("hoten"));

            NhanVienModel nhanVienModel = new NhanVienModel();
            nhanVienModel.setMaNV(rs.getString("manv"));

            busHoaDon.setMahd(rs.getInt("mahd"));
//            busHoaDon.setNgayBan(rs.getDate("ngaytao"));
            busHoaDon.setKhachHangModel(khachHangModel);
            busHoaDon.setNhanVienModel(nhanVienModel);

            BusSanPham busSanPham = new BusSanPham();
            busSanPham.setMasp(rs.getInt("masp"));
            busSanPham.setTensp(rs.getString("tensp"));

            busCTSanPhamModel.setMaCTSP(rs.getInt("mactsp"));
            busCTSanPhamModel.setSanPhamModel(busSanPham);

            busCTHoaDon.setBusCTSanPhamModel(busCTSanPhamModel);
            busCTHoaDon.setMacthd(rs.getInt("macthd"));
            busCTHoaDon.setSoLuong(rs.getInt("soluong"));
            busCTHoaDon.setThanhTien(rs.getFloat("tongtien"));
            busCTHoaDon.setGia(rs.getFloat("GiaBanSauSale"));
            busCTHoaDon.setBusHoaDon(busHoaDon);
            return busCTHoaDon;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("get result errr");
        return null;
    }

    @Override
    public List<DalChiTietHoaDon> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DalChiTietHoaDon> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
