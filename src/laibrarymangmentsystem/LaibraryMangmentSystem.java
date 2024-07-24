
package laibrarymangmentsystem;
import static laibrarymangmentsystem.CustomerManager.input;

public class LaibraryMangmentSystem 
{
    static void mainMenu()
        {
            System.out.println("=============== Main Menu ===============");
            System.out.println("    1- Admin                             ");
            System.out.println("    2- Customer                          ");
            System.out.println("    3- Exit                              ");
            System.out.println();
            System.out.println("      Enter your choice                  ");
            System.out.println("=========================================");
            int ch=input.nextInt();
            switch(ch)
            {
                case 1:
                    AdminManager.adminAuthontication();
                    break;
                case 2:
                    CustomerManager.CustomerAuthontication();
                    break;
                case 3:
                    return ;
                default:
                    System.out.println("Please enter a valid choice 😡 ");
                    mainMenu();
                    break;
            }
        }
    public static void main(String[] args) 
    {
        mainMenu();  
    }
}
