package week10;
// runner/demo file
/*
 Motorcycle
 - year : int
 - speed : int
 - make : String
 + Motorcycle(m : String, y : int, s : int)
 + Motorcycle()
 + setMake(m : String) : void
 + setYear(y : int) : void
 + setSpeed(s : int) : void
 + getMake() : String
 + getYear() : int
 + getSpeed() : int
 + accelerate() : int
 + brake() : int
 + toString() : String
 */
/*
 * created by: jhun baclaan
 * d.o.c: march 17, 2023
 */
import java.util.*;
public class lab9_3172023 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String m;
        int y;
        // using the first constructor; "custom moped creation"
        System.out.println("-=-=-=- Moped Program [RUN 1] -=-=-=-");
        System.out.print("Enter the year of your Moped (1980 - 2023): ");
        y = sc.nextInt();
        sc.nextLine(); // prevents errors with input validation
        while (y < 1980 || y > 2023)
        {
            System.out.println("Please enter a year from 1980 - 2023.");
            System.out.print("Enter the year of your Moped (1980 - 2023): ");
            y = sc.nextInt();
            sc.nextLine(); // prevents errors with input validation
        }
        System.out.print("Enter the make of your Moped (such as Yamaha, Vespa, Lexmoto): ");
        m = sc.nextLine();
        Moped moped = new Moped(m, y);
        for (int i = 0; i < 4; i++) // for loops have been added to make it easier to read the program
        {
            moped.accelerate();
            System.out.println(moped.toString());
        }
        for (int i = 0; i < 3; i++)
        {
            moped.brake();
            System.out.println(moped.toString());
        }
        System.out.println(); // whitespace

        // using the other constructor; setting values via setter methods
        Moped moped2 = new Moped();
        System.out.println("-=-=-=- Moped Program [RUN 2] -=-=-=-");
        System.out.print("Enter the year of your Moped (1980 - 2023): ");
        y = sc.nextInt();
        sc.nextLine(); // prevents errors with input validation
        moped2.setYear(y);
        while (y < 1980 || y > 2023) // input validation for year
        {
            System.out.println("Please enter a year from 1980 - 2023.");
            System.out.print("Enter the year of your Moped (1980 - 2023): ");
            y = sc.nextInt();
            sc.nextLine(); // prevents errors with input validation
            moped2.setYear(y);
        }
        System.out.print("Enter the make of your Moped (such as Yamaha, Vespa, Lexmoto): ");
        m = sc.nextLine();
        moped2.setMake(m);
        for (int i = 0; i < 4; i++)
        {
            moped2.accelerate();
            System.out.println(moped2.toString());
        }
        for (int i = 0; i < 3; i++)
        {
            moped2.brake();
            System.out.println(moped2.toString());
        }
        System.out.println(); // whitespace

        // generic moped showcase (no changes to a non-argument constructed moped)
        Moped genericMoped = new Moped();
        System.out.println("-=-=-=- Moped Program [RUN 3] -=-=-=-");
        System.out.println("This run will showcase a \"generic\" moped. ");
        for (int i = 0; i < 4; i++)
        {
            genericMoped.accelerate();
            System.out.println(genericMoped.toString());
        }
        for (int i = 0; i < 3; i++)
        {
            genericMoped.brake();
            System.out.println(genericMoped.toString());
        }
        System.out.println(); // whitespace

        // end program after run 3
        System.exit(0);
        sc.close();
    }
}
