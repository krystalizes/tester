/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author acer
 */
public class Customer {
    public int maKH;
    public String ten;
    public String sdt;
    public String dchi;
    public String email;
    public int so;
    public String thang;
    public int tien;

    public Customer() {
    }

    public Customer(int maKH, String ten, String sdt, String dchi, String email, int so, String thang, int tien) {
        this.maKH = maKH;
        this.ten = ten;
        this.sdt = sdt;
        this.dchi = dchi;
        this.email = email;
        this.so = so;
        this.thang = thang;
        this.tien = tien;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSo() {
        return so;
    }

    public void setSo(int so) {
        this.so = so;
    }

    public String getThang() {
        return thang;
    }

    public void setThang(String thang) {
        this.thang = thang;
    }

    public int getTien() {
        return tien;
    }

    public void setTien(int tien) {
        this.tien = tien;
    }
    
     @Override
    public String toString() {
        return "Customer{" + "maKH=" + maKH + ", Ten=" + ten + ", sdt=" + sdt +  ", dchi=" + dchi +  ", email=" + email +  ", so=" + so +  ", thang=" + thang +  ", tien=" + tien + '}';
    }
}
