/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laibrarymangmentsystem;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class BookManager 
{
    static Scanner input=new Scanner(System.in);
    static ArrayList<Book> books =new ArrayList<>();
    

    //__________________________________________________________________________
    
    static void viewAll()
    {
        if(books.isEmpty())
        {
            System.out.println("Not found any book 😞 ");
        }
        else
        {
            System.out.println("Total books : "+books.size());
            for(Book book:books)
            {
                book.info();
            }
        }
    }

    //__________________________________________________________________________
    
    static void addBook()
    {
        System.out.println("Enter the book name");
        String name=input.next();
        System.out.println("Enter the author name");
        String author=input.next();
        System.out.println("Enter the price ");
        double price=input.nextDouble();
        Book newBook=new Book(name,author,price,true);
        books.add(newBook);
        System.out.println("Book added successfully ✅");
        System.out.println();
    }
    
    //__________________________________________________________________________
    
    static void removeBook()
    {
        if(books.isEmpty())
        {
            System.out.println("Not found any book 😞 ");
        }
        else
        {
            System.out.println("Enter the book name");
            String name=input.next();
            Book book =getBook(name);
            if(book==null)
            {
                System.out.println("Not found this book 👀");
            }
            else
            {
                books.remove(book); 
                System.out.println("Book removed successfully ✅");
                System.out.println();
            }
            
        }
    }
    
    //__________________________________________________________________________
    
    static Book getBook(String name)
    {
        for(Book book: books)
        {
            if(book.getName().equals(name))
                return book;
        }
        return null;
    }
    
    //__________________________________________________________________________
    
    static void update()
    {
        if(books.isEmpty())
        {
            System.out.println("Not found any book 😞");
            
        }
        else
        {
            System.out.println("Enter the name book");
            String name =input.next();
            Book book =getBook(name);
            if(book==null)
            {
                System.out.println("Not found this book 👀");
            }
            else
            {
                System.out.println("============== Update Menu ===============");
                System.out.println("    1- Update the name                    ");
                System.out.println("    2- Update the Author                  ");
                System.out.println("    3- Update the price                   ");
                System.out.println("    4- Exit                               ");
                System.out.println();
                System.out.println("      Enter your choice                   ");
                System.out.println("==========================================");
                int ch=input.nextInt();
                switch(ch)
                {
                    
                    case 1:
                        System.out.println("Enter the new name");
                        String newName=input.next();
                        book.setName(newName);
                        System.out.println("the name has been changed successfully"); 
                        book.info();
                        AdminManager.adminMenu();
                        break;

                    case 2:
                        System.out.println("Enter the new author name");
                        String newAuthor=input.next();
                        book.setAuthor(newAuthor);
                        System.out.println("the Author name has been changed successfully"); 
                        book.info();
                        AdminManager.adminMenu();
                        break;

                    case 3:
                        System.out.println("Enter the new price");
                        double newPrice=input.nextDouble();
                        book.setPrice(newPrice);
                        System.out.println("the Price has been changed successfully"); 
                        book.info();
                        AdminManager.adminMenu();
                        break;

                    case 4:
                        AdminManager.adminMenu();
                    default:
                        System.out.println("Please enter a valid choice 😡");
                        update();
                        break;
                }
            }
        }
    }
    //__________________________________________________________________________
    static void search()
    {
        if(books.isEmpty())
        {
            System.out.println("Not found any book 😞 ");
        }
        else
        {
            System.out.println("================= Search Menu ==================");
            System.out.println("    1- Search by book name                      ");
            System.out.println("    2- Searching for all books by the author:   ");
            System.out.println("    3- Exit                               ");
            System.out.println();
            System.out.println("      Enter your choice                   ");
            System.out.println("==========================================");
            int ch=input.nextInt();
            switch(ch)
            {
                case 1:
                    System.out.println("Enter the name");
                    String name=input.next();
                    Book book =getBook(name);
                    if(book==null)
                    {
                        System.out.println("Not found this book 👀");
                    }
                    else
                    {
                        book.info();
                    }
                    search();
                    break;

                case 2:
                    System.out.println("Enter the author name");
                    String authorName=input.next();
                    for(Book book2 : books)
                    {
                        if(book2.getAuthor().equals(authorName))
                        {
                            book2.info();
                        }
                    }
                    search();
                    break;

                case 3:
                    AdminManager.adminMenu();
                    break;
                default:
                    System.out.println("Please enter a valid choice 😡");
                    search();
                    break;
            }
        }
    }
    
    //__________________________________________________________________________
    
    static void buyBook()
    {
        System.out.println("Enter the name");
        String name=input.next();
        Book book =getBook(name);
        if(book==null)
        {
            System.out.println("Not found this book 👀");
        }
        else
        {
            if(book.isIsAvilable())
            {
                books.remove(book);
                CustomerManager.bill.add(book);
                System.out.println("The book has been sold and added to the cart 📚🛒");
                System.out.println();
            }
            else
            {
                System.out.println("This book is borrowed ( Not Avilable ) ");
            }
        }
        
    }
    
    //__________________________________________________________________________
    
    static void brrowBook()
    {
        System.out.println("Enter the name");
        String name=input.next();
        Book book =getBook(name);
        if(book==null||book.isIsAvilable()==false)
        {
            System.out.println("Not found this book 👀");
        }
        else
        {
            if(book.isIsAvilable())
            {
               book.setIsAvilable(false);
               System.out.println("The book has been successfully borrowed 📚✅");
               System.out.println();
            }
            else
            {
                System.out.println("This book is borrowed ( Not Avilable ) ");
            }
            
        }
    }
    
    //__________________________________________________________________________
    
    static void returnBook()
    {
        System.out.println("Enter the name");
        String name=input.next();
        Book book =getBook(name);
        if(book==null)
        {
            System.out.println("Not found this book 👀");
        }
        else
        {
            
            book.setIsAvilable(true);
            System.out.println("The book has been successfully returned 📚✅");
            System.out.println();
        }
    }
    
    //__________________________________________________________________________
    
    static void borrowedBooks()
    {
        if(books.isEmpty())
        {
            System.out.println("Not found any book 😞");
        }
        for(Book book: books)
        {
            if(book.isIsAvilable()==false)
                book.info3();
        }        
    }
}
