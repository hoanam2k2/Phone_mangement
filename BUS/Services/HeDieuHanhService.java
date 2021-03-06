/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BUS.Services;

import static BUS.IServices.IHeDieuHanhService.*;
import BUS.Models.BusHeDieuHanhModel;
import BUS.Models.BusHeDieuHanhModel;
import BUS.Models.BusHeDieuHanhModel;
import DAL.IServices.IPhoneMangementService;
import DAL.Services.JDBCHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author ADMIN
 */
public class HeDieuHanhService implements IPhoneMangementService<BusHeDieuHanhModel, Integer> {

    @Override
    public void insert(BusHeDieuHanhModel entity) {
         try {
            this.selectBySql(INSERT, entity.getTenHeDieuHanh(),entity.isTrangThai());
        } catch (Exception e) {

        }
    }

    @Override
    public void update(BusHeDieuHanhModel entity) {
          try {
            this.selectBySql(UPDATE,
                    entity.getTenHeDieuHanh(),
      
                    entity.isTrangThai(),
                    entity.getMaHeDieuHanh()
            );
        } catch (Exception e) {
        }
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BusHeDieuHanhModel selectByID(Integer id) {
        if (this.selectBySql(SELECT_BY_ID,id).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_ID,id).get(0);
    }

    @Override
    public List<BusHeDieuHanhModel> selectAll() {
        if (this.selectBySql(SELECT_ALL).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_ALL);
    }
    public List<BusHeDieuHanhModel> selectAllDSD() {
        if (this.selectBySql(SELECT_BY_STATUS, 1).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 1);
    }

    public List<BusHeDieuHanhModel> selectAllNSD() {
        if (this.selectBySql(SELECT_BY_STATUS, 0).isEmpty()) {
            return null;
        }
        return this.selectBySql(SELECT_BY_STATUS, 0);
    }
    public static void fillCombo(DefaultComboBoxModel<BusHeDieuHanhModel> model, JComboBox cbo, List<BusHeDieuHanhModel> list) {
        HeDieuHanhService heDieuHanhService = new HeDieuHanhService();
        model = (DefaultComboBoxModel) cbo.getModel();
        model.removeAllElements();
        try {
            list = heDieuHanhService.selectAllDSD();
            if (list != null) {
                for (BusHeDieuHanhModel bus : list) {
                    model.addElement(bus);
                }
            }
            cbo.getModel().setSelectedItem(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<BusHeDieuHanhModel> selectBySql(String sql, Object... args) {
        List<BusHeDieuHanhModel> listCam = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.executeQuery(sql, args);
            while (rs.next()) {
                BusHeDieuHanhModel heDieuHanhModel = new BusHeDieuHanhModel(
                        rs.getInt("MaHeDieuHanh"),
                        rs.getString("TenHeDieuHanh"),
                        rs.getBoolean("TrangThai")
                );
                listCam.add(heDieuHanhModel);
            }
            rs.getStatement().getConnection().close();
            return listCam;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
