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
public class FeedBackControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        HttpSession session = request.getSession();

        try {
//                int idUser = Integer.parseInt(session.getAttribute("id").toString());
            String name = request.getParameter("name");
            String gmail = request.getParameter("gmail");
            String subject = request.getParameter("subject");
            String message = request.getParameter("message");
            dao.insertFeedBack(name, gmail, subject, message);
            String mess = "Send feedback successfully. Thanks for your contribution";
            request.setAttribute("mess", mess);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (session.getAttribute("id").toString() == null) {

            } else {
                int idUser = Integer.parseInt(session.getAttribute("id").toString());
                Account account = dao.getAccountByID(idUser);
                request.setAttribute("account", account);
            }
        } catch (Exception e) {
        }
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

}
