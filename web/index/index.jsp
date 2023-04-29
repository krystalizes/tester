<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Trang chủ</title>
    <style>
     <%@ include file="/css/base.css"%>
    </style>
    <link rel="stylesheet" href="/tester/icon/themify-icons-font/themify-icons/themify-icons.css">
    <script src="test.js"></script>
</head>
<body>
    <section>
        <div class="header">
        <a href="/tester/Trangchu"> <img  src="/tester/anh/Artboard 2.png" class="logo"> </a>
        <nav class="nav-bar">
            <div class="button-nav">                
                <c:if test="${sessionScope.taikhoan.isAdmin == 1}">
                    <style>
                        .nav-bar {
                            width: 85%;
                        }
                    </style>
                <button class="btn ">   <a class="b1" href="/tester/Trangchu">TRANG CHỦ</a></button>
                <button class="btn">    <a class="b1" href="/tester/Tbaoemail">THÔNG BÁO QUA EMAIL </a></button>
                <button class="btn" id="customerlist">    <a class="b1" href="/tester/LoadDanhsachCus">THEO DÕI DANH SÁCH</a></button>
                <button class="btn" id="baocao">    <a class="b1" href="/tester/Baocao">XEM BÁO CÁO</a></button>                
                <button class="btn" id="configlist">    <a class="b1" href="/tester/Configure">QUẢN LÝ CẤU HÌNH</a></button>
                 </c:if>
                <c:if test="${sessionScope.taikhoan != null}">         
                <!--<button class="btn" id="session">    <a class="b1" href="#" style="display:none;">Nhân viên:${sessionScope.taikhoan.user}</a></button>-->
                <button class="btn" id="logoutbtn">    <a class="b1" href="/tester/Logout">ĐĂNG XUẤT</a></button>
                </c:if>
                
                
            </div>
        </nav>      
        <c:if test="${sessionScope.taikhoan == null}">         
            <div class="log">
                <div class="dk-dn2" >   <a href="/tester/Login" id="dangnhap">ĐĂNG NHẬP</a> </div>
            </div>
        </c:if>
    </div>
    </section>
    
</body>
</html>