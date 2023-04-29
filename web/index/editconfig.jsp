<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa cấu hình</title>
    <link rel="stylesheet" href="/tester/icon/themify-icons-font/themify-icons/themify-icons.css">
    <style>
     <%@ include file="/css/edit.css"%>
    </style>
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
    <div id="modal-container" >
                <div class="modal" id="modal-demo">
                    <div class="modal-header">
                        <h3>Sửa config</h3>
                        <button  id="btn-close"><a href="/tester/Configure"><i class="ti-close"></i></a> </button> 
                    </div>
                    <div class="modal-body">
                        <form action="/tester/EditConfig" method="post" class="form1">
                            <div class="themsp">
                                <p>ID</p>
                                <input name="txt1" value="${detail.id}"  readonly class="ip" id="id">
                                <p>MỐC ĐIỆN</p>
                                <input name="txt2" type="number" value="${detail.mocdien}"  class="ip" id="mocdien">
                                <P>GIÁ</p>
                                <input name="txt3" type="number" value="${detail.gia}"class="ip" id="gia">                                                      
                            </div>
                            <div class="modal-footer">
                                <button  class="btn" onclick=validateConfig() id="luu" type="submit"><i class="ti-plus"> Lưu</i> </button>                             
                            </div>
                        </form>                                          
                    </div>
                </div>
        </div>         
    </section>
    <script>window.onload=function(){mocdien.focus()}</script> 
    <script>
        function validateConfig() {
            const mocdienInput = document.getElementById('mocdien'); // Lấy thẻ input            
            const mocdien = mocdienInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            const giaInput = document.getElementById('gia'); // Lấy thẻ input
            const gia = giaInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            if( mocdien == '' && gia == ''){
              alert('Mốc điện và giá không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
              window.location.reload();
            }
            else if(mocdien == ''){
              alert('Mốc điện không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
              window.location.reload();
            }
            else if (gia == '') {
              alert('Giá không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
              window.location.reload();
            }else{
              alert('Sửa thành công');  
            }       
            
        }
    </script>
</body>
    