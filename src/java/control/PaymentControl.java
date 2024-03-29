/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Car;
import entity.Order;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ACER
 */
public class PaymentControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        int typeRentCar = 0, typeReceiveCar = 0, total = 0, typePayCar = 0;
        try {
            String idOrder = session.getAttribute("idOrder").toString();
            Order order = dao.getOrderById(idOrder);
            String idCar = dao.getIdCarByOrder(idOrder);
            Car car = dao.getCarByID(idCar).get(0);
            String typeRent = order.getTypeRent();
            String typeReceive = order.getTypeReceive();
            String typePay = dao.getTypePayByIdOrder(idOrder);
            OrderDetail orderDetail = dao.getOrderDetailById(idOrder);
            String location = orderDetail.getLocation();
            request.setAttribute("location", location);
            if (typePay.equalsIgnoreCase("direct")) {
                typePayCar = 0;
            } else {
                typePayCar = 1;
            }
            if (typeReceive.equalsIgnoreCase("fixed")) {
                typeReceiveCar = 0;
            } else {
                typeReceiveCar = 1;
            }
            if (typeRent.equalsIgnoreCase("day")) {
                typeRentCar = 0;
                int NumberDayOrder = dao.getNumberDayOrder(idOrder);
                if (typeReceive.equalsIgnoreCase("fixed")) {
                    total = NumberDayOrder * car.getPricePerDay();
                } else {
                    total = NumberDayOrder * car.getPricePerDay() + 50;
                }
                request.setAttribute("NumberDayOrder", NumberDayOrder);
                request.setAttribute("car", car);
                request.setAttribute("typeRentCar", typeRentCar);
                request.setAttribute("typeReceiveCar", typeReceiveCar);
                request.setAttribute("total", total);
                dao.insertTotalPrice(idOrder, total);
            } else {
                typeRentCar = 1;
                int NumberHourOrder = dao.getNumberHourOrder(idOrder);
                if (typeReceive.equalsIgnoreCase("fixed")) {
                    total = NumberHourOrder * car.getPricePerHour();
                } else {
                    total = NumberHourOrder * car.getPricePerHour() + 50;
                }
                request.setAttribute("NumberHourOrder", NumberHourOrder);
                request.setAttribute("car", car);
                request.setAttribute("typeRentCar", typeRentCar);
                request.setAttribute("typeReceiveCar", typeReceiveCar);
                request.setAttribute("total", total);
                dao.insertTotalPrice(idOrder, total);
            }
            request.setAttribute("typePayCar", typePayCar);
        } catch (Exception e) {
        }

        request.getRequestDispatcher("payment.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            String idOrder = session.getAttribute("idOrder").toString();
//            System.out.println(idOrder);
            OrderDetail orderDetail = dao.getOrderDetailById(idOrder);
            int price = orderDetail.getTotalPrice();
            int typePayCar = 0;
            if (orderDetail.getMethodPay().equalsIgnoreCase("direct")) {
                typePayCar = 0;
                request.setAttribute("typePayCar", typePayCar);
                response.sendRedirect("historybooking");
            } else {
                typePayCar = 1;
                request.setAttribute("typePayCar", typePayCar);
                request.setAttribute("price", price);
                response.sendRedirect("historybooking");
            }

            request.setAttribute("idOrder", idOrder);
        } catch (Exception e) {
        }
    }
}
