/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import dao.DAO;
import entity.Account;
import entity.Car;
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
public class IncomeControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            String uid = session.getAttribute("id").toString();
            if (!uid.equalsIgnoreCase("2")) {
                response.sendRedirect("home");
            } else {
                int totalCar = dao.getTotalCar();
                int totalUser = dao.getTotalUser();
                List<Account> listUser = dao.getAllAccount();
                List<Car> listCar = dao.getListFeatureCar();
                request.setAttribute("totalCar", totalCar);
                request.setAttribute("totalUser", totalUser);
                request.setAttribute("listUser", listUser);
                request.setAttribute("listCar", listCar);
                int totalIncome = dao.getTotalIncome();
                request.setAttribute("totalIncome", totalIncome);
                request.getRequestDispatcher("income.jsp").forward(request, response);
            }
        } catch (Exception e) {
            response.sendRedirect("loginForm.jsp");
        }
    }
}
