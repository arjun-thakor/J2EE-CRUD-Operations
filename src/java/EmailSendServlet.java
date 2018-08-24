/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arjun Thakor
 */
@WebServlet(urlPatterns = {"/EmailSendServlet"})
public class EmailSendServlet extends HttpServlet {
    
    /* This servlet is used to send email to the specified email address with static message */ 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Books s = new Books();
        
        String username = request.getParameter(s.getAuthor());
        String password = request.getParameter("Your Password"); /* Here your password goes */
        String[] rec = new String[]{"arjunthakor00740@gmail.com"}; /* Reciever's email address */
        String[] bcc = new String[]{"arjunthakor00740@gmail.com"}; /* Bcc email address */
        String sub = "Hi, Good afternoon. We have many books for Programming, friction and many more...!!";/* Subject */
        String mess = "Test Mail.";     /* Message */

        new EmailSend().sendMail(rec, bcc, sub, mess); /* Creating object of EmailSend class and using sendMail() method to send email */ 
        response.sendRedirect("ViewServlet");   /* Redirecting user to ViewServlet servlet */
    }
}
