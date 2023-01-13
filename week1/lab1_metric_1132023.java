package week1;
/*
 * a program that:
 * see lab1_1132023.java for algorithm
 * functionally similar, but in the metric system
 * created by: jhun baclaan
 * date of creation: jan. 13, 2023
 */
import java.util.*;
public class lab1_metric_1132023 {
    public static void main(String[] args)
    {
        // declarization
        Scanner sc = new Scanner(System.in);
        String name;
        String category = "*";
        /*
         * initialization of all 3 doubles at once
         * weight is expected to be rounded up to a whole # though
         * centimeters refers to total height in cm (meters * 100)
         */
        double meters, centimeters, weight;
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
                System.out.println("please give me your name! "); // known error: you have to input your name twice to be valid... idk how to fix
            }
            name = sc.nextLine();

            System.out.print("how many meters tall are you? "); // input can either be whole or a decimal
            while (!sc.hasNextDouble())
            {
                System.out.print("invalid! try again! ");
                sc.next();
            }
            meters = sc.nextDouble();


            System.out.print("what is your weight? (in kg, round up to nearest whole #) ");
            while (!sc.hasNextDouble())
            {
                System.out.println("invalid! try again!");
                sc.next();
            }
            weight = sc.nextDouble();

            // math
            centimeters = (meters*100);
            //System.out.println(centimeters); // testing if math works
            bmi = weight / (centimeters*centimeters);
            bmi = bmi * 10000;
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
            System.out.println("name\t" + "height\t\t" + "weight\t" + "bmi value\t" + "category");
            System.out.println(name + "\t" + meters + " meters\t" + weight + "\t" + bmi + "\t\t" + category);
            System.out.println(); // whitespace

            counter++;
        }
        System.out.println("thank you for using my program!");
        System.out.println("goodbye!");
        sc.close();
    }

    private static boolean isNumeric(String str) { 
        try {  
          Double.parseDouble(str);  
          return true;
        } catch(NumberFormatException e){  
          return false;  
        }  
    }
}
