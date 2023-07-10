/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Account;
import entity.FeedBack;
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
public class FeedBackAdminControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        try {
            int totalFeedback = dao.getAllFeeback().size();
            List<FeedBack> list = dao.getAllFeeback();
            int size = list.size();
            int totalItems = list.size();
            int itemsPerPage = 9;
            int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
            int offset = (currentPage - 1) * itemsPerPage;
            List<FeedBack> pageCars = list.subList(offset, Math.min(offset + itemsPerPage, totalItems));
            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
            request.setAttribute("totalFeedback", totalFeedback);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("listUser", pageCars);
            
        } catch (Exception e) {
        }
        request.getRequestDispatcher("adminFeedBack.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
