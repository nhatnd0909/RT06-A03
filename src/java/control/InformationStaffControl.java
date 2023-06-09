/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import entity.Staff;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author ACER
 */
public class InformationStaffControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO dao = new DAO();
        String id = request.getParameter("sid");
        Staff staff = dao.getStaffByID(id);
        
        int test =0;
        if((staff.getGender()).equals("Male")){
            test = 1;
        } else{
            test=0;
        }
        
        request.setAttribute("test", test);
        request.setAttribute("staff", staff);
        request.getRequestDispatcher("infomationStaff.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO dao = new DAO();
        String id = request.getParameter("id");
        String name= request.getParameter("name");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        dao.updateStaff(id, name, dob, gender, address, phone);
        
        request.getRequestDispatcher("staffdashboard").forward(request, response);
    }

}
