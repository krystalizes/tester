
package model;


public class Giohang {
    private int id;
    private String ten;
    private String anh;
    private double gia;
    private int soluong;

    public Giohang(int id, String ten, String anh, double gia, int soluong) {
        this.id = id;
        this.ten = ten;
        this.anh = anh;
        this.gia = gia;
        this.soluong = soluong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    @Override
    public String toString() {
        return "Giohang{" + "id=" + id + ", ten=" + ten + ", anh=" + anh + ", gia=" + gia + ", soluong=" + soluong + '}';
    }

    
    
}
