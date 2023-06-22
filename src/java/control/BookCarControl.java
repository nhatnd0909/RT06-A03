/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Car;
import entity.ScheduleDay;
import entity.ScheduleHour;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ACER
 */
public class BookCarControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            int uid = Integer.parseInt(session.getAttribute("id").toString());
            String cid = request.getParameter("cid");
            Account account = dao.getAccountByID(uid);
            List<Car> listCar = dao.getCarByID(cid);
            Car car = listCar.get(0);
            if (account.getAddress()==null) {
            } else {
                String address = account.getAddress();
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
//            String address = account.getAddress();
//            String[] adds = address.split("/");
//            String add = adds[0];
//            String city = adds[3];
//            String district = adds[2];
//            String wards = adds[1];

            request.setAttribute("account", account);
            request.setAttribute("car", car);

//            request.setAttribute("add", add);
//            request.setAttribute("city", city);
//            request.setAttribute("district", district);
//            request.setAttribute("wards", wards);
            List<ScheduleDay> scheduleDay = dao.getScheduleDay(cid);
            request.setAttribute("scheduleDay", scheduleDay);
            List<ScheduleHour> scheduleHour = dao.getScheduleHour(cid);
            request.setAttribute("scheduleHour", scheduleHour);

        } catch (Exception e) {
            e.printStackTrace();
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        request.getRequestDispatcher("bookCar.jsp").forward(request, response);
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
            int idUser = Integer.parseInt(session.getAttribute("id").toString());
            String cid = request.getParameter("cid");
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String district = request.getParameter("district");
            String wards = request.getParameter("wards");
            String typeRent = request.getParameter("typeRent");
            String position = request.getParameter("position");
            String ci = request.getParameter("ci");
            String dl = request.getParameter("dl");
            String idOrder = dao.createCode();
            String add = address + "/" + wards + "/" + district + "/" + city;
            dao.updateAccount1(idUser, name, email, phone, add, ci, dl);
            dao.insertRentCar(idOrder, idUser, cid, typeRent, position);
            session.setAttribute("idOrder", idOrder);
            System.out.println(ci);
            System.out.println(dl);
        } catch (Exception e) {

        }

        response.sendRedirect("detailbooking");
    }

}
