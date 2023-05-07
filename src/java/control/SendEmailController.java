/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.DAO;
import java.util.Properties;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Taikhoan;

/**
 *
 * @author bachb
 */
@WebServlet(name = "SendEmailController", urlPatterns = {"/SendEmailController"})
public class SendEmailController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        Taikhoan a=(Taikhoan)session.getAttribute("taikhoan");
        
        if (a == null){
            request.getRequestDispatcher("Trangchu").forward(request, response);
        }else{
            LocalDate currentdate = LocalDate.now();
            String id=request.getParameter("id");
            System.out.println(id);
            DAO dao=new DAO();
            
            final String senderEmail = "bachbnvn123@gmail.com";
            final String senderPassword = "qicyaknmbxjjlmge";

            // Lấy thông tin người dùng nhập từ form
            String recipient = "";
            String subject = "";
            String content = "";

            // Cấu hình thông tin máy chủ SMTP của nhà cung cấp email
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "465");
//            props.put("mail.debug", "true");
            props.put("mail.smtps.ssl.trust", "*");
            props.put("mail.smtp.starttls.enable", "true");

            // Đăng nhập vào máy chủ SMTP
            Authenticator auth = new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(senderEmail, senderPassword);
                }
            };
            if(id.equalsIgnoreCase("1")) {
                
                List<Customer> list=dao.getCustomer();
                String time1 = request.getParameter("time1");
                String time2 = request.getParameter("time2");
                String reason = request.getParameter("reason");
                String area = request.getParameter("area");
                System.out.println(area + reason);
                for(Customer cus : list) {
                    recipient = cus.getEmail();
                    subject = "EVN";
                    content = "THÔNG BÁO NGẮT ĐIỆN\n" +
                    "\n" +
                    "Kính gửi quý anh/chị " + cus.getTen() + "\n" +
                    "\n" +
                    "Công ty Điện lực trân trọng thông báo đến quý khách hàng về việc ngắt cung cấp điện tạm thời như sau:\n" +
                    "\n" +
                    "Thời gian ngắt điện: từ " + time1 + " đến " + time2 + "\n" +
                    "\n" +
                    "Lý do: " + reason + "\n" +
                    "\n" +
                    "Khu vực bị ảnh hưởng: "+ area + "\n" +
                    "\n" +
                    "Chúng tôi rất xin lỗi vì sự bất tiện này và mong quý khách hàng thông cảm.\n" +
                    "\n" +
                    "Nếu quý khách có bất kỳ câu hỏi hoặc thắc mắc nào, vui lòng liên hệ tổng đài 19001006 để được hỗ trợ.\n" +
                    "\n" +
                    "Trân trọng cảm ơn!\n" +
                    "\n" +
                    "Công ty Điện lực.";
                    try {
                        Session session1 = Session.getInstance(props, auth);
                        // Tạo đối tượng Message để gửi email
                        Message message = new MimeMessage(session1);
                        message.setFrom(new InternetAddress(senderEmail));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                        String encodedSubject = MimeUtility.encodeText(subject, "UTF-8", "B");
                        message.setSubject(encodedSubject);
                        
                        message.setContent(content, "text/plain; charset=UTF-8");


                        // Gửi email
                        Transport.send(message);
                        System.out.println("Email sent successfully");
                    } catch (MessagingException e ) {
                        System.out.println("Failed to send email: " + recipient);
                    }
                }

                
            }
            else if(id.equalsIgnoreCase("2")) {
                List<Customer> list=dao.getAllCustomer();
                for(Customer cus : list) {
                    recipient = cus.getEmail();
                    subject = "EVN";
                    content = "Kính gửi quý anh/chị " + cus.getTen() + "\n" +
                    "\n" +
                    "Em là đại diện của công ty điện lực xin gửi email này đến anh/chị để thông báo về việc đóng tiền điện.\n" +
                    "\n" +
                    "Theo hợp đồng sử dụng điện, quý khách hàng cần đóng tiền điện đúng hạn để đảm bảo sử dụng điện liên tục và tránh tình trạng ngưng cung cấp điện. Hiện tại, công ty điện lực của chúng tôi đã gửi thông báo về việc đóng tiền qua thư tín hoặc SMS đến các anh/chị trong tháng trước.\n" +
                    "\n" +
                    "Vì vậy, em xin nhắc lại đến anh/chị rằng hiện tại là thời điểm đóng tiền điện và anh/chị vui lòng thanh toán trước ngày hết hạn để tránh các rủi ro phát sinh. Nếu anh/chị đã đóng tiền hoặc có bất kỳ câu hỏi nào liên quan đến việc thanh toán tiền điện, xin vui lòng liên hệ với bộ phận chăm sóc khách hàng của chúng tôi để được hỗ trợ.\n" +
                    "\n" +
                    "Em xin chân thành cảm ơn sự hợp tác của anh/chị và mong nhận được phản hồi từ phía anh/chị sớm nhất.\n" +
                    "\n" +
                    "Trân trọng,";
                    try {
                        Session session1 = Session.getInstance(props, auth);
                        // Tạo đối tượng Message để gửi email
                        Message message = new MimeMessage(session1);
                        message.setFrom(new InternetAddress(senderEmail));
                        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                        String encodedSubject = MimeUtility.encodeText(subject, "UTF-8", "B");
                        message.setSubject(encodedSubject);
                        
                        message.setContent(content, "text/plain; charset=UTF-8");


                        // Gửi email
                        Transport.send(message);
                        System.out.println("Email sent successfully");
                    } catch (MessagingException e) {
                        System.out.println("Failed to send email: " + recipient);
                    }
                }
            }
            else if(id.equalsIgnoreCase("3")) {
                Date date= new Date();
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                int month = cal.get(Calendar.MONTH);
                int year = cal.get(Calendar.YEAR);
                List<Customer> list=dao.getCustomerNotPaid();
                for(Customer cus : list) {
                    String str = cus.getThang();
                    String[] arrOfStr = str.split("/", 2);
                    int cusMonth = Integer.parseInt(arrOfStr[0]);
                    int cusYear = Integer.parseInt(arrOfStr[1]);
                    if(month > cusMonth || year > cusYear) {
                        recipient = cus.getEmail();
                        subject = "EVN";
                        content = "Kính gửi quý anh/chị " + cus.getTen() + "\n" +
                        "\n" +
                        "Em gửi mail này để nhắc nhở anh/chị về việc đóng tiền điện cho tháng trước đó. Hiện tại, hóa đơn của anh/chị đã quá hạn và chưa được thanh toán.\n" +
                        "\n" +
                        "Việc thanh toán đúng hạn sẽ giúp tránh tình trạng gián đoạn cung cấp điện và tránh phát sinh các khoản phí trễ hạn. Anh/chị có thể thanh toán bằng các phương thức sau:\n" +
                        "\n" +
                        "Thanh toán trực tiếp tại các điểm giao dịch của công ty điện lực hoặc ngân hàng liên kết.\n" +
                        "Thanh toán qua internet banking, mạng ATM hoặc ứng dụng di động của ngân hàng.\n" +
                        "Nếu anh/chị đã thanh toán, xin vui lòng bỏ qua email này.\n" +
                        "\n" +
                        "Nếu anh/chị cần hỗ trợ hoặc thông tin thêm, vui lòng liên hệ đến tổng đài dịch vụ khách hàng của công ty điện lực hoặc truy cập vào trang web của công ty.\n" +
                        "\n" +
                        "Xin cảm ơn và mong nhận được sự hợp tác của anh/chị.\n" +
                        "\n" +
                        "Trân trọng,";
                        try {
                            Session session1 = Session.getInstance(props, auth);
                            // Tạo đối tượng Message để gửi email
                            Message message = new MimeMessage(session1);
                            message.setFrom(new InternetAddress(senderEmail));
                            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
                            String encodedSubject = MimeUtility.encodeText(subject, "UTF-8", "B");
                            message.setSubject(encodedSubject);

                            message.setContent(content, "text/plain; charset=UTF-8");


                            // Gửi email
                            Transport.send(message);
                            System.out.println("Email sent successfully: " + recipient);
                        } catch (MessagingException e) {
                            System.out.println("Failed to send email: " + recipient);
                        }
                    }
                }
            }
        response.sendRedirect("Tbaoemail");

            }
            
        }
        

        // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
        /**
         * Handles the HTTP <code>GET</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Handles the HTTP <code>POST</code> method.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
                throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo() {
            return "Short description";
        }// </editor-fold>

    }


