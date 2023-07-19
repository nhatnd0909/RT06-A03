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
public class ChangePasswordControl extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        int ID = Integer.parseInt(request.getParameter("id"));
        String oddPass = dao.MD5(request.getParameter("oddPass"));
        String newPass = dao.MD5(request.getParameter("newPass"));
        String rePass = dao.MD5(request.getParameter("rePass"));
        Account account = dao.getAccountByID(ID);
        if (!account.getPassword().equals(oddPass)) {
            String mess = "Old password does not match!";
            request.setAttribute("mess", mess);
            request.setAttribute("oddPass", oddPass);
            request.setAttribute("newPass", newPass);
            request.setAttribute("rePass", rePass);
            int id = Integer.parseInt(request.getParameter("id"));
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
            String[] adds = address.split("/");
            String add = adds[0];
            String city = adds[3];
            String district = adds[2];
            String wards = adds[1];
            request.setAttribute("add", add);
            request.setAttribute("city", city);
            request.setAttribute("district", district);
            request.setAttribute("wards", wards);
            request.setAttribute("test", test);
            request.setAttribute("account", account);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else if (!newPass.equals(rePass)) {
            String mess = "Re password does not match!";
            request.setAttribute("mess", mess);
            request.setAttribute("oddPass", oddPass);
            request.setAttribute("newPass", newPass);
            request.setAttribute("rePass", rePass);
            int id = Integer.parseInt(request.getParameter("id"));
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
            String[] adds = address.split("/");
            String add = adds[0];
            String city = adds[3];
            String district = adds[2];
            String wards = adds[1];
            request.setAttribute("add", add);
            request.setAttribute("city", city);
            request.setAttribute("district", district);
            request.setAttribute("wards", wards);
            request.setAttribute("test", test);
            request.setAttribute("account", account);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            dao.updatePassword(ID, newPass);
            String mess = "Change password success!";
            request.setAttribute("mess", mess);
            int id = Integer.parseInt(request.getParameter("id"));
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
            String[] adds = address.split("/");
            String add = adds[0];
            String city = adds[3];
            String district = adds[2];
            String wards = adds[1];
            request.setAttribute("add", add);
            request.setAttribute("city", city);
            request.setAttribute("district", district);
            request.setAttribute("wards", wards);
            request.setAttribute("test", test);
            request.setAttribute("account", account);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }
}
