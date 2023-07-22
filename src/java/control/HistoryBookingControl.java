/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Account;
import entity.Car;
import entity.OrderDetail;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ACER
 */
public class HistoryBookingControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        int typeRentCar = 0, typeReceiveCar = 0, methodPayCar = 0;
        try {
            String uid = session.getAttribute("id").toString();
            List<OrderDetail> list = dao.getOrderDetailByIdUser1(uid);
            int totalOrder = list.size();
            int size = list.size();
            int totalItems = list.size();
            int itemsPerPage = 9;
            int currentPage = (request.getParameter("page") != null) ? Integer.parseInt(request.getParameter("page")) : 1;
            int offset = (currentPage - 1) * itemsPerPage;
            List<OrderDetail> pageOrder = list.subList(offset, Math.min(offset + itemsPerPage, totalItems));
            int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
            
            List<String> listIDCar = new ArrayList<>();
            for (OrderDetail o : list) {
                listIDCar.add(o.getIdCar());
            }
            List<Car> listCar = new ArrayList<>();
            for (String o : listIDCar) {
                listCar.add(dao.getCarByID(o).get(0));
            }
            List<String> listCarName = new ArrayList<>();
             for (Car o : listCar) {
                listCarName.add(o.getCarName());
            }
            int id = Integer.parseInt(uid);
            Account user = dao.getAccountByID(id);
            String name = user.getName();
            request.setAttribute("name", name);
            request.setAttribute("listCarName", listCarName);
            request.setAttribute("totalOrder", totalOrder);
            request.setAttribute("totalPages", totalPages);
            request.setAttribute("currentPage", currentPage);
            request.setAttribute("listOrder", pageOrder);

        } catch (Exception e) {
        }

        request.getRequestDispatcher("historyBooking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
