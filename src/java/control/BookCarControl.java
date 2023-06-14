/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

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
public class BookCarControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DAO dao = new DAO();
        int uid = Integer.parseInt(request.getParameter("uid"));
        String cid = request.getParameter("cid");
        Account account = dao.getAccountByID(uid);
        List<Car> Listcar = dao.getCarByID(cid);
        Car car = Listcar.get(0);
        
        HttpSession session = request.getSession();
        session.setAttribute("uid", account.getID());
        session.setAttribute("cid", car.getIdCar());
        
        request.setAttribute("account", account);
        request.setAttribute("car", car);
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
        
        int uid = Integer.parseInt(session.getAttribute("uid").toString());
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String wards = request.getParameter("wards");
        String addressUser = address+"/"+wards+"/"+district+"/"+city;
        String ci = request.getParameter("ci");
        String dl = request.getParameter("dl");
        System.out.println(name+email+phone+addressUser+ci+dl);
        
        dao.updateAccount1(uid, name, email, phone, addressUser, ci, dl);
        response.sendRedirect("home");
    }

}
