/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import DAO.DAO;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.Taikhoan;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author acer
 */
@WebServlet(name = "Loadbaocao3", urlPatterns = {"/Loadbaocao3"})
public class Loadbaocao3 extends HttpServlet {

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
        String action = request.getParameter("action");
        Taikhoan a=(Taikhoan)session.getAttribute("taikhoan");
        if (a == null){
            request.getRequestDispatcher("Trangchu").forward(request, response);
        }else{
            String ispaid=request.getParameter("ispaid");
            String i="";
            if(ispaid.equals("Chưa đóng")){
                i+="0";
            }else{
                i+="1";
            }       
            DAO dao=new DAO();
            List<Customer> list=dao.Baocao3(i);
            request.setAttribute("listp", list);
            
            if (action.equals("Xem")) {
                // Xử lý action của nút submit1
                request.getRequestDispatcher("/index/baocao3.jsp").forward(request, response);
                
            } else if (action.equals("Xuất file Excel")) {
                // Xử lý action của nút submit2
                // Tạo tệp excel mới
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Danh sách khách hàng");

                // tạo hàng đầu tiên trong bảng excel
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("Mã khách hàng");
                headerRow.createCell(1).setCellValue("Tên");
                headerRow.createCell(2).setCellValue("Số điện thoại");
                headerRow.createCell(3).setCellValue("Địa chỉ");
                headerRow.createCell(4).setCellValue("Email");
                headerRow.createCell(5).setCellValue("Số");
                headerRow.createCell(6).setCellValue("Tháng");
                headerRow.createCell(7).setCellValue("Tiền");


                // tạo các hàng tiếp theo trong bảng excel
                int rowNum = 1;
                for (Customer customer : list) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(customer.getMaKH());
                    row.createCell(1).setCellValue(customer.getTen());
                    row.createCell(2).setCellValue(customer.getSdt());
                    row.createCell(3).setCellValue(customer.getDchi());
                    row.createCell(4).setCellValue(customer.getEmail());
                    row.createCell(5).setCellValue(customer.getSo());
                    row.createCell(6).setCellValue(customer.getThang());
                    row.createCell(7).setCellValue(customer.getTien());
                }

                response.setHeader("Content-Disposition", "attachment;filename=DanhSachKhachHang.xlsx");
                response.setContentType("application/vnd.ms-excel");

                // Ghi dữ liệu tệp excel vào OutputStream để trả về cho client

                OutputStream out = response.getOutputStream();
                workbook.write(out);
                out.flush();
                out.close();

            }
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
