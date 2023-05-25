/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package control;

import dao.DAO;
import entity.Car;
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
public class SearchControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO dao = new DAO();
        String searchInput = request.getParameter("searchInput");
        List<Car> list = dao.getCarByName(searchInput);
        int size = list.size();
        int totalItems = list.size();
        int itemsPerPage = 9;
        int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
        int offset = (currentPage - 1) * itemsPerPage;
        List<Car> pageCars = list.subList(offset, Math.min(offset + itemsPerPage, totalItems));
        int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("listCar", pageCars);
        request.setAttribute("searchInput", searchInput);
        request.getRequestDispatcher("searchCar.jsp").forward(request, response);
    } 
}
