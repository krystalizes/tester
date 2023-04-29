<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Theo dõi khách hàng</title>
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
            <div class="log">
                <div class="dk-dn2" >   <a href="/tester/Login">ĐĂNG NHẬP</a> </div>
            </div>
        </c:if>
    </div>
        <c:if test="${sessionScope.taikhoan != null}">  
 
            <form action="SearchCustomer" method="post" class="form2">

                <div class="timkiem1">
                    <input name="txt" type="text" id="search">
                </div>
                <div class="timkiem">
                    <button type="submit" id="searchbtn" class="btn"><h3> Tìm khách hàng </h3></button> 
                </div>               
            </form>
        </c:if>

    <div class="giua">
        <button  id="btn-open" class="btn" onclick="modal()"><h3>Thêm khách hàng</h3> </button>
        <div id="modal-container" >
                <div class="modal" id="modal-demo">
                    <div class="modal-header">
                        
                        <button  id="btn-close" onclick="modal1()"><i class="ti-close"></i> </button> 
                    </div>
                    <div class="modal-body">
                        <form action="/tester/AddCustomer" method="post" class="form1">
                            <div class="themsp">
                                <p>TÊN</p>
                                <input name="txt1"  type="text" class="ip" id="ten2">
                                <P>SDT</p>
                                <input name="txt2"  type="text" class="ip" id="sdt2">   
                                <p>ĐỊA CHỈ</p>
                                <input name="txt3"  type="text" class="ip" id="dchi2">
                                <p>EMAIL</p>
                                <input name="txt4"  type="text" class="ip" id="email2">
                            </div>
                            <div class="modal-footer">
                                <button  class="btn" onclick=validateCustomer(event) id="luu" type="submit"><i class="ti-plus"> Lưu</i> </button>                             
                            </div>
                        </form>                                          
                    </div>
                </div>
        </div>  
                  
        <center>
            <div class="tieude">
                <h2><b>Danh sách khách hàng </b></h2>
                 	
            </div> 
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
                    <th></th>
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
                        <td>
                               <button  class="btn"><a  href="LoadeditCustomer?pid=${o.maKH}"><i class="ti-pencil"></i></a> </button>
                               <button class="btn"><a href="DeleteCustomer?pid=${o.maKH}" onclick="cancelDelete(event, ${o.maKH})"><i class="ti-trash"></i></a></button> 
                        </td>
                    </tr>
                </c:forEach>    
            </table>
        </center>
    </div>
    </section>
    <script>
        window.onload=function(){search.focus()}
        function modal(){           
            const modal_container=document.getElementById('modal-container');
            modal_container.classList.add('show');
            ten2.focus();
            
        }
        function cancelDelete(event, id) {
            event.preventDefault(); // ngăn chặn sự kiện click mặc định của button
            var confirmDelete = confirm("Bạn có chắc chắn muốn xoá không?");
            if (confirmDelete) {
              alert("Xóa thành công");
              window.location.href = `DeleteCustomer?pid=` + id; // thực hiện xoá nếu người dùng chọn "Có"
            }
        }

        
        function validateCustomer(event) {    
            const form = document.querySelector('.form1');
            
            event.preventDefault();
            
            const tenInput = document.getElementById('ten2'); // Lấy thẻ input
            const sdtInput = document.getElementById('sdt2'); // Lấy thẻ input
            const dchiInput = document.getElementById('dchi2'); // Lấy thẻ input
            const emailInput = document.getElementById('email2');
            
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
                    alert("Thêm thành công");
                    form.submit();

            }
            
            
        }
    </script>
        
    
</body>
</html>