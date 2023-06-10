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
public class AddCarControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       DAO dao = new DAO();
       String id = request.getParameter("id");
       String name = request.getParameter("name");
       String type = request.getParameter("type");
       String manufactory = request.getParameter("manufactory");
       String fuel = request.getParameter("fuel");
       String color = request.getParameter("color");
       int seat = Integer.parseInt(request.getParameter("seat"));
       String year = request.getParameter("year");
       String img = request.getParameter("img");
       int pricePerDay = Integer.parseInt(request.getParameter("pricePerDay"));
       int pricePerHour = Integer.parseInt(request.getParameter("pricePerHour"));
       dao.createNewCar(id, name, type, manufactory, fuel, color, seat, year, img, pricePerDay, pricePerHour);
       
       String mess ="Add new car success";
       request.setAttribute("mess", mess);
       
       
        
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
       
       
       request.getRequestDispatcher("carDashBoard.jsp").forward(request, response);
    }
}
