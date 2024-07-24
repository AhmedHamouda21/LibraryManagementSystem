/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laibrarymangmentsystem;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class CustomerManager 
{
    static Scanner input=new Scanner(System.in);
    static ArrayList<Customer> customers =new ArrayList<>();
    static ArrayList<Book> bill =new ArrayList<>();
    
    static Customer getEmailCustomer(String n,String pass)
    {
        for(Customer c:customers)
        {
            if(c.getName().equals(n)&&c.getPassword().equals(pass))
            {
                return c;
            }   
        }
        return null;
    }       
   
    //__________________________________________________________________________
    
    static void createAccount()
    {
        System.out.println("Enter your name: ");
        String nam = input.next();
        System.out.println("Enter your password: ");
        String pass = input.next();
        
        Customer newCustomer=new Customer(nam,pass);
        customers.add(newCustomer);
        System.out.println("Account created successfully 🎉");
        
    }
    
    //__________________________________________________________________________
    
    static void login()
    {
        System.out.println("Enter your name: ");
        String nam = input.next();
        System.out.println("Enter your password: ");
        String pass = input.next();
        
        Customer c=getEmailCustomer(nam,pass);
        if(c==null)
        {
            System.out.println("Account not found 🔍");
            CustomerAuthontication();
        }
        else
        {
            customerMenu();
        }
        
    }
    
    //__________________________________________________________________________

    static void CustomerAuthontication() 
    {
        System.out.println("====== Customer Authontication Menu ======");
        System.out.println("    1- Sign up                            ");
        System.out.println("    2- Log in                             ");
        System.out.println("    3- Exit                               ");
        System.out.println();
        System.out.println("      Enter your choice                   ");
        System.out.println("==========================================");
        int ch=input.nextInt();
        switch (ch)
        {
                case 1:
                    createAccount();
                    CustomerAuthontication();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    LaibraryMangmentSystem.mainMenu();
                    break;
                default:
                    System.out.println("Please enter a valid choice 😡");
                    CustomerAuthontication();
                    break;
                    
        }
    }
    
    //__________________________________________________________________________
    
    static void customerMenu()
    {
        System.out.println("============== Customer Menu =============");
        //System.out.println("    1- Search book                        ");
        System.out.println("    1- Buy    book                        ");
        System.out.println("    2- Brrow  book                        ");
        System.out.println("    3- Return book                        ");
        System.out.println("    4- Know   Bill                        ");
        System.out.println("    5- Exit                               ");
        System.out.println();
        System.out.println("      Enter your choice                   ");
        System.out.println("==========================================");
        int ch=input.nextInt();
        switch(ch)
        {
//            case 1:
//                BookManager.search();
//                customerMenu();
//                break;
            case 1:
                BookManager.buyBook();
                customerMenu();
                break;
            case 2:
                BookManager.brrowBook();
                customerMenu();
                break;
            case 3:
                BookManager.returnBook();
                customerMenu();
                break;
            case 4:
                knowBill();
                customerMenu();
                break;
            case 5:
                CustomerAuthontication();
                break;
            default:
                System.out.println("Please enter a valid choice 😡");
                    CustomerAuthontication();
                    break;
        }
    }
    
    //__________________________________________________________________________
    
    static void knowBill()
    {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        System.out.println("============== Your Bill =============");
        System.out.println("Date :"+now.format(dateFormatter));
        System.out.println("Time :"+now.format(timeFormatter));
        System.out.println("    Item Name          |    Price");
        for(Book item :bill)
        {
            item.info2();
        }
        System.out.println("======================================");
    }
    
    //__________________________________________________________________________
    
    


    
}
