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
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ACER
 */
public class ContactControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        DAO dao = new DAO();
        HttpSession session = request.getSession();
        try {
            int idUser = Integer.parseInt(session.getAttribute("id").toString());
            Account account = dao.getAccountByID(idUser);
            request.setAttribute("account", account);
        } catch (Exception e) {
            
        }
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String emailAddress = (String) request.getParameter("gmail");
        String name = (String) request.getParameter("name");
        String subject = "Feedback - " + (String) request.getParameter("subject") + " from " + emailAddress;
        String mess = "Name of sender: " + name + "<br>" + "Email address of sender :" + emailAddress + "<br>" + "Feedback: " + (String) request.getParameter("message");
        final String from = "testemail9837@gmail.com";
        final String password = "fxnlowacyurgshgm";
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        javax.mail.Authenticator auth = new javax.mail.Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(from, password);
            }

        };
        Session session = Session.getInstance(props, auth);
        final String to = "testemail9837@gmail.com";
        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(from);
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            msg.setSubject(subject);
            msg.setSentDate(new Date());
            msg.setText(mess);
            msg.setContent(mess, "text/html");
            Transport.send(msg);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String messRe = "Your feedback has been received. Thank you for spending time to send your feedback!";
        request.setAttribute("messRe", messRe);
        request.getRequestDispatcher("contact.jsp").forward(request, response);
    }

}
