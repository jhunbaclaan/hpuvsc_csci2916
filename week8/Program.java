package week8;
/*
 * file with all methods
 * a program that intends to...
 1. use regex to parse user input for:
    - first name (A-Z)
    - student number (@########)
    - phone number ((###)###-####)
    - birthdate (##/##/####)
    - extra credit: student email
 * created by: jhun baclaan
 * d.o.c: march 3, 2023
 */
import java.util.*;

public class Program {
    public Program()
    {
        String input, firstName, studentNumber, studentPhoneNumber, studentBirthdate, studentEmail;
        Scanner sc = new Scanner(System.in);
        System.out.println("-=-=-=- RegEx Program -=-=-=-");
        System.out.print("Please enter your first name (alphabetical characters only A-Z): ");
        input = sc.nextLine();
        while (!firstName(input)) // input validation loop
        {
            System.out.println("Enter your first name with alphabetical (A-Z) characters only!!");
            System.out.print("Please enter your first name (alphabetical characters only A-Z): ");
            input = sc.nextLine();
        }
        firstName = input;
        System.out.println(); // whitespace

        System.out.print("Please enter your student ID number (format @#########): ");
        input = sc.nextLine();
        while (!studentNumber(input)) // input validation loop
        {
            System.out.println("Enter your student ID number in the format @#########!!");
            System.out.print("Please enter your student ID number (format @#########): ");
            input = sc.nextLine();
        }
        studentNumber = input;
        System.out.println(); // whitespace

        System.out.print("Please enter your phone number (format (###)###-####): ");
        input = sc.nextLine();
        while (!studentPhoneNumber(input)) // input validation loops :p
        {
            System.out.println("Enter your phone number in the format (###)###-####!!");
            System.out.print("Please enter your phone number (format (###)###-####): ");
            input = sc.nextLine();
        }
        studentPhoneNumber = input;
        System.out.println(); // whitespace

        System.out.println("Please enter your birthdate (format ##/##/####): ");
        System.out.println("Please note: 1) first number of month MUST be 0 or 1, ");
        System.out.println("2) first number of day MUST be 0-3, and");
        System.out.println("3) first number of year MUST be 1 or 2");
        System.out.print("Please enter your birthdate: ");
        input = sc.nextLine();
        while(!studentBirthdate(input)) // input validation loop
        {
            System.out.println("Please enter your birthdate in the correct format ##/##/####, and take note of the restrictions!!");
            System.out.println("Please enter your birthdate (format ##/##/####)");
            System.out.println("Please note: first number of month MUST be 0 or 1, ");
            System.out.println("first number of day MUST be 0-3, and");
            System.out.println("first number of year MUST be 1 or 2");
            System.out.print("Please enter your birthdate: ");
            input = sc.nextLine();
        }
        studentBirthdate = input;
        System.out.println(); // whitespace

        // this isnt part of extra credit but its just if the user doesnt want to do more info-inputting lol
        System.out.print("Would you like to provide your email? (y/n): ");
        input = sc.nextLine();
        if (input.charAt(0) == 'n') // no, end early
        {
            // early end without email input
            System.out.println("Name: " + firstName + ", ID: " + studentNumber + ", Phone: " + studentPhoneNumber + ", Birthdate: " + studentBirthdate);
            System.out.println("Thank you for using this program!");
            System.out.println("Goodbye!!");
            System.exit(0);
        }
        else if (input.charAt(0) == 'y') // yes, give email
        {
            System.out.print("Please input your .hpu address: ");
            input = sc.nextLine();
            while (!studentEmail(input)) // input validation loop
            {
                System.out.println("Please input your email in the correct format!!");
                System.out.print("Please input your .hpu address: ");
                input = sc.nextLine();
            }
            studentEmail = input;
            System.out.println(); // whitespace
            // end of program after email input
            System.out.println("Name: " + firstName + ", ID: " + studentNumber + ", Phone: " + studentPhoneNumber + ", Birthdate: " + studentBirthdate + ", Email: " + studentEmail);
            System.out.println("Thank you for using this program!");
            System.out.println("Goodbye!!");
            System.exit(0);
        }
    }

    public static boolean firstName(String input)
    {
        // {1,} used because first names can be any theoretical length
        return input.matches("[a-zA-Z]{1,}");
    }

    public static boolean studentNumber(String input)
    {
        // escape sequene with the @ makes it into a literal, allows formatting to work properly
        return input.matches("\\@[0-9]{9}");
    }

    public static boolean studentPhoneNumber(String input)
    {
        return input.matches("\\([1-9]{1}[0-9]{2}\\)[0-9]{3}\\-[0-9]{4}"); // ripped from phone number regex done in class
    }

    public static boolean studentBirthdate(String input)
    {
        /*
         * a little clarification on the formatting:
         * i made sure that everything would be realistic (first number of month is 0 or 1, only up to 31 days, only from years 0000-2XXX, etc.)
         * however i can't account for the fluctuation in days per month (e.g. february has 28 days vs january's 31) 
         * ...so i just have to trust the user on their input
         */
        return input.matches("[0-1]{1}[0-9]{1}\\/[0-3]{1}[0-9]{1}\\/[0-2]{1}[0-9]{3}");
    }

    /*
     * extra credit: email input
     * regex checks for correct email format
     * ^: start of string
     * [A-Za-z0-9._%+-]: any alphanumerical char + typical email symbols
     * +@my\\.hpu\\.edu: concatenates with @my.hpu.edu set as a literal
     * $: end of string
     */
    public static boolean studentEmail(String input)
    {
        return input.matches("^[A-Za-z0-9._%+-]+@my\\.hpu\\.edu$");
    }

}
