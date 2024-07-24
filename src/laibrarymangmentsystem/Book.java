/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laibrarymangmentsystem;

/**
 *
 * @author Dell
 */
public class Book 
{
    private String name;
    private String author;
    private double price;
    private boolean isAvilable;

    public Book(String name, String author, double price, boolean isAvilable) 
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.isAvilable = isAvilable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isIsAvilable() {
        return isAvilable;
    }

    public void setIsAvilable(boolean isAvilable) {
        this.isAvilable = isAvilable;
    }
    
    public void info()
    {
        String statues;
        if(isIsAvilable())
            statues="( Is Avilable )";
        else
            statues="( Not Avilable )";
        System.out.println("Book Name : "+getName()+"          ِAuthor: "+getAuthor()+"          price : "+getPrice()+" 💵 "+"     "+statues);
    }
    
    public void info2()
    {
        System.out.println("Book Name : "+getName()+"         |   price : "+getPrice()+" 💵 ");
    }
    
    public void info3()
    {
        System.out.println("Book Name : "+getName()+"          ِAuthor: "+getAuthor()+"          price : "+getPrice()+" 💵 ");
    }
    
}
