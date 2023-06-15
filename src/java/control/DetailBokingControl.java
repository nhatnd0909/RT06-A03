/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
public class DetailBokingControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        
       
        
        request.getRequestDispatcher("detailBooking.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO dao = new DAO();
        
        String fromDay = request.getParameter("fromDay");
        int numberDay = Integer.parseInt(request.getParameter("numberDay"));
        String fromHour = request.getParameter("fromHour");
        int numberHour = Integer.parseInt(request.getParameter("numberHour"));
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String wards = request.getParameter("wards");
        
        System.out.println(fromDay+numberDay+fromHour+numberHour+address+city+district+wards);
        response.sendRedirect("payment");
        
    }
}
