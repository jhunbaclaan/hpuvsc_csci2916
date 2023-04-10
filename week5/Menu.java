package week5;
import java.util.*;
/*
 * separate file for all methods used
 */
/*
 * a program that intends to:
 1. loop through a menu, which can:
 2a. convert to yen
 2b. convert to cad
 2c. convert to thb
 3. have an exit
 4. includes input validation
 */
public class Menu {
    public Menu() // main menu file
    {
        Scanner sc = new Scanner (System.in);
        boolean running = true;

        /*
         * note: this menu is an improved version of lab 4's menu
         * if you'd like more info on this menu, then please look at lab 4. i think i put comments there lol
         */
        while (running) // while the running = true, then menu loops
        {
            System.out.println("-=-=-=- conversion menu -=-=-=-");
            System.out.println("1. Convert to Japanese Yen");
            System.out.println("2. Convert to Canadian Dollar");
            System.out.println("3. Convert to Thai Baht");
            System.out.println("4. Exit program");
            System.out.print("Select the conversion (1-4): ");
            int choice = sc.nextInt();
            if (choice == 1) // convert to yen
            {
                System.out.print("Enter the amount of US dollars you'd like to convert: ");
                double dollars = sc.nextDouble();
                while (isPositive(dollars) == false)
                {
                    System.out.println("Please enter a positive value greater than 0! ");
                    System.out.print("Enter the amount of US dollars you'd like to convert: ");
                    dollars = sc.nextDouble();
                }
                double yen = convertToYen(dollars);
                System.out.printf("%.2f USD = %.2f Yen\n", dollars, yen);
            }
            else if (choice == 2) // convert to cad
            {
                System.out.print("Enter the amount of US dollars you'd like to convert: ");
                double dollars = sc.nextDouble();
                while (isPositive(dollars) == false)
                {
                    System.out.println("Please enter a positive value greater than 0! ");
                    System.out.print("Enter the amount of US dollars you'd like to convert: ");
                    dollars = sc.nextDouble();
                }
                double cad = convertToCad(dollars);
                System.out.printf("%.2f USD = %.2f CAD\n", dollars, cad);
            }
            else if (choice == 3) // convert to thb
            {
                System.out.print("Enter the amount of US dollars you'd like to convert: ");
                double dollars = sc.nextDouble();
                while (isPositive(dollars) == false)
                {
                    System.out.println("Please enter a positive value greater than 0! ");
                    System.out.print("Enter the amount of US dollars you'd like to convert: ");
                    dollars = sc.nextDouble();
                }
                double thb = convertToThb(dollars);
                System.out.printf("%.2f USD = %.2f THB\n", dollars, thb);
            }
            else if (choice == 4) // exit
            {
                System.out.println("Thank you for using my program!");
                System.out.println("Goodbye! ");
                sc.close();
                running = false;
            }
            else // input validation
            {
                System.out.println("Invalid choice! Please select from 1 - 4");
                
            }
        }
    }
    // conversion methods
    public static double convertToYen(double dollars)
    {
        double yen = dollars * 131.48;
        return yen;
    }

    public static double convertToCad(double dollars)
    {
        double cad = dollars * 1.34;
        return cad;
    }

    public static double convertToThb(double dollars)
    {
        double thb = dollars * 33.74;
        return thb;
    }

    // validate positive dollar amount
    public static boolean isPositive(double dollars)
    {
        if (dollars <= 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}
