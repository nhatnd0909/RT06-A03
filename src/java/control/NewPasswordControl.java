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
public class NewPasswordControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("newPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            
            String password = request.getParameter("password");
            String confirmPass = request.getParameter("confirmPass");
            if (!password.equals(confirmPass)) {
                String mess = "Confirmation password does not match";
                request.setAttribute("mess", mess);
                request.setAttribute("password", password);
                request.setAttribute("confirmPass", confirmPass);
                request.getRequestDispatcher("newPassword.jsp").forward(request, response);
            } else {
                Account account = (Account) session.getAttribute("account");
                int id = account.getID();
                String passMD5 = dao.MD5(password);
                dao.updatePassword(id, passMD5);
                String mess = "Change password successfully ";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("loginForm.jsp").forward(request, response);
            }
        } catch (Exception e) {
        }
    }

}
