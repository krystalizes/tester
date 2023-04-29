<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xem báo cáo</title>
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
                <h2><b>CHỌN LOẠI BÁO CÁO</b></h2>               			
            </div>  
            <div class="giua">    
                <a class="b2" id="baocao1" href="/tester/Baocao1" style="margin-left: 0px;">BÁO CÁO SỐ ĐIỆN SỬ DỤNG THEO THÁNG </a>
                <a class="b2" id="baocao2" href="/tester/Baocao2">BÁO CÁO SỐ ĐIỆN SỬ DỤNG CỦA TỪNG HỘ TỪ TRƯỚC ĐẾN NAY</a>
                <a class="b2" id="baocao3" href="/tester/Baocao3">BÁO CÁO CÁC HỘ ĐÃ ĐÓNG TIỀN HOẶC CHƯA ĐÓNG</a>
            </div>
        </center>
    </div> 
    </section>
    
</body>
</html>
