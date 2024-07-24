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

public class AdminManager 
{
    static Scanner input=new Scanner(System.in);
    static ArrayList<Admin> admins =new ArrayList<>();
    
    //__________________________________________________________________________
    
    static Admin getEmailAdmin(String name,String pass)
    {
        for(Admin i:admins)
        {
            if(i.getName().equals(name)&&i.getPassword().equals(pass))
            {
                return i;
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
        
        Admin newAdmin = new Admin(nam, pass);
        admins.add(newAdmin);
        System.out.println();
        System.out.println("Account created successfully 🎉");
        System.out.println();
         
    }
    
    //__________________________________________________________________________
    
    static void login()
    {
        System.out.println("Enter your name: ");
        String nam = input.next();
        System.out.println("Enter your password: ");
        String pass = input.next();
        
        Admin admin=getEmailAdmin(nam,pass);
        if(admin==null)
        {
            System.out.println();
            System.out.println("Account not found 🔍 ");
            System.out.println();
            adminAuthontication();
        }
        else
        {
            adminMenu();
        }
        
    }
    
    //__________________________________________________________________________

    static void adminAuthontication() 
    {
        System.out.println("======== Admin Authontication Menu =======");
        System.out.println("    1- Sign up                            ");
        System.out.println("    2- Log in                             ");
        System.out.println("    3- Exit                               ");
        System.out.println();
        System.out.println("      Enter your choice                    ");
        System.out.println("==========================================");
        int ch=input.nextInt();
        switch (ch)
        {
                case 1:
                    createAccount();
                    adminAuthontication();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    LaibraryMangmentSystem.mainMenu();
                    break;
                default:
                    System.out.println("Please enter a valid choice 😡 ");
                    adminAuthontication();
                    break;
                    
        }
    }
    
    //__________________________________________________________________________
    
    static void adminMenu()
    {
        System.out.println("=============== Admin Menu ===============");
        System.out.println("    1- View all books                     ");
        System.out.println("    2- Add      book                      ");
        System.out.println("    3- Remove   book                      ");
        System.out.println("    4- Search   book                      ");
        System.out.println("    5- Update   book                      ");
        System.out.println("    6- View Borrowed books                ");
        System.out.println("    7- Exit                               ");
        System.out.println();
        System.out.println("      Enter your choice                   ");
        System.out.println("==========================================");
        int ch=input.nextInt();
        switch(ch)
        {
            case 1:
                BookManager.viewAll();
                adminMenu();
                break;
            case 2:
                BookManager.addBook();
                adminMenu();
                break;
            case 3:
                BookManager.removeBook();
                adminMenu();
                break;
            case 4:
                BookManager.search();
                adminMenu();
                break;
            case 5:
                BookManager.update();
                adminMenu();
                break;
            case 6:
                BookManager.borrowedBooks();
                adminMenu();
                break;
            case 7:
                adminAuthontication();
                break;
            default:
                System.out.println("Please enter a valid choice 😡");
                adminMenu();
                break;
        }
    }
    
    //__________________________________________________________________________
    
    
    
}
