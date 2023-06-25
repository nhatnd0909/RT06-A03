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
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ACER
 */
public class LoginFormControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("loginForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            String username = request.getParameter("username");
            String passRequest = request.getParameter("password");
            String password = dao.MD5(passRequest);
            Account acc = dao.login(username, password);
            if (acc == null) {
                String mess = "! Wrong Username or Password";
                request.setAttribute("mess", mess);
                request.setAttribute("username", username);
                request.setAttribute("password", passRequest);
                request.getRequestDispatcher("loginForm.jsp").forward(request, response);
            } else {
                session.setAttribute("id", acc.getID());
                if (acc.isRole()) {
                    response.sendRedirect("home");
                } else {
                    response.sendRedirect("admindashboard");
                }
            }
        } catch (Exception e) {
        }
    }

}
