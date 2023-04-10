package week6;
/*
 * separate file for all methods used
 */
/*
 * a program that intends to:
 1. loop through a menu that can:
 2a. display addition problems
 2b. display subtraction problems
 2c. display multiplaction problems
 3. have an exit
 4. includes input validation
 5. generate random numbers for practice problems, and check which is greater to prevent negative answers
 */
import java.util.*;
public class Quiz {
    public Quiz()
    {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running)
        {
            menu(sc);
        }
    }
    public static void menu(Scanner sc) // menu method
    {
        System.out.println("-=-=-=- Math Quizzer! -=-=-=-");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Exit");
        System.out.print("Enter the number of the operation you want to practice: ");
        int choice = sc.nextInt();
        if (choice == 1)
        {
            addition(sc); // i made separate methods for each operation
        }
        else if (choice == 2)
        {
            subtraction(sc);
        }
        else if (choice == 3)
        {
            multiplication(sc);
        }
        else if (choice == 4)
        {
            System.out.println("Thank you for using the Math Quizzer!");
            System.exit(0);
        }
        else
        {
            System.out.println("Pleae enter a valid number from 1-4! ");
        }
    }
    public static int[] generatePracticeNums() // made this method to return two values at once
    {
        Random rand = new Random();
        int[] generatedIntegers = new int[2]; // store into an array to return mutliple values
        generatedIntegers[0] = rand.nextInt(9) + 1;
        generatedIntegers[1] = rand.nextInt(9) + 1;
        return generatedIntegers;
    }

    public static boolean checkIfGreater(int x, int y) // just checks if x is greater than y
    {
        if (x > y)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void addition(Scanner sc)
    {
        int correct = 0;
        int incorrect = 0;
        int answer;
        for(int i = 0; i < 10; i++)
        {
            int[] numsToAdd = generatePracticeNums();
            System.out.print("What is " + numsToAdd[0] + " + " + numsToAdd[1] + " = "); // note i dont need to switch values around since its all positive addition
            answer = numsToAdd[0] + numsToAdd[1]; // store answer in variable, makes it easier to reference
            int input = sc.nextInt();
            if (input == answer)
            {
                System.out.println("Great job! You got it right!!");
                correct++;
            }
            else
            {
                System.out.println("Nice try, but it's wrong...");
                incorrect++;
            }
            if (i < 9)
            {
                System.out.println("Let's try a different question!");
                System.out.println(); // whitespace
            }
            else
            {
                break; // prevent "try a different question" statement from printing
            }
        }
        System.out.println("You answered " + correct + " correct and " + incorrect + " incorrect.");
        System.out.println(); // whitespace
    }

    public static void subtraction(Scanner sc)
    {
        int correct = 0;
        int incorrect = 0;
        int answer;
        for(int i = 0; i < 10; i++)
        {
            int[] numsToSubtract = generatePracticeNums();
            if (checkIfGreater(numsToSubtract[0], numsToSubtract[1]) == true) // if num1 > num2, then switch the values around to prevent negative values
            {
                System.out.print("What is " + numsToSubtract[0] + " - " + numsToSubtract[1] + " = ");
                answer = numsToSubtract[0] - numsToSubtract[1];
            }
            else
            {
                System.out.print("What is " + numsToSubtract[1] + " - " + numsToSubtract[0] + " = ");
                answer = numsToSubtract[1] - numsToSubtract[0];
            }
            int input = sc.nextInt();
            if (input == answer)
            {
                System.out.println(); // whitespace
                System.out.println("Great job! You got it right!!");
                correct++;
            }
            else
            {
                System.out.println(); // whitespace
                System.out.println("Nice try, but it's wrong...");
                incorrect++;
            }
            if (i < 9)
            {
                System.out.println("Let's try a different question!");
                System.out.println(); // whitespace
            }
            else
            {
                break;
            }
        }
        System.out.println("You answered " + correct + " correct and " + incorrect + " incorrect.");
        System.out.println(); // whitespace
    }
    public static void multiplication(Scanner sc)
    {
        int correct = 0;
        int incorrect = 0;
        int answer;
        for(int i = 0; i < 10; i++)
        {
            int[] numsToMultiply = generatePracticeNums();
            System.out.print("What is " + numsToMultiply[0] + " x " + numsToMultiply[1] + " = "); // again, no need to check for greater values bc its all positive multiplication
            answer = numsToMultiply[0] * numsToMultiply[1];
            int input = sc.nextInt();
            if (input == answer)
            {
                System.out.println(); // whitespace
                System.out.println("Great job! You got it right!!");
                correct++;
            }
            else
            {
                System.out.println(); // whitespace
                System.out.println("Nice try, but it's wrong...");
                incorrect++;
            }
            if (i < 9)
            {
                System.out.println("Let's try a different question!");
                System.out.println(); // whitespace
            }
            else
            {
                break;
            }
        }
        System.out.println("You answered " + correct + " correct and " + incorrect + " incorrect.");
        System.out.println(); // whitespace
    }
}
