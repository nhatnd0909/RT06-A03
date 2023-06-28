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
public class ForgotPasswordControl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        DAO dao = new DAO();
        try {
            String email = request.getParameter("email");
            Account account = dao.findEmailExit(email);
            if (account == null) {
                String mess = "Email does not exist";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("forgotPassword.jsp").forward(request, response);
            } else {

                int min = 100000;
                int max = 999999;
                int otp = (int) (Math.random() * (max - min + 1) + min);

                String text = "Verification Code: \n" + String.valueOf(otp);
                HttpSession sessionOTP = request.getSession();
                sessionOTP.setAttribute("otp", otp);
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
                final String to = email;
                try {
                    MimeMessage msg = new MimeMessage(session);
                    msg.setFrom(from);
                    msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
                    msg.setSubject("Verification");
                    msg.setSentDate(new Date());
                    msg.setText(text);
                    Transport.send(msg);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                request.setAttribute("account", account);
                request.setAttribute("otp", otp);
                sessionOTP.setAttribute("account", account);
                request.setAttribute("account", account);
//                System.out.println(sessionOTP.getAttribute("otp"));
//                System.out.println(sessionOTP.getAttribute("account"));
            }
        } catch (Exception e) {
        }

        request.getRequestDispatcher("verification.jsp").forward(request, response);
    }

}
