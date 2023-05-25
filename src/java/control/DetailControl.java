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
public class DetailControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
                String carID = request.getParameter("cid");
        DAO dao = new DAO();
        List<Car> list = dao.getCarByID(carID);
        String type = list.get(0).getCarType();
        String manufactor = list.get(0).getManufacturer();
        List<Car> listCarRelated = dao.getCarRelated(type, manufactor);
        request.setAttribute("listCarRelated", listCarRelated);
        request.setAttribute("list", list);
        request.getRequestDispatcher("car-single.jsp").forward(request, response);
    } 
}
