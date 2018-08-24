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
@WebServlet(urlPatterns = {"/SaveServlet"})
public class SaveServlet extends HttpServlet 
{       
   /*
        1. This class is use to save books to the database.
        2. Getting title, author and price from user to store using Book class methods.
        3. Displaying confirmation message, if data inserted or not to the database.   
    */ 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); 
        
        PrintWriter out=response.getWriter();
        out.println("<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"></head>");
          
        String ttle = request.getParameter("title");    /* Getting title from user and storing to ttle variable */
        String athor = request.getParameter("author");  /* Getting author name from user and storing variable */  
        String prce = request.getParameter("price");    /* Getting price from user and storing to prce variable */
       
        
        Books objectBook = new Books();                 /* Creating Books class object objectBook */
        
        objectBook.setTitle(ttle);                      /* using setTitle method from Books class to set title */
        objectBook.setAuthor(athor);                    /* using setAuthor method from Books class to set author name */
        objectBook.setPrice(prce);                      /* using setPrice method from Books class to set price */
        
        
        int status = DBOperations.save(objectBook);     /* This is Books class method to save details using Save method */
        if(status>0){                                   /* Checking if data store save or not to the database */
//          out.print("<p>Record saved successfully!</p>"); 
            out.print("Record saved successfully!");    /* Printing message as Record inserted to the database */
            request.getRequestDispatcher("index.html").include(request, response); /* Then, redirecting user to the index.html page */ 
        }else{ 
            out.print("Sorry! unable to save record");  /* Printing message as Record unable to save in the database */
        }          
        out.close();                                    /* Closing connection */
    }

}
