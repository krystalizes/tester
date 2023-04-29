<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Quản lý cấu hình</title>
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
                <h2><b>Cấu hình</b></h2>               			
            </div>  
            <table border="0px" width="100%"  class="container" id="tbl">
                <tr>
                    <th>ID</th>
                    <th>MỐC ĐIỆN</th>                 
                    <th>GIÁ</th>                   
                    <th></th>
                </tr>
                <c:forEach items="${listp}" var="o">
                    <tr>                        
                        <td>${o.id}</td>
                        <td>${o.mocdien}</td>                       
                        <td>${o.gia} đ</td>                       
                        <td>
                            <button  class="btn" ><a  href="LoadeditConfig?pid=${o.id}"><i class="ti-pencil"></i></a> </button>                            
                        </td>
                    </tr>
                </c:forEach>    
            </table>
        </center>
    </div>
    </section>
    
</body>
</html>