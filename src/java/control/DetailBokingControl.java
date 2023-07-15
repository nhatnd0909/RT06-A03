/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Order;
import entity.ScheduleDay;
import entity.ScheduleHour;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
            String[] day = dao.getCurentDay().split("T");
            String maxDay = dao.getMaxDay();
            String curentDay = day[0];
            request.setAttribute("curentDay", curentDay);
            request.setAttribute("maxDay", maxDay);
            String minHour = dao.getMinHour();
            request.setAttribute("minHour", minHour);

            request.setAttribute("typeRent", typeRent);
            request.setAttribute("typeReceive", typeReceive);
            request.setAttribute("typeRentCar", typeRentCar);
            request.setAttribute("typeReceiveCar", typeReceiveCar);

            String cid = order.getIdCar();
            List<ScheduleDay> scheduleDay = dao.getScheduleDay(cid);
            request.setAttribute("scheduleDay", scheduleDay);
            List<ScheduleHour> scheduleHour = dao.getScheduleHour(cid);
            request.setAttribute("scheduleHour", scheduleHour);
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
            int numberDay = 0, numberHour = 0;
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String wards = request.getParameter("wards");
            String paymentMethod = request.getParameter("paymentMethod");
            String addressRecieve = address + "/" + wards + "/" + district + "/" + city;
            String idCar = order.getIdCar();
            List<String> scheduleCar = dao.getAllScheduleByCarID(idCar);
            if (typeRent.equalsIgnoreCase("day")) {
                String fromDay = request.getParameter("fromDay");
                numberDay = Integer.parseInt(request.getParameter("numberDay"));
                List<String> scheduleCarRent = dao.getScheduleRentDay(fromDay, numberDay);
                if (dao.checkSameSchedule(scheduleCar, scheduleCarRent)) {
                    dao.insertDetailRentCarDay(idOrder, fromDay, numberDay, addressRecieve, paymentMethod, "Order processing", typeRecieve);
                } else {
                    String mess = "You booked the same date as the rental calendar, Please book another car or choose a suitable time";
                    request.setAttribute("mess", mess);
//                      aaaa
                    int typeRentCar = 0, typeReceiveCar = 0;
                    try {
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
                        String[] day = dao.getCurentDay().split("T");
                        String maxDay = dao.getMaxDay();
                        String curentDay = day[0];
                        request.setAttribute("curentDay", curentDay);
                        request.setAttribute("maxDay", maxDay);
                        String minHour = dao.getMinHour();
                        request.setAttribute("minHour", minHour);

                        request.setAttribute("typeRent", typeRent);
                        request.setAttribute("typeReceive", typeReceive);
                        request.setAttribute("typeRentCar", typeRentCar);
                        request.setAttribute("typeReceiveCar", typeReceiveCar);

                        String cid = order.getIdCar();
                        List<ScheduleDay> scheduleDay = dao.getScheduleDay(cid);
                        request.setAttribute("scheduleDay", scheduleDay);
                        List<ScheduleHour> scheduleHour = dao.getScheduleHour(cid);
                        request.setAttribute("scheduleHour", scheduleHour);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    request.getRequestDispatcher("detailBooking.jsp").forward(request, response);
//                      aaaa
                }
            } else {
                String fromHour = request.getParameter("fromHour");
                numberHour = Integer.parseInt(request.getParameter("numberHour"));
                List<String> scheduleCarRent = dao.getScheduleRentHour(fromHour);
                System.out.println(scheduleCarRent);
                if (dao.checkSameSchedule(scheduleCar, scheduleCarRent)) {
//                    System.out.println("không trùng");
                    String hour = fromHour.replace("T", " ");
                    dao.insertDetailRentCarHour(idOrder, hour, numberHour, addressRecieve, paymentMethod, "Order processing", typeRecieve);

                } else {
//                    System.out.println("trùng");
                    String mess = "You booked the same date as the rental calendar, Please book another car or choose a suitable time";
                    request.setAttribute("mess", mess);
                    //                      aaaa
                    int typeRentCar = 0, typeReceiveCar = 0;
                    try {
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
                        String[] day = dao.getCurentDay().split("T");
                        String maxDay = dao.getMaxDay();
                        String curentDay = day[0];
                        request.setAttribute("curentDay", curentDay);
                        request.setAttribute("maxDay", maxDay);
                        String minHour = dao.getMinHour();
                        request.setAttribute("minHour", minHour);

                        request.setAttribute("typeRent", typeRent);
                        request.setAttribute("typeReceive", typeReceive);
                        request.setAttribute("typeRentCar", typeRentCar);
                        request.setAttribute("typeReceiveCar", typeReceiveCar);

                        String cid = order.getIdCar();
                        List<ScheduleDay> scheduleDay = dao.getScheduleDay(cid);
                        request.setAttribute("scheduleDay", scheduleDay);
                        List<ScheduleHour> scheduleHour = dao.getScheduleHour(cid);
                        request.setAttribute("scheduleHour", scheduleHour);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    request.getRequestDispatcher("detailBooking.jsp").forward(request, response);
//                      aaaa
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        response.sendRedirect("payment");

    }
}
