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
public class RegisterControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String rePass = request.getParameter("rePass");
            if (!rePass.equals(password)) {
                String mess = "! Re-password does not match ";
                request.setAttribute("mess", mess);
                request.setAttribute("name", name);
                request.setAttribute("email", email);
                request.setAttribute("username", username);
                request.setAttribute("password", password);
                request.setAttribute("rePass", rePass);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                Account acc = dao.checkUserExit(username);
                if (acc != null) {
                    String mess = "! Username already exists";
                    request.setAttribute("mess", mess);
                    request.setAttribute("name", name);
                    request.setAttribute("email", email);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("rePass", rePass);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                }
                Account acc1 = dao.checkEmailExit(email);
                if (acc1 != null) {
                    String mess = "! Email already exists";
                    request.setAttribute("mess", mess);
                    request.setAttribute("name", name);
                    request.setAttribute("email", email);
                    request.setAttribute("username", username);
                    request.setAttribute("password", password);
                    request.setAttribute("rePass", rePass);
                    System.out.println(acc1);
                    request.getRequestDispatcher("register.jsp").forward(request, response);
                } else {
                    String mess = "Account successfully created. Please login!";
                    String pass = dao.MD5(password);
                    dao.createUser(username, pass, email, name);
                    Account account = dao.findAccountByUsername(username);
                    request.getSession().setAttribute("id", account.getID());
                    request.setAttribute("mess", mess);
                    request.getRequestDispatcher("loginForm.jsp").forward(request, response);
                }
            }

        } catch (Exception e) {
        }
    }

}
