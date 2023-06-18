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

/**
 *
 * @author ACER
 */
public class infomationOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        int typeRentCar = 0, typeReceiveCar = 0, methodPayCar = 0;
        String oid = request.getParameter("oid");
        OrderDetail orderDetail = dao.getOrderDetailById(oid);
        Account account = dao.getAccountByID(orderDetail.getIdUser());
        Car car = dao.getCarByID(orderDetail.getIdCar()).get(0);
        Order order = dao.getOrderById(oid);
        String typeRent = order.getTypeRent();
        String typeReceive = order.getTypeReceive();
        String methodPay = orderDetail.getMethodPay();
        if (methodPay.equalsIgnoreCase("credit")) {
            methodPayCar = 0;
        } else {
            methodPayCar = 1;
        }
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
        if (orderDetail.getTypeRent().equalsIgnoreCase("day")) {
            String toDay = dao.getDayReturnCarByIdOrder(oid);
            System.out.println(toDay);
            request.setAttribute("toDay", toDay);
        } else {
            String toHour = dao.getHourReturnCarByIdOrder(oid).substring(0, dao.getHourReturnCarByIdOrder(oid).lastIndexOf(":"));
            System.out.println(toHour);
            request.setAttribute("toHour", toHour);

        }

        request.setAttribute("methodPayCar", methodPayCar);
        request.setAttribute("typeReceiveCar", typeReceiveCar);
        request.setAttribute("typeRentCar", typeRentCar);
        request.setAttribute("car", car);
        request.setAttribute("account", account);
        request.setAttribute("orderDetail", orderDetail);

        request.getRequestDispatcher("informationOrder.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}