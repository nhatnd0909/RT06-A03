/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Car;
import entity.Order;
import entity.OrderDetail;
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
public class InfomationHistoryBookingControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        int typeRentCar = 0, typeReceiveCar = 0, methodPayCar = 0;
        try {
            String idOrder = request.getParameter("oid");
            OrderDetail orderDetail = dao.getOrderDetailById(idOrder);
            Car car = dao.getCarByID(orderDetail.getIdCar()).get(0);
            Order order = dao.getOrderById(idOrder);
            String typeRent = order.getTypeRent();
            String typeReceive = order.getTypeReceive();
            String methodPay = orderDetail.getMethodPay();
            String returnDay = dao.getDayReturnCarByIdOrder(idOrder);
            String returnHour = dao.getHourReturnCarByIdOrder(idOrder);
            String idCar = orderDetail.getIdCar();
            if (methodPay.equalsIgnoreCase("credit")) {
                methodPayCar = 0;
            } else {
                methodPayCar = 1;
            }
            if (typeRent.equalsIgnoreCase("day")) {
                typeRentCar = 0;
                String toDay = dao.getDayReturnCarByIdOrder(idOrder);
                request.setAttribute("toDay", toDay);
            } else {
                typeRentCar = 1;
                String toHour = dao.getHourReturnCarByIdOrder(idOrder).substring(0, dao.getHourReturnCarByIdOrder(idOrder).lastIndexOf(":"));
                request.setAttribute("toHour", toHour);
            }
            if (typeReceive.equalsIgnoreCase("fixed")) {
                typeReceiveCar = 0;
                String address = "Thăng Long/Hòa Cường Nam/Hải Châu/Đà Nẵng";
                String[] adds = address.split("/");
                String add = adds[0];
                String city = adds[3];
                String district = adds[2];
                String wards = adds[1];
                request.setAttribute("add", add);
                request.setAttribute("city", city);
                request.setAttribute("district", district);
                request.setAttribute("wards", wards);
            } else {
                typeReceiveCar = 1;
                String address = orderDetail.getLocation();
                String[] adds = address.split("/");
                String add = adds[0];
                String city = adds[3];
                String district = adds[2];
                String wards = adds[1];
                request.setAttribute("add", add);
                request.setAttribute("city", city);
                request.setAttribute("district", district);
                request.setAttribute("wards", wards);
            }
            int flag = 0;
            if (dao.compareDate(orderDetail.getFromDay()) < 7) {
                flag = 0;
                String notification = "You cannot cancel your order before 7 days of receiving the car";
                request.setAttribute("notification", notification);
                request.setAttribute("flag", flag);
            } else {
                flag = 1;
                request.setAttribute("flag", flag);
            }
            int flag2 = 0;
            if (orderDetail.getStatus().equals("Canceled order")) {
                flag2 = 0;
                request.setAttribute("flag2", flag2);
            } else {
                flag2 = 1;
                request.setAttribute("flag2", flag2);
            }
            request.setAttribute("returnDay", returnDay);
            request.setAttribute("idCar", idCar);
            request.setAttribute("returnHour", returnHour);
            request.setAttribute("methodPayCar", methodPayCar);
            request.setAttribute("typeReceiveCar", typeReceiveCar);
            request.setAttribute("typeRentCar", typeRentCar);
            request.setAttribute("car", car);
            request.setAttribute("orderDetail", orderDetail);
        } catch (Exception e) {
        }
        request.getRequestDispatcher("informationHistoryBooking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
