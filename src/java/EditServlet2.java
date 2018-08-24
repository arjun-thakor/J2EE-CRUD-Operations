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
@WebServlet(urlPatterns = {"/EditServlet2"})
public class EditServlet2 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        /* Storing input values in to the variables using getParameter() function */
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
        String title=request.getParameter("title");  
        String author=request.getParameter("author");  
        String price=request.getParameter("price");  
       
     
        Books objectBook = new Books();      /* Creating an object of Books class to set values using book class methods */
        objectBook.setId(id);
        objectBook.setTitle(title);
        objectBook.setAuthor(author);
        objectBook.setPrice(price);
       
         
        int status=DBOperations.update(objectBook); /* Accessing DBOperation update method to update book information */ 
        if(status>0){  /* Checking status and redirecting user to ViewServlet */
            response.sendRedirect("ViewServlet");  
        }else{  
            out.println("Sorry! unable to update record");  /* Printing message if unable to update information */
        }  
          
        out.close();  /* Closing connection */
    }
}
