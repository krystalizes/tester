
package model;


public class Sanpham {
    private int id;
    private String ten;
    private String anh;
    private double gia;
    private String chitiet;
    private String danhmuc;

    public String getDanhmuc() {
        return danhmuc;
    }

    public void setDanhmuc(String danhmuc) {
        this.danhmuc = danhmuc;
    }
   

    public Sanpham() {
    }

    public Sanpham(int id, String ten, String anh, double gia, String chitiet, String danhmuc) {
        this.id = id;
        this.ten = ten;
        this.anh = anh;
        this.gia = gia;
        this.chitiet = chitiet;
        this.danhmuc=danhmuc;
       
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

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    @Override
    public String toString() {
        return "Sanpham{" + "id=" + id + ", ten=" + ten + ", anh=" + anh + ", gia=" + gia + ", chitiet=" + chitiet + ", danhmuc=" + danhmuc + '}';
    }

   

    
    
}
