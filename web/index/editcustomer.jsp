<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sửa thông tin khách hàng</title>
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
<!--                <button class="btn">    <a class="b1" href="#">Nhân viên:${sessionScope.taikhoan.user}</a>      </button>-->
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
                        <h3>Sửa thông tin khách hàng</h3>
                        <button  id="btn-close"><a href="/tester/LoadDanhsachCus"><i class="ti-close"></i></a> </button> 
                    </div>
                    <div class="modal-body">
                        <form action="/tester/EditCustomer" method="post" class="form1">
                            <div class="themsp">
                                <p>MÃ KH</p>
                                <input name="txt1" value="${detail.maKH}"  readonly class="ip" id="id">
                                <p>TÊN</p>
                                <input name="txt2" value="${detail.ten}" type="text" class="ip" id="ten">
                                <P>SDT</p>
                                <input name="txt3" value="${detail.sdt}" type="text" class="ip" id="sdt">   
                                <p>ĐỊA CHỈ</p>
                                <input name="txt4" value="${detail.dchi}"  type="text" class="ip" id="dchi">
                                <p>EMAIL</p>
                                <input name="txt5" value="${detail.email}"  type="email" class="ip" id="email">
                            </div>
                            <div class="modal-footer">
                                <button  class="btn" onclick=validateCustomer(event) id="luu" type="submit"><i class="ti-plus"> Lưu</i> </button>                             
                            </div>
                        </form>                                          
                    </div>
                </div>
        </div>         
    </section>
    <script>window.onload=function(){ten.focus()}</script>
    <script>
        function validateCustomer(event) {    
            const form = document.querySelector('form');
            event.preventDefault();
            
            const tenInput = document.getElementById('ten'); // Lấy thẻ input
            const sdtInput = document.getElementById('sdt'); // Lấy thẻ input
            const dchiInput = document.getElementById('dchi'); // Lấy thẻ input
            const emailInput = document.getElementById('email');
            
            var regexName = /^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*/gm;
            var regexPhone = /^(0|84)(2(0[3-9]|1[0-6|8|9]|2[0-2|5-9]|3[2-9]|4[0-9]|5[1|2|4-9]|6[0-3|9]|7[0-7]|8[0-9]|9[0-4|6|7|9])|3[2-9]|5[5|6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])([0-9]{7})$/mg;
            var regexMail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/mg;
            
            const ten = tenInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            const sdt = sdtInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            const dchi = dchiInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            const email = emailInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa        
            if(ten == '' || sdt == '' || dchi == '' || email == ''){
              alert('Các trường không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
            }else{          
                console.log(tenInput.value);
                var isValidName = regexName.test(tenInput.value);
                var check = true;
                if (!isValidName) {
                    alert("Tên không hợp lệ");
                    check = false;
                }
                else 
                    check = true;
                var isValidPhone = regexPhone.test(sdtInput.value);
                if (!isValidPhone && check === true) {
                    alert("SDT không hợp lệ");
                    check = false;
                }
                else
                    check = true
                
                var isValidMail = regexMail.test(emailInput.value);
                if (!isValidMail && check === true) {
                    alert("Email không hợp lệ");
                    check = false;
                }
                else
                    check = true
                
                
                if(isValidName == true && isValidPhone == true && isValidMail == true)
                    alert("Sửa thành công");
                    form.submit();

            }
            
            
        }
    </script>
</body>
    