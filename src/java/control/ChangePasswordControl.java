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
//        DAO dao = new DAO();
//        int ID = Integer.parseInt(request.getParameter("id"));
//        Account account = dao.getAccountByID(ID);
//        String oddPass = request.getParameter("oddPass");
//        String newPass = request.getParameter("newPass");
//        String rePass = request.getParameter("rePass");
//        if(!account.getPassword().equals(oddPass)){
//            String mess = "Your odd pass does not match!";
//            request.setAttribute("mess", mess);
//            request.setAttribute("oddPass", oddPass);
//            request.setAttribute("newPass", newPass);
//            request.setAttribute("rePass", rePass);
//            request.getRequestDispatcher("profile");
//        }
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
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else if (!newPass.equals(rePass)) {
            String mess = "Re password does not match!";
            request.setAttribute("mess", mess);
            request.setAttribute("oddPass", oddPass);
            request.setAttribute("newPass", newPass);
            request.setAttribute("rePass", rePass);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            dao.updatePassword(ID, newPass);
            String mess = "Change password success!";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }
}
