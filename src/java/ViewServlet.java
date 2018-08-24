/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;  
import java.io.PrintWriter;  
import java.util.List;  
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
@WebServlet(urlPatterns = {"/ViewServlet"})
public class ViewServlet extends HttpServlet {
    
    /*
        1. This class is used to display all books in browser using HTML elements.
        2. Using each for loop to iterate through all books from the database.
        3. getAllBooks() function from class DBOperations is used  to get all the books from the database.
    */

   protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        out.println("<html><head><link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css\"></head>");
        out.println("<div class=\"container\"><a class=\"text-center list-group-item list-group-item-action group-item-success\" style='margin-top:10px;margin-left:250px;width:600px;' href='index.html'>Add New Book</a>");  
        out.println("<h4>Books List</h4>");  
        out.println("<hr>"); 
          
        List<Books> list=DBOperations.getAllBooks();  /* Storing all books in a Arraylist from the DBOperations using getAllBooks method */
          
        out.print("<table class=\"table\""); /* Creating table view */ 
        out.print("<tr><th scope=\"col\">Title</th><th scope=\"col\">Author</th><th scope=\"col\">Price</th><th scope=\"col\">Operations</th></tr>");  
        
        for(Books b:list){  /* Iterating list through all elements */
            
            String msg = "Sure to delete " + b.getTitle() + "?"; /* Prompting user for deletion operation permission*/
         out.print("<tr><td>"+b.getTitle()+"</td><td>"+b.getAuthor()+"</td><td>"+b.getPrice()+"</td>" + "<td><a class=\"btn btn-success\" href='EditServlet?id="+b.getId()+"'>Edit</a> &nbsp; &nbsp;<a class=\"btn btn-danger\" onclick=\"return confirm('"+msg+"')\" href='DeleteServlet?id="+b.getId()+"'>Delete</a> &nbsp; &nbsp;<a class=\"btn btn-primary\"  href='EmailSendServlet?id="+b.getId()+"'>SENT E-MAIL</a></td></tr>");  
        }  
        out.print("</table></div></html>");  /* Closing HTML tag */
          
        out.close();  /* Closing connection */
    }  
}
