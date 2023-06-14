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
public class LoginControl extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
         try {
            DAO dao = new DAO();
            HttpSession session = request.getSession();
            String user = request.getParameter("username");
            String pass = dao.MD5(request.getParameter("password"));
            Account account = dao.login(user, pass);
            if (account != null) {
                session.setAttribute("id", account.getID());
                if (account.isRole()) {
                    response.sendRedirect("home");
                } else if (!account.isRole()) {
                    response.sendRedirect("admindashboard");
                }
            } else {
                String mess = "Wrong Username or Password!";
                request.setAttribute("messLogin", mess);
                request.setAttribute("userLogin", user);
                request.setAttribute("passLogin", pass);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }
    }
}
