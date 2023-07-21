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
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ACER
 */
public class CarDashBoardControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            String uid = session.getAttribute("id").toString();
            if (!uid.equalsIgnoreCase("2")) {
                response.sendRedirect("home");
            } else {
                List<String> listManufactory = dao.getManufactory();
                List<String> listType = dao.getType();

                int totalCar = dao.getTotalCar();
                List<Car> list = dao.getAllCar();
                int size = list.size();
                int totalItems = list.size();
                int itemsPerPage = 9;
                int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
                int offset = (currentPage - 1) * itemsPerPage;
                List<Car> pageCars = list.subList(offset, Math.min(offset + itemsPerPage, totalItems));
                int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
                request.setAttribute("totalCar", totalCar);
                request.setAttribute("totalPages", totalPages);
                request.setAttribute("currentPage", currentPage);
                request.setAttribute("listCar", pageCars);

                request.setAttribute("listManufactory", listManufactory);
                request.setAttribute("listType", listType);
                request.getRequestDispatcher("carDashBoard.jsp").forward(request, response);
            }
        } catch (Exception e) {
            response.sendRedirect("loginForm.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
