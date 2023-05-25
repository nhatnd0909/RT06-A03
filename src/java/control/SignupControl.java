package control;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */


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
public class SignupControl extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            String repass = request.getParameter("repassword");
            
            if (!pass.equals(repass)) {
                request.setAttribute("messSignup", "Repeat Password not match!");
                request.setAttribute("userSignup", user);
                request.setAttribute("passSignup", pass);
                request.setAttribute("repassSignup", repass);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            } else {
                DAO dao = new DAO();
                Account acc = dao.checkUserExit(user);
                if (acc == null) {      
                    dao.createAccount(user, pass);
                    response.sendRedirect("home");
                } else {
                    request.setAttribute("userSignup", user);
                    request.setAttribute("passSignup", pass);
                    request.setAttribute("repassSignup", repass);
                    request.setAttribute("messSignup", "Username already exist!");
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
        }
    }


}