/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL.Models;

/**
 *
 * @author ADMIN
 */
public class DalImeiModel {
    private int maImei;
    private int maCtsp;
    private int maSpSale;
    private String tenImei;
    private boolean trangThaiBan;
    private boolean trangThai;
    private String ghiChu;

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTrangThaiBan() {
        return trangThaiBan;
    }

    public void setTrangThaiBan(boolean trangThaiBan) {
        this.trangThaiBan = trangThaiBan;
    }

    public int getMaImei() {
        return maImei;
    }

    public void setMaImei(int maImei) {
        this.maImei = maImei;
    }

    public int getMaCtsp() {
        return maCtsp;
    }

    public void setMaCtsp(int maCtsp) {
        this.maCtsp = maCtsp;
    }

    public int getMaSpSale() {
        return maSpSale;
    }

    public void setMaSpSale(int maSpSale) {
        this.maSpSale = maSpSale;
    }

    public String getTenImei() {
        return tenImei;
    }

    public void setTenImei(String tenImei) {
        this.tenImei = tenImei;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenImei;
    }
    
    
}
