package week4;
/*
 * a program that intends to:
 1. loop through a menu program, which can:
 2a. enter sales figures (through a file), HAS TO BE DONE FIRST
 2b. display sales figures
 2c. display total sales
 3. have an exit
 * created by: jhun baclaan
 * d.o.c: feb 3, 2023
 */
import java.util.*;
import java.io.*;
public class lab4_232023 {
    public static void main(String[] args) throws IOException
    {
        // initialization
        Scanner sc = new Scanner(System.in);
        // variable for input
        double totalSales = 0;
        int choice = 0; // initialize to make the menu work..

        // big menu loop
        while (choice != 6)
        {
            System.out.println("-=-=-=- File Menu -=-=-=-");
            System.out.println("1. Enter Sale Figures (in File) -- MUST BE DONE FIRST");
            System.out.println("2. Display Sales Figures");
            System.out.println("3. Display Total Sales");
            /* 
            * extra credit options
            * option 4 takes the average of all values in sales.txt
            * option 5 erases all values from the text file
            */
            System.out.println("4. Average of Your Sales");
            System.out.println("5. Erase ALL Sales Figures");
            System.out.println("6. Exit Program");
            System.out.print("enter choice: ");
            choice = sc.nextInt();
            if (choice == 1) // input sales
            {
                PrintWriter salesFile = new PrintWriter("Sales.txt");    
                System.out.print("how many figures do you have to enter? ");
                int salesCount = sc.nextInt();
                for (int i = 1; i <= salesCount; i++)
                {
                    System.out.print("enter week " + i + " sales figure: ");
                    salesFile.println(sc.nextDouble());
                }
                salesFile.close();
            }
            else if (choice == 2) // show all sales values
            {
                File openSales = new File("Sales.txt");
                Scanner fileIn = new Scanner(openSales);
                if (openSales.length() == 0) // checks if the file is empty
                {
                    System.out.println("no share values found!! please enter some then try again!");
                }
                else 
                {
                    while (fileIn.hasNext())
                    {
                        double figure = fileIn.nextDouble();
                        System.out.println(figure);
                    }
                    fileIn.close();
                }
            }
            else if (choice == 3) // show total
            {
                File openSales = new File("Sales.txt");
                Scanner fileIn = new Scanner(openSales);
                while (fileIn.hasNext())
                {
                    totalSales += fileIn.nextDouble();
                }
                System.out.println(totalSales);
                fileIn.close();
            }
            else if (choice == 4) // average of all sales
            {
                File openSales = new File("Sales.txt");
                Scanner fileIn = new Scanner(openSales);
                double counter = 0;
                if (openSales.length() == 0) // required check because without this it just prints "Infinity"
                {
                    System.out.println("no share values found!! please enter some then try again!");
                }
                else 
                {
                while (fileIn.hasNext())
                {
                    totalSales += fileIn.nextDouble();
                    counter++;
                }
                double average = totalSales / counter;
                System.out.printf("%.2f\n", average);
                fileIn.close();
                }
            }
            else if (choice == 5) // clear sales
            {
                File openSales = new File("Sales.txt");
                FileWriter salesFileOverrider = new FileWriter(openSales);
                salesFileOverrider.write(""); // effectively erases all values of the sales file
                salesFileOverrider.close();
            }
            else if (choice == 6) // exit
            {
                System.out.println("thank you for using my program");
                System.out.println("goodbye!");
                sc.close();
            }
            else  // input validation
            {
                System.out.println("invalid choice! please select from 1 - 4");
            }
        }
    }
}
