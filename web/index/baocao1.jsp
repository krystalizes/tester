<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Báo cáo 1</title>
    <link rel="stylesheet" href="/tester/icon/themify-icons-font/themify-icons/themify-icons.css">
    <style>
     <%@ include file="/css/adminpage.css"%>
    </style>
    <script src="js/modal.js"></script> 
</head>
<body>
    <section>
        <div class="header">
        <a href="/tester/Trangchu"> <img  src="/tester/anh/Artboard 2.png" class="logo" > </a>
        <nav class="nav-bar">
            <div class="button-nav">
                <c:if test="${sessionScope.taikhoan.isAdmin == 1}">                     
                <button class="btn ">   <a class="b1" href="/tester/Trangchu">TRANG CHỦ</a>  </button>
                <button class="btn">    <a class="b1" href="/tester/Tbaoemail">THÔNG BÁO QUA EMAIL </a>      </button>
                <button class="btn">    <a class="b1" href="/tester/LoadDanhsachCus">THEO DÕI DANH SÁCH</a>       </button>
                <button class="btn">    <a class="b1" href="/tester/Baocao">XEM BÁO CÁO</a>    </button>                
                <button class="btn">    <a class="b1" href="/tester/Configure">QUẢN LÝ CẤU HÌNH</a>         </button>
                 </c:if>
                <c:if test="${sessionScope.taikhoan != null}">         
                <!--<button class="btn">    <a class="b1" href="#">Nhân viên:${sessionScope.taikhoan.user}</a>      </button>-->
                <button class="btn">    <a class="b1" href="/tester/Logout">ĐĂNG XUẤT</a>      </button>
                </c:if>
            </div>
        </nav>
        <c:if test="${sessionScope.taikhoan == null}">         
                  <div class="dk-dn2"> <a href="/tester/Login">ĐĂNG NHẬP</a> </div>
        </c:if>
    </div>
    <div class="giua">
                  
        <center>
            <div class="tieude">
                <h2><b>BÁO CÁO SỐ ĐIỆN SỬ DỤNG THEO THÁNG</b></h2>               			
            </div>  
            <form action="Loadbaocao1" method="post">
                <label for="months">CHỌN THÁNG:</label>
                <select name="months" id="months">
                    <option value="01">01</option>
                    <option value="02">02</option>
                    <option value="03">03</option>
                    <option value="04">04</option>
                    <option value="05">05</option>
                    <option value="06">06</option>
                    <option value="07">07</option>
                    <option value="08">08</option>
                    <option value="09">09</option>
                    <option value="10">10</option>
                    <option value="11">11</option>
                    <option value="12">12</option>
                </select>
                <label for="years">CHỌN NĂM:</label>
                <select name="years" id="years">
                    <option value="2015">2015</option>
                    <option value="2016">2016</option>
                    <option value="2017">2017</option>
                    <option value="2018">2018</option>
                    <option value="2019">2019</option>
                    <option value="2020">2020</option>
                    <option value="2021">2021</option>
                    <option value="2022">2022</option>
                    <option value="2023">2023</option>                   
                </select>               
                <br><br>
                <input type="submit" value="Xem" id="see">
            </form>
            <table border="0px" width="100%"  class="container" id="tbl">
                <tr>
                    <th>MÃ KH</th>
                    <th>TÊN</th>                 
                    <th>SÐT</th> 
                    <th>ĐỊA CHỈ</th>
                    <th>EMAIL</th>
                    <th>SỐ</th>
                    <th>THÁNG</th>
                    <th>TIỀN</th>                   
                </tr>
                <c:forEach items="${listp}" var="o">
                    <tr>                        
                        <td>${o.maKH}</td>
                        <td>${o.ten}</td>
                        <td>${o.sdt}</td>
                        <td>${o.dchi}</td>
                        <td>${o.email}</td>
                        <td>${o.so}</td>
                        <td>${o.thang}</td>                       
                        <td>${o.tien} đ</td>                                              
                    </tr>
                </c:forEach>    
            </table>
        </center>
    </div>
    </section>
    
</body>
</html>
