/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;
import java.time.Duration;
import java.util.List;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author acer
 */
public class Main {
    private WebDriver driver;

    @Before
    public void setUp() {
        // Set the path to the chromedriver executable
        System.setProperty("webdriver.chrome.driver", "D:\\selenium webdriver\\chromedriver_win32\\chromedriver.exe");
        // Create a new ChromeDriver instance
        driver = new ChromeDriver();
        
    }
    @Test
    public void testLogin() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/tester/Trangchu"));       
    }
    
    @Test
    public void testLogout() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement logoutButton = driver.findElement(By.id("logoutbtn"));
        logoutButton.click();       
        WebElement dangnhap = driver.findElement(By.id("dangnhap"));
        boolean isDisplayed = dangnhap.isDisplayed();        
        assertTrue(driver.getCurrentUrl().equals("http://localhost:8080/tester/Trangchu"));
        assertTrue(isDisplayed);
    }
    
    @Test
    public void testLoadCustomerList() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement customerButton = driver.findElement(By.id("customerlist"));
        customerButton.click();
        WebElement customerList = driver.findElement(By.id("tbl"));
        List<WebElement> customerRows = customerList.findElements(By.tagName("tr"));
        assertTrue(customerRows.size() > 1);
        // Optional: check that the customer information is correct
//        for (WebElement customerRow : customerRows) {
//            String name = customerRow.findElement(By.className("name")).getText();
//            String email = customerRow.findElement(By.className("email")).getText();
//            // Assert that the name and email are not empty
//            assertFalse(name.isEmpty());
//            assertFalse(email.isEmpty());
//        }
    }
    
    @Test
    public void testLoadConfigList() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();     
        WebElement configButton = driver.findElement(By.id("configlist"));
        configButton.click();
        WebElement customerList = driver.findElement(By.id("tbl"));
        List<WebElement> customerRows = customerList.findElements(By.tagName("tr"));
        assertTrue(customerRows.size() == 7);   
    }
    
    @Test
    public void testLoadEditConfig() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement configButton = driver.findElement(By.id("configlist"));
        configButton.click();
        WebElement editButton = driver.findElement(By.xpath("//a[@href='LoadeditConfig?pid=1']/i[@class='ti-pencil']"));
        editButton.click();     
        WebElement idField = driver.findElement(By.id("id"));
        assertEquals("1",idField.getAttribute("value"));     
        WebElement mocdienField = driver.findElement(By.id("mocdien"));
        assertEquals("0",mocdienField.getAttribute("value"));
        WebElement giaField = driver.findElement(By.id("gia"));
        assertEquals("1678",giaField.getAttribute("value"));
    }
    
    @Test
    public void testEditConfig() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement configButton = driver.findElement(By.id("configlist"));
        configButton.click();
        WebElement editButton = driver.findElement(By.xpath("//a[@href='LoadeditConfig?pid=1']/i[@class='ti-pencil']"));
        editButton.click();           
        WebElement giaField= driver.findElement(By.id("gia"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value=1678;", giaField);
        WebElement saveButton = driver.findElement(By.id("luu"));
        saveButton.click();
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (!cells.isEmpty() && cells.get(0).getText().equals("1")) {
                assertEquals("1678 đ", cells.get(2).getText());                
                break;
            }
        }
    }
    
    @Test
    public void testLoadEditCustomer() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement customerButton = driver.findElement(By.id("customerlist"));
        customerButton.click();       
        WebElement editButton = driver.findElement(By.xpath("//a[@href='LoadeditCustomer?pid=1']/i[@class='ti-pencil']"));
        editButton.click();     
        WebElement idField = driver.findElement(By.id("id"));
        assertEquals("1",idField.getAttribute("value"));     
        WebElement tenField = driver.findElement(By.id("ten"));
        assertEquals("Nguyễn Văn A",tenField.getAttribute("value"));
        WebElement sdtField = driver.findElement(By.id("sdt"));
        assertEquals("0988765432",sdtField.getAttribute("value"));
        WebElement dchiField = driver.findElement(By.id("dchi"));
        assertEquals("352 Minh Khai",dchiField.getAttribute("value"));
        WebElement emailField = driver.findElement(By.id("email"));
        assertEquals("abcdef@gmail.com",emailField.getAttribute("value"));
    }
    

    @Test
    public void testEditCustomer() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement customerButton = driver.findElement(By.id("customerlist"));
        customerButton.click();       
        WebElement editButton = driver.findElement(By.xpath("//a[@href='LoadeditCustomer?pid=1']/i[@class='ti-pencil']"));
        editButton.click();       
        WebElement emailField= driver.findElement(By.id("email"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='abcdef@gmail.com';", emailField);
        WebElement saveButton = driver.findElement(By.id("luu"));
        saveButton.click();
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (!cells.isEmpty() && cells.get(0).getText().equals("1")) {
                assertEquals("abcdef@gmail.com", cells.get(4).getText());                
                break;
            }
        }
    }
    
    @Test
    public void testSearchCustomer() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement customerButton = driver.findElement(By.id("customerlist"));
        customerButton.click();              
        WebElement searchField= driver.findElement(By.id("search"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='phan';", searchField);
        WebElement searchButton = driver.findElement(By.id("searchbtn"));
        searchButton.click();
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (!cells.isEmpty() && !cells.get(0).getText().equals("TÊN")) {
                String cell1Value = cells.get(1).getText().toLowerCase();
                System.out.println(cell1Value);                       
                assertTrue(cell1Value.contains("phan"));                         
            }
        }
    }
    
    @Test
    public void testDeleteCustomer() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement customerButton = driver.findElement(By.id("customerlist"));
        customerButton.click(); 
        WebElement searchField= driver.findElement(By.id("search"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='';", searchField);
        WebElement searchButton = driver.findElement(By.id("searchbtn"));
        searchButton.click();
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a =rows.size();
        WebElement deleteButton = driver.findElement(By.xpath("//a[@href='DeleteCustomer?pid=46']/i[@class='ti-trash']"));
        deleteButton.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Bạn có chắc chắn muốn xoá không?", alert.getText());
        alert.accept();// click "Cancel"        
        WebElement table1 = driver.findElement(By.id("tbl"));
        List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
        int b=rows1.size();
        assertTrue(b==a-1);
    }
    
    @Test
    public void testLoadBaocao1() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement baocaoButton = driver.findElement(By.id("baocao"));
        baocaoButton.click();  
        WebElement baocao1Button = driver.findElement(By.id("baocao1"));
        baocao1Button.click(); 
        WebElement monthsDropdown = driver.findElement(By.id("months"));
        WebElement yearsDropdown = driver.findElement(By.id("years"));
        Select monthsSelect = new Select(monthsDropdown);
        monthsSelect.selectByValue("02");
        Select yearsSelect = new Select(yearsDropdown);
        yearsSelect.selectByVisibleText("2023");
        WebElement seeButton = driver.findElement(By.id("see"));
        seeButton.click();        
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));      
        assertTrue(rows.size()==4);
    }
    
    @Test
    public void testLoadBaocao2() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement baocaoButton = driver.findElement(By.id("baocao"));
        baocaoButton.click();  
        WebElement baocao2Button = driver.findElement(By.id("baocao2"));
        baocao2Button.click(); 
        WebElement searchField= driver.findElement(By.id("search"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='phan';", searchField);
        WebElement searchButton = driver.findElement(By.id("searchbtn"));
        searchButton.click();             
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));      
        for(WebElement row : rows){
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (!cells.isEmpty() && cells.get(1).getText().equals("Phan Vương Bảo")) {
                WebElement link = driver.findElement(By.xpath("//a[@href='Loadbaocao2?pid=4']"));
                link.click();
                WebElement table1 = driver.findElement(By.id("tbl"));
                List<WebElement> rows1 = table1.findElements(By.tagName("tr"));    
                System.out.println(rows1.size());
                assertTrue(rows1.size()==4);  
                break;
            }
        }
    }
    
    @Test
    public void testLoadBaocao3_1() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement baocaoButton = driver.findElement(By.id("baocao"));
        baocaoButton.click();  
        WebElement baocao3Button = driver.findElement(By.id("baocao3"));
        baocao3Button.click(); 
        WebElement paidDropdown = driver.findElement(By.id("paid"));
        Select paidSelect = new Select(paidDropdown);
        paidSelect.selectByValue("Chưa đóng");
        WebElement seeButton = driver.findElement(By.id("see"));
        seeButton.click();             
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));      
        assertTrue(rows.size()>1);
    }
    
     @Test
    public void testLoadBaocao3_2() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement baocaoButton = driver.findElement(By.id("baocao"));
        baocaoButton.click();  
        WebElement baocao3Button = driver.findElement(By.id("baocao3"));
        baocao3Button.click(); 
        WebElement paidDropdown = driver.findElement(By.id("paid"));
        Select paidSelect = new Select(paidDropdown);
        paidSelect.selectByValue("Đã đóng");
        WebElement seeButton = driver.findElement(By.id("see"));
        seeButton.click();             
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));      
        assertTrue(rows.size()>1);
    }
    
    @Test
    public void testAddCustomer() {
        driver.get("http://localhost:8080/tester/Login");      
        WebElement usernameField = driver.findElement(By.id("user"));
        usernameField.sendKeys("admin");
        WebElement passwordField = driver.findElement(By.id("pass"));
        passwordField.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.id("loginbtn"));
        loginButton.click();       
        WebElement customerButton = driver.findElement(By.id("customerlist"));
        customerButton.click();  
        WebElement table = driver.findElement(By.id("tbl"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int a =rows.size();
        WebElement addButton = driver.findElement(By.id("btn-open"));
        addButton.click();  
        WebElement tenField= driver.findElement(By.id("ten2"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].value='Nguyễn Đình Quân';", tenField);
        WebElement sdtField= driver.findElement(By.id("sdt2"));        
        executor.executeScript("arguments[0].value='0903123456';", sdtField);
        WebElement dchiField= driver.findElement(By.id("dchi2"));
        executor.executeScript("arguments[0].value='PTIT';", dchiField);
        WebElement emailField= driver.findElement(By.id("email2"));
        executor.executeScript("arguments[0].value='ABC@gmail.com';", emailField);
        WebElement saveButton = driver.findElement(By.id("luu"));
        saveButton.click();
        WebElement table1 = driver.findElement(By.id("tbl"));
        List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
        int b=rows1.size();
        assertTrue(a==b-1);
    }


    
    @After
    public void tearDown() {
        // Quit the browser
        driver.quit();
    }
    
}
