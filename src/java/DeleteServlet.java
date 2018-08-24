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
@WebServlet(urlPatterns = {"/DeleteServlet"})
public class DeleteServlet extends HttpServlet {

    /*
        1. This class is used to performed delete operation to the database table.
        2. Using DatabaseOperations class methods to remove books.
        3. After deletion of book(s), redirecting user to the ViewServlet Class.
        
    */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String sid=request.getParameter("id");  /* Getting ID of books to perform delete operation */
        int id=Integer.parseInt(sid);           /* Converting String type to Integer using parseInt() method */
        
        DBOperations.delete(id);                /* Using delete method from DBOperations class by ID */
        response.sendRedirect("ViewServlet");   /* Redirecting user to the ViewServlet Class */
    }  
}
