/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Order;
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
        int typeRentCar = 0, typeReceiveCar = 0;
        try {
            String idOrder = session.getAttribute("idOrder").toString();
            Order order = dao.getOrderById(idOrder);
            String typeRent = order.getTypeRent();
            String typeReceive = order.getTypeReceive();

            if (typeRent.equalsIgnoreCase("day")) {
                typeRentCar = 0;
            } else {
                typeRentCar = 1;
            }
            if (typeReceive.equalsIgnoreCase("fixed")) {
                typeReceiveCar = 0;
            } else {
                typeReceiveCar = 1;
            }
            System.out.println(typeRentCar);
            request.setAttribute("typeRent", typeRent);
            request.setAttribute("typeReceive", typeReceive);
            request.setAttribute("typeRentCar", typeRentCar);
            request.setAttribute("typeReceiveCar", typeReceiveCar);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("detailBooking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {

            String idOrder = session.getAttribute("idOrder").toString();
            Order order = dao.getOrderById(idOrder);
            String typeRent = order.getTypeRent();
            String typeRecieve = order.getTypeReceive();
            int numberDay = 0,numberHour=0;
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String wards = request.getParameter("wards");
            String paymentMethod = request.getParameter("paymentMethod");
            String addressRecieve = address + "/" + wards + "/" + district + "/" + city;
            if (typeRent.equalsIgnoreCase("day")) {
                String fromDay = request.getParameter("fromDay");
                numberDay = Integer.parseInt(request.getParameter("numberDay"));
                dao.insertDetailRentCarDay(idOrder, fromDay, numberDay, addressRecieve, paymentMethod, "test4", typeRecieve);
            } else {
                String fromHour = request.getParameter("fromHour");
                numberHour = Integer.parseInt(request.getParameter("numberHour"));
                String[] fromHour1 = fromHour.split("T");
                String hour = fromHour.replace("T", " ");
                System.out.println(hour);
                dao.insertDetailRentCarHour(idOrder, hour, numberHour, addressRecieve, paymentMethod, "test4", typeRecieve);
            }

        } catch (Exception e) {
        }

        response.sendRedirect("payment");

    }
}
