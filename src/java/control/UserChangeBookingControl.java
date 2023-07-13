/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author ACER
 */
public class UserChangeBookingControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();

        try {

            String idOrder = request.getParameter("idOrder");
            OrderDetail orderDtail = dao.getOrderDetailById(idOrder);
            String typeRecieve = request.getParameter("typeRecieve");
//            String location = request.getParameter("location");
            String add = request.getParameter("address");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String wards = request.getParameter("wards");
            request.setAttribute("add", add);
            request.setAttribute("city", city);
            request.setAttribute("district", district);
            request.setAttribute("wards", wards);
            String location = add + "/" + wards + "/" + district + "/" + city;

            String methodPay = request.getParameter("methodPay");
            if (orderDtail.getTypeRent().equalsIgnoreCase("day")) {
                int numday = Integer.parseInt(request.getParameter("numDay"));
                int pricePerDay = dao.getPricePerdayByIdOrder(idOrder);
                int totalPrice = 0;
                if (request.getParameter("typeRecieve").equalsIgnoreCase("fixed")) {
                    totalPrice = pricePerDay * numday;
                } else {
                    totalPrice = pricePerDay * numday + 50;
                }

                dao.updateBookingDay(idOrder, numday, location, methodPay, totalPrice);
                System.out.println("thanh cong 2");
            } else {
                String fromHour = request.getParameter("fromHour");
                int numHour = Integer.parseInt(request.getParameter("numHour"));
                int pricePerHour = dao.getPricePerhourByIdOrder(idOrder);
                int totalPrice = 0;
                if (request.getParameter("typeRecieve").equalsIgnoreCase("fixed")) {
                    totalPrice = pricePerHour * numHour;
                } else {
                    totalPrice = pricePerHour * numHour + 50;
                }

                String fromHour1 = fromHour.replace("T", " ");
                dao.updateBookingHour(idOrder, numHour, location, methodPay, totalPrice);
            }
            dao.updateTypeRecieveCar(idOrder, typeRecieve);

        } catch (Exception e) {
            System.out.println(e);
        }
//        request.getRequestDispatcher("historybooking").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        try {
            String idOrder = request.getParameter("idOrder");
            OrderDetail orderDtail = dao.getOrderDetailById(idOrder);
            String typeRent = orderDtail.getTypeRent();
            String typeRecive = request.getParameter("typeRecieve");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String wards = request.getParameter("wards");
            String location = address + "/" + wards + "/" + district + "/" + city;
            String methodPay = request.getParameter("methodPay");

            if (typeRent.equalsIgnoreCase("day")) {
                int numday = Integer.parseInt(request.getParameter("numDay"));
                int pricePerDay = dao.getPricePerdayByIdOrder(idOrder);
                int totalPrice = 0;
                if (typeRecive.equalsIgnoreCase("fixed")) {
                    totalPrice = pricePerDay * numday;
                } else {
                    totalPrice = pricePerDay * numday + 50;
                }
                dao.updateBookingDay(idOrder, numday, location, methodPay, totalPrice);

            } else {
                int numHour = Integer.parseInt(request.getParameter("numHour"));
                int pricePerHour = dao.getPricePerhourByIdOrder(idOrder);
                int totalPrice = 0;
                if (typeRecive.equalsIgnoreCase("fixed")) {
                    totalPrice = pricePerHour * numHour;
                } else {
                    totalPrice = pricePerHour * numHour + 50;
                }
                dao.updateBookingHour(idOrder, numHour, location, methodPay, totalPrice);
            }
            dao.updateTypeRecieveCar(idOrder, typeRecive);
            
        } catch (Exception e) {
        }
        response.sendRedirect("historybooking");
    }
}
