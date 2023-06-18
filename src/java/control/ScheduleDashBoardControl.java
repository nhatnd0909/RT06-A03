//package control;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
// */
//
//
//import dao.DAO;
//import entity.Account;
//import entity.OrderDetail;
//import entity.Staff;
//import java.io.IOException;
//import java.io.PrintWriter;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// *
// * @author ACER
// */
//public class ScheduleDashBoardControl extends HttpServlet {
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        DAO dao = new DAO();
//        int totalSchedule = dao.getAllOrderDetail().size();
//        List<OrderDetail> list = dao.getAllOrderDetail();
//        int size = list.size();
//        int totalItems = list.size();
//        int itemsPerPage = 9;
//        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
//        int offset = (currentPage - 1) * itemsPerPage;
//        List<OrderDetail> pageSchedule = list.subList(offset, Math.min(offset + itemsPerPage, totalItems));
//        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
//        List<Account> listAccount = new ArrayList<>();
//        for(OrderDetail o:list){
//            Account account = dao.getAccountByID(o.getIdUser());
//            listAccount.add(account);
//            
//        }
//        request.setAttribute("listAccount", listAccount);
//        request.setAttribute("totalSchedule", totalSchedule);
//        request.setAttribute("totalPages", totalPages);
//        request.setAttribute("currentPage", currentPage);
//        request.setAttribute("pageSchedule", pageSchedule);
//        request.getRequestDispatcher("scheduleDashBoard.jsp").forward(request, response);
//    } 
//
// 
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//    throws ServletException, IOException {
//        
//    }
//
//}
