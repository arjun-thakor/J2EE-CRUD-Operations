/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Arjun Thakor
 */

/*
    This servlet handles the edit requests.
*/
@WebServlet(urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {
    
    /*
        1. This class is used to update any detail of books.
        2. By getting ID, we can change information for particular book.
        3. Using getBook() method from DBOperations class
    
    */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"></head>");
        out.println("<br><h4 class='text-center'>Update Book</h4>");
        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);
        
        
        // Requested ID
        int value = Integer.parseInt(request.getParameter("id"));
        /* Storing book information in the List from getBook() method */
        List<Books> list=DBOperations.getBook(value);  
          
        /* Iterating loop through all the book's information, getting from DBOperation class */
        for(Books b:list){  
            out.print("<div class='container'>");  /* Bootstrap code for creating form view */
            out.print("<div class='row'><div class='col-4'><p>&nbsp;</p></div>");
            out.print("<div class='col-4'>");
            out.print("<form action='EditServlet2' method='post' style:'width:500px;>");
            out.print("<input class=\"form-control\" type='hidden' name='id' value='" + b.getId() + "'/>");
            out.print("Title:<input class=\"form-control\" type='text' name='title' value='" + b.getTitle()+ "'/><br>");
            out.print("Author:<input class=\"form-control\" type='text' name='author' value='" + b.getAuthor()+"'/><br>");  
            out.print("Price:<input class=\"form-control\" type='text' name='price' value='" + b.getPrice() + "'/><br>");
           
            out.print("<br><br>");
            out.print("<input class=\"btn btn-success\" type='submit' value='Edit & Save '/>");
            out.print("");
            out.print("</div>");
            out.print("<div class='col-4'><p>&nbsp;</p></div>");
            out.print("</form></div></div></html>");

        out.close(); /* Closing connection */  
        }
        
    }
}
