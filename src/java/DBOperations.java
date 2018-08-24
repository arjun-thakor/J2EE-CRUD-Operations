
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arjun Thakor
 */
public class DBOperations {
    
    public static Connection getConnection() { /* Connection method to established connection to the database */
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver"); /* Driver name of the database */
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");/* Connection URL with name and password */
        } catch (Exception e) {
            System.out.println(e);/* Printing any exception message if occurs */
        }
        return con; /* Returning connection variable */ 
    }

    
    public static int save(Books ob) { /* Method to save book to the database */
        int status = 0;
        try {
            Connection con = DBOperations.getConnection(); /* Opening connection */
            PreparedStatement ps = con.prepareStatement(
                    "insert into books(title,author,price) values (?,?,?)"); /* Database insert statement to insert data into the Books table*/
            ps.setString(1, ob.getTitle());
            ps.setString(2, ob.getAuthor());/* Setting values of the fields */
            ps.setString(3, ob.getPrice());
           

            status = ps.executeUpdate(); /*  */ 

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return status;
    }
    
    
     public static int update(Books b) { /* Method to update book information to the database */
        int status = 0;
        try {
            Connection con = DBOperations.getConnection(); /* Opening connection */
            PreparedStatement ps = con.prepareStatement(
                    "update books set title=?,author=?,price=? where id=?"); /* Database update statement to alter data of book to the Books table*/
            ps.setString(1, b.getTitle());
            ps.setString(2, b.getAuthor());/* Setting values of the fields */
            ps.setString(3, b.getPrice());
            ps.setInt(4, b.getId());
            

            status = ps.executeUpdate();

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return status;
    }
     
     
     
     public static int delete(int id) { /* Method to delete book from the database using ID */
        int status = 0;
        try {
            Connection con = DBOperations.getConnection(); /* Opening connection */
            PreparedStatement ps = con.prepareStatement("delete from books where id=?"); /* Delete statement using ID */
            ps.setInt(1, id);    /* Setting value of the field */
            status = ps.executeUpdate();

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status; /* Returning Status */
    }


    
    
     public static List<Books> getAllBooks() { /* Method to get all book from the database */
        List<Books> list = new ArrayList<Books>(); /* Declaring list of book type */

        try {
            Connection con = DBOperations.getConnection(); /* Opening connection */
            PreparedStatement ps = con.prepareStatement("select * from books");/* Select statement to retrieve data from the database table */
            ResultSet rs = ps.executeQuery(); /* Executing preparedstatement using resultset executeQuery method */
            while (rs.next()) { /* Iterate through next() method if table has next row */
                Books b = new Books(); /* Creating book class object */
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                
                list.add(b); /* Adding books detail to the list */
            }
            con.close(); /* Closing connection */
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list; /* Returning list */
    }
     
     
     public static List<Books> getBook(int id) { /* Method to get book from the database by ID*/
        List<Books> list = new ArrayList<Books>(); /* Declaring list of Book type */

        try {
            Connection con = DBOperations.getConnection(); /* Opening connection */
            PreparedStatement ps = con.prepareStatement("select * from books where id=" + id); /* Select statement by using ID */
            ResultSet rs = ps.executeQuery(); /* Executing preparedstatement using resultset executeQuery method */
            while (rs.next()) { /* Iterate through next() method if table has next row */
                Books b = new Books(); /* Creating book class object */
                b.setId(rs.getInt("id"));
                b.setTitle(rs.getString("title"));
                b.setAuthor(rs.getString("author"));
                b.setPrice(rs.getString("price"));
                
                list.add(b); /* Adding books detail to the list */
            }
            con.close();    /* Closing connection */
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list; /* Returning list */
    }

}
