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
        String manufacturer = request.getParameter("manufacturer");
        String type = request.getParameter("type");
        int pricePerDay = Integer.parseInt(request.getParameter("pricePerDay"));
        int pricePerHour = Integer.parseInt(request.getParameter("pricePerHour"));
        
        
        List<Car> list = dao.getCarBySearch(searchInput, type, manufacturer,pricePerDay , pricePerHour);
        List<String> listManufactory = dao.getManufactory();
        List<String> listType = dao.getType();
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
        
        request.setAttribute("searchInput", searchInput);
        request.setAttribute("manufacturer", manufacturer);
        request.setAttribute("type", type);
        request.setAttribute("pricePerDay", pricePerDay);
        request.setAttribute("pricePerHour", pricePerHour);
        
        request.setAttribute("listManufactory", listManufactory);
        request.setAttribute("listType", listType);
        request.getRequestDispatcher("searchCar.jsp").forward(request, response);

    }
}
