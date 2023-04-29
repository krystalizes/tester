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
public class Config {
    private int id;
    private int mocdien;
    private int gia;

    public Config() {
    }

    public Config(int id, int mocdien, int gia) {
        this.id = id;
        this.mocdien = mocdien;
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMocdien() {
        return mocdien;
    }

    public void setMocdien(int mocdien) {
        this.mocdien = mocdien;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
    
     @Override
    public String toString() {
        return "Config{" + "id=" + id + ", mocdien=" + mocdien + ", gia=" + gia + '}';
    }
    
    
}
