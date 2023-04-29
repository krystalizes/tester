<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="/tester/icon/themify-icons-font/themify-icons/themify-icons.css">
    <style>
     <%@ include file="/css/adminpage.css"%>
    </style>
    <script src="js/modal.js"></script> 
</head>
<body>
    <div class="header">
        <a href="/tester/Trangchu"> <img  src="/tester/anh/evn_icon.png" class="logo" > </a>
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
                <h2><b>THÔNG BÁO NGẮT ĐIỆN</b></h2>               			
            </div>  
            <div class="giua">
                <div class="modal-body">
                <form action="/tester/GuiEmail" method="post" class="form1">
                    <div class="themsp">
                        <p>MÃ KH</p>
                        <input name="txt1" value="${detail.maKH}"  readonly class="ip">
                        <p>TÊN</p>
                        <input name="txt2" value="${detail.ten}" type="text" class="ip">
                        <P>SDT</p>
                        <input name="txt3" value="${detail.sdt}" type="text" class="ip">   
                        <p>ĐỊA CHỈ</p>
                        <input name="txt4" value="${detail.dchi}"  type="text" class="ip">
                        <p>EMAIL</p>
                        <input name="txt5" value="${detail.email}"  type="text" class="ip">
                        </div>
                        <div class="modal-footer">
                        <button  class="btn" id="luu" type="submit"><i class="ti-plus"> Lưu</i> </button>                             
                    </div>
                </form> 
                </div>
            </div>
        </center>
    </div>
</body>
</html>
