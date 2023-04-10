package week7;

import java.util.*;
/*
 * a recreation of lab 2 with methods
 * should be functionally similar
 * created by: jhun baclaan
 * d.o.c: feb. 24 2023
 */
public class Game {
    public Game()
    {
        // declaration
        ArrayList<String> fishList = new ArrayList<String>(); // makes it easier to randomly select a fish
        Random rand = new Random(); // allows a random fish selection
        Scanner sc = new Scanner(System.in);
        String fish, input;
        int correct = 0;

        populateList(fishList);
        System.out.println("-=-=-=- WELCOME TO THE FISH GUESSING GAME -=-=-=-");

        // game
        for (int i = 1; i <= 10; i++)
        {
            fish = cpuFish(fishList, rand);
            System.out.println();
            System.out.println("ROUND " + i);
            System.out.println("i'm thinking of a fish.");
            System.out.print("is it ahi, opah, mahimahi, or ono? ");
            input = sc.nextLine().toUpperCase();

            while (matchingAnswer(fishList, input) == false)
            {
                System.out.print("please input a valid answer! "); // retry
                /* 
                 * NOTE: input is uppercase'd to become valid input
                 * if left lowercase, it will count as invalid
                */
                input = sc.nextLine().toUpperCase();
            }
            if (correctAnswer(input, fish) == true)
            {
                System.out.println(); // whitespace
                System.out.println("CORRECT!");
                System.out.println("you chose " + input.toUpperCase());
                System.out.println("computer chose " + fish);
                correct++;
            }
            else
            {
                System.out.println(); // whitespace
                System.out.println("INCORRECT!");
                System.out.println("you chose " + input.toUpperCase());
                System.out.println("computer chose " + fish);
            }
            System.out.println("you now have " + correct + " guesses correct.");
        }
        end(correct, sc);
        
    }

    public static void populateList (ArrayList<String> list) // populate arraylist for fish
    {
        list.add("AHI"); // element 0
        list.add("OPAH"); // element 1, and so on
        list.add("MAHIMAHI");
        list.add("ONO");
    }

    public static void end(int correct, Scanner sc) // end of game
    {
        System.out.println(); // whitespace
        System.out.println("GAME OVER! you got " + correct + " total correct guesses!");
        System.out.println("goodbye!");
        System.out.println(); // whitespace
        sc.close(); // close scanner to prevent any problems
        System.exit(0);
    }

    public static String cpuFish(ArrayList<String> list, Random rand) // computer generates a fish
    {
        int index;
        String fish;
        index = rand.nextInt(list.size()); // takes a random index from the size (similar to length of string) from the arraylist
        fish = list.get(index); // fish string = element at index in arraylist
        return fish;
    }

    public static boolean matchingAnswer(ArrayList<String> list, String input) // if the arraylist does NOT have a matching element as input, then...
    {
        if (list.contains(input))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static boolean correctAnswer(String input, String fish) // checks if answer is correct
    {
        if (input.equals(fish))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
