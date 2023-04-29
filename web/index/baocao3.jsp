<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Báo cáo 3</title>
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
                <h2><b>BÁO CÁO CÁC HỘ ĐÃ ĐÓNG TIỀN HOẶC CHƯA ĐÓNG</b></h2>               			
            </div> 
            <form action="Loadbaocao3" method="post">
                <label for="ispaid">CHỌN :</label>
                <select name="ispaid" id="paid">
                    <option value="Chưa đóng">Chưa đóng</option>
                    <option value="Đã đóng">Đã đóng</option>                   
                </select>
                <br><br>
                <input type="submit" name="action" value="Xem" id="see">
                <input type="submit" name="action" value="Xuất file Excel" />
            </form>
            <table class="container" border="0px" width="100%" id="tbl">
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
