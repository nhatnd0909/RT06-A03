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
public class InformationCarControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        DAO dao = new DAO();
        String carId = request.getParameter("cid");
        List<Car> car = dao.getCarByID(carId);
        
        List<String> listManufactory = dao.getManufactory();
        List<String> listType = dao.getType();
        
        request.setAttribute("listManufactory", listManufactory);
        request.setAttribute("listType", listType);
        request.setAttribute("car", car);
        request.setAttribute("carId", carId);
        request.getRequestDispatcher("informationCar.jsp").forward(request, response);
    } 

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
        String status = request.getParameter("status");
        String description = request.getParameter("description");
        String year = request.getParameter("year");
        String img = request.getParameter("img");
        int pricePerDay = Integer.parseInt(request.getParameter("pricePerDay"));
        int pricePerHour = Integer.parseInt(request.getParameter("pricePerHour"));
        dao.updateCar(id, name, type, manufactory, fuel, color, seat, year, img, pricePerDay, pricePerHour, status, description);
        
        
//        request.getRequestDispatcher("cardashboard").forward(request, response);
        response.sendRedirect("cardashboard");
    }

}
