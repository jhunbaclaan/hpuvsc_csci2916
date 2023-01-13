package week1;
/*
 * a program that:
 1. asks user for name
 2. asks user for their height (in feet, then inches)
 3. converts height into inches
 4. asks user for weight (in lbs)
 5. calculates bmi (formula is 703 * (height / (inches^2)))
 * created by: jhun baclaan
 * date of creation: jan. 13, 2023
 */
import java.util.*; // intended for scanner
public class lab1_1132023
{
    public static void main(String[] args)
    {
        // declarization
        Scanner sc = new Scanner(System.in);
        String name;
        String category = "*";
        /*
         * initialization of all 3 doubles at once
         * weight is expected to be rounded up to a whole # though
         * trueInches refers to total height in inches (ft + inches)
         */
        double feet, inches, trueInches, weight;
        double bmi; // must be a double to satisfy math
        int counter = 0; // used for program loop

        // input
        System.out.println("welcome to my bmi calculator!");
        System.out.println(); // whitespace5
        while (counter < 5)
        {
            System.out.print("what is your name? ");
            while (isNumeric(sc.nextLine()))
            {
                System.out.println("please give me your name! "); // known error: you have to input your name twice if invalid on the first try... idk how to fix
            }
            name = sc.nextLine();

            System.out.print("how many feet tall are you? "); // expects user to input ONLY their feet (aka 5'11 would only input 5)
            while (!sc.hasNextInt())
            {
                System.out.print("invalid! try again! ");
                sc.next();
            }
            feet = sc.nextInt();

            System.out.print("how many inches tall are you? "); // expects user to input ONLY their inches (aka 5'11 would only input 11)
            while (!sc.hasNextInt())
            {
                System.out.println("invalid! try again!");
                sc.next();
            }
            inches = sc.nextInt();

            System.out.print("what is your weight? (in lbs, round up to nearest whole #) ");
            while (!sc.hasNextInt())
            {
                System.out.println("invalid! try again!");
                sc.next();
            }
            weight = sc.nextInt();

            // math
            trueInches = (feet*12) + inches;
            //System.out.println(inches); // testing if math works
            bmi = weight / (trueInches*trueInches);
            bmi = bmi * 703;
            //System.out.println(bmi); // testing if math works
            bmi = (Math.round(bmi)); // rounds up to a whole number, makes it easier
            //System.out.println(bmi); // testing if round works

            // bmi evaluation process
            if (bmi < 19)
            {
                category = "underweight";
            }
            else if (bmi >= 19 && bmi < 25)
            {
                category = "healthy";
            }
            else if (bmi >= 25 && bmi < 30)
            {
                category = "overweight";
            }
            else if (bmi >= 30)
            {
                category = "obese";
            }
            //System.out.println(category); // tests category eval.

            // output process
            System.out.println(); // whitespace
            System.out.println("__results__");
            System.out.println("name\t" + "height\t\t\t" + "weight\t" + "bmi value\t" + "category");
            System.out.println(name + "\t" + feet + " feet, " + inches + " inches\t" + weight + "\t" + bmi + "\t\t" + category);
            System.out.println(); // whitespace

            counter++;
        }
        System.out.println("thank you for using my program!");
        System.out.println("goodbye!");
        sc.close();
    }

    /*
     * extra credit 1 - input validation
     * method used to validate strings, prevents numeric input
     */
    private static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
      }
}