<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng nhập</title>
    <style>
     <%@ include file="/css/dk.css"%>
    </style>
    <link rel="stylesheet" href="/tester/icon/themify-icons-font/themify-icons/themify-icons.css">
    <script src="test.js"></script>
</head>
<body>
    
     <section>
        <div class="header">
        <a href="/tester/Trangchu" class="lg"> <img  src="/tester/anh/Artboard 2.png" class="logo"> </a>
        <nav class="nav-bar">
            <div class="button-nav">
                 <a class="b1" href="/tester/Trangchu">TRANG CHỦ</a>     
            </div>
        </nav>
        <!--<div class="dk-dn2"> <a href="/tester/Login">ĐĂNG NHẬP </a> </div>-->
        </div>
            <div class="form-box">
                <div class="form-value">
                    <form action="Login" method="post">
                        <h2>Đăng nhập</h2>
                        <div class="inputbox">
                            <ion-icon name="mail-outline"></ion-icon>
                            <input class="user" type="text" id="user" name="user" required>
                            <label for="">Tên đăng nhập</label>
                        </div>
                        <div class="inputbox">
                            <ion-icon name="lock-closed-outline"></ion-icon>
                            <input class="pass" type="password" id="pass" name="pass" required>
                            <label for="">Mật khẩu</label>
                        </div>
                        <button onclick=validatePassword() class="btn1" id="loginbtn" type="submit">Đăng nhập</button>
                    </form>
                </div>
            </div>
    </section>
    <script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
    <script>window.onload=function(){user.focus()}</script>
    <script>
        function validatePassword() {
            const passwordInput = document.getElementById('pass'); // Lấy thẻ input
            const password = passwordInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            const usernameInput = document.getElementById('user'); // Lấy thẻ input
            const username = usernameInput.value.trim(); // Lấy giá trị của input và xóa khoảng trắng thừa
            if(username == '' && password == ''){
              alert('Tên đăng nhập và Mật khẩu không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
              window.location.reload();
            }
            else if(username == ''){
              alert('Tên đăng nhập không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
              window.location.reload();
            }
            else if (password == '') {
              alert('Mật khẩu không được để trống'); // Kiểm tra xem mật khẩu có rỗng không
              window.location.reload();
            }
            else if (password.length < 6 || password.length > 20) {
              alert('Mật khẩu phải có từ 6 đến 20 kí tự'); // Kiểm tra xem mật khẩu có từ 6-20 kí tự không
              window.location.reload();
            }
            // Nếu mật khẩu hợp lệ thì trả về true
            window.location.href = 'Login';
        }
    </script>
    <script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>