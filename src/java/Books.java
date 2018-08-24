/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arjun Thakor
 */

    /*
        This class is used to get and set values of the books.
    */
public class Books {
    
    /* Variable declarations */
    public int id;
    public String title;
    public String author;
    public String price;
    
    public Books(){} /* Default Constructor */ 
    
    public Books(int id, String title, String author, String price){ /* Paramaterize Constructor */
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {    /* Method for getting ID */
        return id;
    }

    public void setId(int id) {     /* Method for setting ID */
        this.id = id;
    }

    public String getTitle() {      /* Method for getting book getTitle */
        return title;
    }

    public void setTitle(String title) {    /* Method for setting Book Title */
        this.title = title;
    }

    public String getAuthor() { /* Method for getting Author name */
        return author;
    }

    public void setAuthor(String author) {  /* Method for setting Author name */
        this.author = author;
    }

    public String getPrice() {              /* Method for getting book price */
        return price;
    }

    public void setPrice(String price) {    /* Method for setting book price */
        this.price = price;
    }  
    
    
}
