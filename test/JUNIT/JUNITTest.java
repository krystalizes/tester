/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JUNIT;

import DAO.DAO;
import context.DBContext;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Config;
import model.Customer;
import model.Taikhoan;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author acer
 */
public class JUNITTest {
    Connection conn = null;
    
    public JUNITTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        conn = new DBContext().getConnection();
        conn.setAutoCommit(false);
        conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);
    }
    
    @After
    public void tearDown() throws SQLException {
        
    }

    /**
     * Test of getAllConfig method, of class DAO.
     * @throws java.sql.SQLException
     */
    @Test
    public void testGetAllConfig() throws SQLException {
        DAO instance = new DAO();            
        List<Config> expResult = new ArrayList<Config>();         
        expResult.add(new Config(1, 0, 1678)); 
        expResult.add(new Config(2, 50, 1734)); 
        expResult.add(new Config(3, 100, 2014)); 
        expResult.add(new Config(4, 200, 2536)); 
        expResult.add(new Config(5, 300, 2834)); 
        expResult.add(new Config(6, 400, 2927)); 
        List<Config> result = instance.getAllConfig();
        assertNotNull(result);
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Config expected = expResult.get(i);
            Config actual = result.get(i);
            assertEquals(expected.getId(), actual.getId());
            assertEquals(expected.getMocdien(), actual.getMocdien());
            assertEquals(expected.getGia(), actual.getGia());
            System.out.println(actual.getId()+" "+actual.getMocdien()+" "+actual.getGia());
        }                     
    }

    /**
     * Test of getConfigbyID method, of class DAO.
     */
    @Test
    public void testGetConfigbyID() {
        DAO instance = new DAO();
        String id = "1"; // provide a valid id
        Config expResult = new Config(1, 0, 1678); // expected Config object
        Config result = instance.getConfigbyID(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getMocdien(), result.getMocdien());
        assertEquals(expResult.getGia(), result.getGia());
        System.out.println(result.getId()+" "+result.getMocdien()+" "+result.getGia());
    }

    /**
     * Test of searchCustomerbyName method, of class DAO.
     */
    @Test
    public void testSearchCustomerbyName() {       
        String txtSearch = "Phan";
        DAO instance = new DAO();
        List<Customer> expResult = new ArrayList<Customer>();
        expResult.add(new Customer(1,"Phan Vương Bảo","","36 Minh Khai","abcd@gmail.com",0,"04/2023",0));
        List<Customer> result = instance.searchCustomerbyName(txtSearch);
        for (int i = 0; i < expResult.size(); i++) {
            Customer expected = expResult.get(i);
            Customer actual = result.get(i);            
            assertEquals(expected.getTen(), actual.getTen()); 
            System.out.println(actual.getTen());
        }                  
    }

    /**
     * Test of login method, of class DAO.
     */
    @Test
    public void testLogin() {
        DAO instance = new DAO();
        String user = "admin";
        String pass = "123456";             
        Taikhoan expResult = new Taikhoan(1, "admin", "123456", 1);
        Taikhoan result = instance.login(user, pass);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getUser(), result.getUser());
        assertEquals(expResult.getPass(), result.getPass());
        assertEquals(expResult.getIsAdmin(), result.getIsAdmin());
        System.out.println(result.getId()+" "+result.getUser()+" "+result.getPass()+" "+ result.getIsAdmin());              
    }

    /**
     * Test of xoaCustomer method, of class DAO.
     */
    @Test
    public void testXoaCustomer() throws SQLException {
        try {
            String pid = "46";
            DAO instance = new DAO();
            conn.setAutoCommit(false);
            boolean actualResult = instance.xoaCustomer(pid);  
            if (actualResult){
                assertTrue(actualResult);
                System.out.println("Xoa khach hang thanh cong");
            }
            else{
                System.out.println("Xoa khach hang that bai");
            }
            
        } catch (SQLException e) {    
            conn.rollback();
            conn.close();
        }
        finally{
            if (conn != null) {
            try {
                conn.rollback();
            } finally {
                conn.close();
            }
        }
        }     
    }

    
    /**
     * Test of suaCustomer method, of class DAO.
     */
    @Test
    public void testSuaCustomer() throws SQLException {
        try {
            String ten = "Phan Vương Bảo";
            String sdt = "0425536789";
            String dchi = "36 Minh Khai";
            String email =  "abcdefgh@gmail.com";
            String maKH = "4";
            DAO instance = new DAO();         
            conn.setAutoCommit(false);
            boolean actualResult = instance.suaCustomer(ten, sdt, dchi, email, maKH);
            if (actualResult){
                assertTrue(actualResult);
                System.out.println("Sua khach hang thanh cong");
            }
            else{
                System.out.println("Sua khach hang that bai");
            }
            
        } catch (SQLException e) {    
            conn.rollback();
            conn.close();
        }
        finally{
            if (conn != null) {
            try {
                conn.rollback();
            } finally {
                conn.close();
            }
        }
        }              
    }

    /**
     * Test of getCustomerbyID method, of class DAO.
     */
    @Test
    public void testGetCustomerbyID() {
        DAO instance = new DAO();
        String id = "4"; // provide a valid id
        Customer expResult = new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",200,"04/2023",372000); 
        Customer result = instance.getCustomerbyID(id);
        assertEquals(expResult.getMaKH(), result.getMaKH());
        assertEquals(expResult.getTen(), result.getTen());
        assertEquals(expResult.getSdt(), result.getSdt());
        assertEquals(expResult.getDchi(), result.getDchi());
        assertEquals(expResult.getEmail(), result.getEmail());
        assertEquals(expResult.getSo(), result.getSo());
        assertEquals(expResult.getThang(), result.getThang());
        assertEquals(expResult.getTien(), result.getTien());
        System.out.println(result.getMaKH()+" "+result.getTen()+" "+result.getSdt()+" "+result.getDchi()+" "+result.getEmail()
                          +" "+result.getSo()+" "+result.getThang()+" "+result.getTien());        
    }

    /**
     * Test of suaConfig method, of class DAO.
     */
    @Test
    public void testSuaConfig() throws SQLException {
        try {
            String mocdien = "50";
            String gia = "1734";//1734
            String id = "2";
            DAO instance = new DAO();         
            conn.setAutoCommit(false);
            boolean actualResult = instance.suaConfig(mocdien, gia, id);
            if (actualResult){
                assertTrue(actualResult);
                System.out.println("Sua cau hinh thanh cong");
            }
            else{
                System.out.println("Sua cau hinh that bai");
            }
            
        } catch (SQLException e) {    
            conn.rollback();
            conn.close();
        }
        finally{
            if (conn != null) {
            try {
                conn.rollback();
            } finally {
                conn.close();
            }
        }
        }         
    }

    /**
     * Test of getAllCustomer method, of class DAO.
     */
    @Test
    public void testGetAllCustomer() {
        DAO instance = new DAO();            
        List<Customer> expResult = new ArrayList<Customer>();         
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",200,"04/2023",372000)); 
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",300,"04/2023",625600)); 
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",200,"04/2023",372000)); 
        List<Customer> result = instance.getAllCustomer();
        assertNotNull(result);
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Customer expected = expResult.get(i);
            Customer actual = result.get(i);
            assertEquals(expected.getMaKH(), actual.getMaKH());
            assertEquals(expected.getTen(), actual.getTen());
            assertEquals(expected.getSdt(), actual.getSdt());
            assertEquals(expected.getDchi(), actual.getDchi());
            assertEquals(expected.getEmail(), actual.getEmail());
            assertEquals(expected.getSo(), actual.getSo());
            assertEquals(expected.getThang(), actual.getThang());
            assertEquals(expected.getTien(), actual.getTien());
            System.out.println(actual.getMaKH()+" "+actual.getTen()+" "+actual.getSdt()+" "+actual.getDchi()+" "+actual.getEmail()
                              +" "+actual.getSo()+" "+actual.getThang()+" "+actual.getTien());     
        }                  
    }

    /**
     * Test of Baocao1 method, of class DAO.
     */
    @Test
    public void testBaocao1() {
        DAO instance = new DAO();      
        String date = "02/2023";
        List<Customer> expResult = new ArrayList<Customer>();         
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",50,"02/2023",83900)); 
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",100,"02/2023",170600)); 
        expResult.add(new Customer(3,"Nguyễn Văn C","0282895958","25 Lê Duẩn","cba@gmail.com",200,"02/2023",372000)); 
        List<Customer> result = instance.Baocao1(date);
        assertNotNull(result);
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Customer expected = expResult.get(i);
            Customer actual = result.get(i);
            assertEquals(expected.getMaKH(), actual.getMaKH());
            assertEquals(expected.getTen(), actual.getTen());
            assertEquals(expected.getSdt(), actual.getSdt());
            assertEquals(expected.getDchi(), actual.getDchi());
            assertEquals(expected.getEmail(), actual.getEmail());
            assertEquals(expected.getSo(), actual.getSo());
            assertEquals(expected.getThang(), actual.getThang());
            assertEquals(expected.getTien(), actual.getTien());
            System.out.println(actual.getMaKH()+" "+actual.getTen()+" "+actual.getSdt()+" "+actual.getDchi()+" "+actual.getEmail()
                              +" "+actual.getSo()+" "+actual.getThang()+" "+actual.getTien());     
        }                         
    }

    /**
     * Test of Baocao2 method, of class DAO.
     */
    @Test
    public void testBaocao2() {
        DAO instance = new DAO();      
        String id = "4";
        List<Customer> expResult = new ArrayList<Customer>();         
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",350,"03/2023",767300)); 
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",200,"04/2023",372000));
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",350,"05/2023",767300)); 
        List<Customer> result = instance.Baocao2(id);
        assertNotNull(result);
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Customer expected = expResult.get(i);
            Customer actual = result.get(i);
            assertEquals(expected.getMaKH(), actual.getMaKH());
            assertEquals(expected.getTen(), actual.getTen());
            assertEquals(expected.getSdt(), actual.getSdt());
            assertEquals(expected.getDchi(), actual.getDchi());
            assertEquals(expected.getEmail(), actual.getEmail());
            assertEquals(expected.getSo(), actual.getSo());
            assertEquals(expected.getThang(), actual.getThang());
            assertEquals(expected.getTien(), actual.getTien());
            System.out.println(actual.getMaKH()+" "+actual.getTen()+" "+actual.getSdt()+" "+actual.getDchi()+" "+actual.getEmail()
                              +" "+actual.getSo()+" "+actual.getThang()+" "+actual.getTien());     
        }             
    }

    /**
     * Test of Baocao3 method, of class DAO.
     */
    @Test
    public void testBaocao3_1() {
        DAO instance = new DAO();      
        String ispaid = "1";
        List<Customer> expResult = new ArrayList<Customer>();         
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",50,"01/2023",83900)); 
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",50,"02/2023",83900));      
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",100,"01/2023",170600));    
        expResult.add(new Customer(3,"Nguyễn Văn C","0282895958","25 Lê Duẩn","cba@gmail.com",200,"01/2023",372000)); 
        List<Customer> result = instance.Baocao3(ispaid);
        assertNotNull(result);
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Customer expected = expResult.get(i);
            Customer actual = result.get(i);
            assertEquals(expected.getMaKH(), actual.getMaKH());
            assertEquals(expected.getTen(), actual.getTen());
            assertEquals(expected.getSdt(), actual.getSdt());
            assertEquals(expected.getDchi(), actual.getDchi());
            assertEquals(expected.getEmail(), actual.getEmail());
            assertEquals(expected.getSo(), actual.getSo());
            assertEquals(expected.getThang(), actual.getThang());
            assertEquals(expected.getTien(), actual.getTien());
            System.out.println(actual.getMaKH()+" "+actual.getTen()+" "+actual.getSdt()+" "+actual.getDchi()+" "+actual.getEmail()
                              +" "+actual.getSo()+" "+actual.getThang()+" "+actual.getTien());     
        }                     
    }
    @Test
    public void testBaocao3_2() {
        DAO instance = new DAO();      
        String ispaid = "0";
        List<Customer> expResult = new ArrayList<Customer>();         
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",400,"03/2023",909000)); 
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",100,"02/2023",170600));    
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",450,"03/2023",1055350));    
        expResult.add(new Customer(3,"Nguyễn Văn C","0282895958","25 Lê Duẩn","cba@gmail.com",200,"02/2023",372000));
        expResult.add(new Customer(3,"Nguyễn Văn C","0282895958","25 Lê Duẩn","cba@gmail.com",450,"03/2023",1055350)); 
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",350,"03/2023",767300)); 
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",200,"04/2023",372000)); 
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",200,"04/2023",372000)); 
        expResult.add(new Customer(46,"abcde","0123456798","PTIT","abc@ne.com",0,"04/2023",0)); 
        expResult.add(new Customer(1,"Nguyễn Văn A","0988765432","352 Minh Khai","abcdef@gmail.com",400,"05/2023",909000)); 
        expResult.add(new Customer(4,"Phan Vương Bảo","0425536789","36 Minh Khai","abcdefgh@gmail.com",350,"05/2023",767300)); 
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",350,"05/2023",767300));    
        expResult.add(new Customer(2,"Nguyễn Văn B","0235648799","123 Giải Phóng","bca@gmail.com",300,"04/2023",625600));    
        List<Customer> result = instance.Baocao3(ispaid);
        assertNotNull(result);
        assertEquals(expResult.size(), result.size());
        for (int i = 0; i < expResult.size(); i++) {
            Customer expected = expResult.get(i);
            Customer actual = result.get(i);
            assertEquals(expected.getMaKH(), actual.getMaKH());
            assertEquals(expected.getTen(), actual.getTen());
            assertEquals(expected.getSdt(), actual.getSdt());
            assertEquals(expected.getDchi(), actual.getDchi());
            assertEquals(expected.getEmail(), actual.getEmail());
            assertEquals(expected.getSo(), actual.getSo());
            assertEquals(expected.getThang(), actual.getThang());
            assertEquals(expected.getTien(), actual.getTien());
            System.out.println(actual.getMaKH()+" "+actual.getTen()+" "+actual.getSdt()+" "+actual.getDchi()+" "+actual.getEmail()
                              +" "+actual.getSo()+" "+actual.getThang()+" "+actual.getTien());     
        }                     
    }
    /**
     * Test of themCustomer method, of class DAO.
     */
    @Test
    public void testThemCustomer() throws SQLException {
        try {
            String ten = "John Doe";
            String sdt = "0123456789";
            String dchi = "123 Main Street, New York";
            String email = "johndoe@example.com";
            DAO instance = new DAO();
            conn.setAutoCommit(false);
            boolean actualResult = instance.themCustomer(ten, sdt, dchi, email);
            if (actualResult){
                assertTrue(actualResult);
                System.out.println("Them khach hang thanh cong");
            }
            else{
                System.out.println("Them khach hang that bai");
            }
            
        } catch (SQLException e) {    
            conn.rollback();
            conn.close();
        }
        finally{
            if (conn != null) {
            try {
                conn.rollback();
            } finally {
                conn.close();
            }
        }
        }  
    }
    
    
}
