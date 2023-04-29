
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Giohang;
import model.Config;
import model.Customer;
import model.Sanpham;
import model.Taikhoan;
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Config> getAllConfig() {
        List<Config> list = new ArrayList<>();
        String query = "select * from config";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Config(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Config getConfigbyID(String id) {
        String query = "select * from config where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Config(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    public List<Customer> searchCustomerbyName(String txtSearch) {
        List<Customer> list = new ArrayList<>();
        String query =  "SELECT customer.maKH, customer.ten, customer.sdt, customer.dchi, customer.email, sodien.so, sodien.thang, sodien.tien\n" +
                        "FROM tester.customer\n" +
                        "INNER JOIN tester.sodien ON sodien.customerid = customer.maKH and DATE_FORMAT(NOW(), '%m/%Y')=sodien.thang and ten like ?;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Taikhoan login(String user, String pass){
        String query = "select * from account where user = ? and pass = ?";       
        try {
            conn = new DBContext().getConnection();          
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Taikhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                      
                        rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
        
    }
    public boolean xoaCustomer(String pid){
        String query = "update customer set is_deleted=1 where maKH=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,pid);         
            int rowsAffected = ps.executeUpdate();          
            return (rowsAffected > 0);    
        } catch (Exception e) {
            return false;
        }    
    }
    public boolean themCustomer(String ten, String sdt, String dchi, String email){
        String query = "insert into customer (ten, sdt, dchi, email) VALUES (?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,ten); 
            ps.setString(2,sdt);       
            ps.setString(3,dchi);       
            ps.setString(4,email);                       
            int rowsAffected = ps.executeUpdate();          
            return (rowsAffected > 0);    
        } catch (Exception e) {
            return false;
        }    
    }
    public boolean suaCustomer(String ten, String sdt, String dchi, String email, String maKH){
        String query="update customer set ten=?, sdt=?, dchi=?, email=? where maKH=?";
        try{ 
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, ten);
            ps.setString(2, sdt); 
            ps.setString(3, dchi); 
            ps.setString(4, email); 
            ps.setString(5, maKH); 
            int rowsAffected = ps.executeUpdate();          
            return (rowsAffected > 0);   
        }catch (Exception e){
            return false;
        }
    }
    public Customer getCustomerbyID(String id) {
        String query =  "SELECT customer.maKH, customer.ten, customer.sdt, customer.dchi, customer.email, sodien.so, sodien.thang, sodien.tien\n" +
                        "FROM tester.customer\n" +
                        "INNER JOIN tester.sodien ON sodien.customerid = customer.maKH and DATE_FORMAT(NOW(), '%m/%Y')=sodien.thang and is_deleted=0 and maKH=?;" ;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8));
            }
        } catch (Exception e) {
        }
        return null;
    }
    
    
    public boolean suaConfig(String mocdien, String gia, String id){
        String query="update config set mocdien=?, gia=? where id=?";
        try{ 
            conn=new DBContext().getConnection();
            ps=conn.prepareStatement(query);
            ps.setString(1, mocdien);
            ps.setString(2, gia); 
            ps.setString(3, id); 
            int rowsAffected = ps.executeUpdate();          
            return (rowsAffected > 0);   
        }catch (Exception e){
            return false;
        }
    }
    public List<Customer> getAllCustomer() {
        List<Customer> list = new ArrayList<>();
        String query =  "SELECT customer.maKH, customer.ten, customer.sdt, customer.dchi, customer.email, sodien.so, sodien.thang, sodien.tien\n" +
                        "FROM tester.customer\n" +
                        "INNER JOIN tester.sodien ON sodien.customerid = customer.maKH and DATE_FORMAT(NOW(), '%m/%Y')=sodien.thang and is_deleted=0;" ;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }   
    public List<Customer> Baocao1(String date) {
        List<Customer> list = new ArrayList<>();
        String query =  "SELECT customer.maKH, customer.ten, customer.sdt, customer.dchi, customer.email, sodien.so, sodien.thang, sodien.tien\n" +
                        "FROM tester.customer\n" +
                        "INNER JOIN tester.sodien ON sodien.customerid = customer.maKH and sodien.thang=?;" ;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }  
    public List<Customer> Baocao2(String id) {
        List<Customer> list = new ArrayList<>();
        String query =  "SELECT customer.maKH, customer.ten, customer.sdt, customer.dchi, customer.email, sodien.so, sodien.thang, sodien.tien\n" +
                        "FROM tester.customer\n" +
                        "INNER JOIN tester.sodien ON sodien.customerid = customer.maKH and customer.maKH=?;" ;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    } 
    public List<Customer> Baocao3(String i) {
        List<Customer> list = new ArrayList<>();
        String query =  "SELECT customer.maKH, customer.ten, customer.sdt, customer.dchi, customer.email, sodien.so, sodien.thang, sodien.tien\n" +
                        "FROM tester.customer\n" +
                        "INNER JOIN tester.sodien ON sodien.customerid = customer.maKH and sodien.is_paid=?;" ;
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, i);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Customer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
        } catch (Exception e) {
        }
        return list;
    } 
        
}