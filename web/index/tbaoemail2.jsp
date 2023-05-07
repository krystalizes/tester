<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin</title>
    <link rel="stylesheet" href="/tester/icon/themify-icons-font/themify-icons/themify-icons.css">
  
    <style>
     <%@ include file="/css/adminpage.css"%>
    </style>
    <script src="js/modal.js"></script> 
</head> 
<body>
    <section>
        <div class="header">
        <a href="/tester/Trangchu"> <img  src="/tester/anh/Artboard 2.png" class="logo"> </a>
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
                <form action="/tester/SendEmailController?id=1" method="post" class="form1">
                    <div style="display: flex; flex-direction: column; align-items: center;">
                    <p style="margin-right: 50px;">Bắt đầu từ <input name="time1" type="datetime-local" id="from-date" style="margin-right: 25px;"/> tới <input name="time2" type="datetime-local" id="to-date" style="margin-left: 25px;"/></p>
                    <p>Lí do <input name="reason" type="text" class="ip" style="width: 500px; margin-left: 20px;"></p>
                    <p>Khu vực <input name="area" type="text" class="ip" style="width: 500px"></p>
                    </div>
                </div>
                <button  class="btn" id="luu" type="submit" style="float: none; background: none; color: white; "> Gửi </button>    
                <div class="modal-footer">
                                             
                </div>  
                </form> 
                </div>
            </div>
        </center>
    </div>
    </section>
    
    <script>
        // Lấy các element input date
        var fromInput = document.getElementById('from-date');
        var toInput = document.getElementById('to-date');

        // Đặt giá trị min cho to-input là from-input + 1 ngày
        fromInput.addEventListener('change', function() {
        var fromValue = new Date(fromInput.value);
        var toValue = new Date(toInput.value);
        var minDate = new Date(fromValue.getTime() + 86400000);
        if (toValue < minDate) {
            toInput.value = '';
        }
        toInput.min = minDate.toISOString().slice(0, 16);
        });

        // Kiểm tra nếu to-input < from-input thì reset giá trị
        toInput.addEventListener('change', function() {
        var fromValue = new Date(fromInput.value);
        var toValue = new Date(toInput.value);
        if (toValue < fromValue) {
            toInput.value = '';
        }
        });

    </script>
</body>
</html>
