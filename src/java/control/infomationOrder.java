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
        String returnDay = orderDetail.getReturnDay();

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
            request.setAttribute("toHour", toHour);

        }
        request.setAttribute("returnDay", returnDay);
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
        DAO dao = new DAO();
        try {
            String idOrder = request.getParameter("idOrder");
            OrderDetail orderDetail = dao.getOrderDetailById(idOrder);
            int statusRe = Integer.parseInt(request.getParameter("status"));
            String status = "";
            if (statusRe == 1) {
                status = "Order processing";
            } else if (statusRe == 2) {
                status = "Order successful";
            } else if (statusRe == 3) {
                status = "Order rejected";
            } else if (statusRe == 4) {
                status = "Order completion";
            } else if (statusRe == 0) {
                status = orderDetail.getStatus();
            }
            String statusReturn = "";
            int isReturn = Integer.parseInt(request.getParameter("isReturn"));
            if (isReturn == 0) {
                statusReturn = "Unpaid car";
            } else {
                statusReturn = "Paid car";
            }
            String returnDay = request.getParameter("dayReturn");
            returnDay = returnDay.replace("T", " ");
            dao.updateStatusOrder1(idOrder, status, isReturn, returnDay);
//            dao.updateStatusOrder(idOrder, status, isReturn);

            if (statusRe == 3 || statusRe == 4) {
                dao.updateSchedule(idOrder);
            }
        } catch (Exception e) {
        }
        response.sendRedirect("scheduledashboard");
    }

}
