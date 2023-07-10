/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package control;

import dao.DAO;
import entity.Account;
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
public class ProfileControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        DAO dao = new DAO();

        Account account = dao.getAccountByID(id);
        int test = 0;
        if (account.getGender() == null) {
            account.setGender("Female");
            if ((account.getGender()).equals("Male")) {
                test = 1;
            } else {
                test = 0;
            }
        } else {
            if ((account.getGender()).equals("Male")) {
                test = 1;
            } else {
                test = 0;
            }
        }
        String address = account.getAddress();
        if (address == null) {

        } else {
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

        request.setAttribute("test", test);
        request.setAttribute("account", account);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
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
        int ID = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String citizenIdentification = request.getParameter("citizenIdentification");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String email = request.getParameter("email");

//        String address = "";
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String district = request.getParameter("district");
        String wards = request.getParameter("wards");
        String add = address + "/" + wards + "/" + district + "/" + city;

        String ci = request.getParameter("ci");
        String dl = request.getParameter("dl");
        dao.updateAccount2(ci, dl, ID);
        dao.updateAccount(ID, name, phone, citizenIdentification, dob, gender, email, add);
        Account account = dao.getAccountByID(ID);
        int test = 0;
        if ((account.getGender()).equals("Male")) {
            test = 1;
        } else {
            test = 0;
        }

        request.setAttribute("test", test);
        request.setAttribute("account", account);

        request.setAttribute("add", address);
        request.setAttribute("city", city);
        request.setAttribute("district", district);
        request.setAttribute("wards", wards);
        System.out.println(add + city + district + wards);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
    }
}
