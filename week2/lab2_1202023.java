package week2;
/*
 * a program that:
 1a. simulates a guessing game
 1b. computer randomly picks from 4 current fish
 1c. user has to guess which fish the computer picked
 2. loops 10 times
 3. displays how many times the user got answer correct
 */
import java.util.*; // scanner & random import
public class lab2_1202023 {
    public static void main(String[] args)
    {
        // declaration
        ArrayList<String> fishList = new ArrayList<String>(); // makes it easier to randomly select a fish
        Random rand = new Random(); // allows a random fish selection
        Scanner sc = new Scanner(System.in);
        String fish, input;
        int index; 
        int correct = 0;

        // populate list with fish
        fishList.add("AHI"); // element 0
        fishList.add("OPAH"); // element 1, and so on
        fishList.add("MAHIMAHI");
        fishList.add("ONO");

        // game
        for (int i = 1; i <= 10; i++) // for loop for game, easier than using a while loop
        {
            index = rand.nextInt(fishList.size()); // takes a random index from the size (similar to length of string) from the arraylist
            fish = fishList.get(index); // fish string = element at index in arraylist
            // System.out.println(fish); // tests if it can actually display a fish
            System.out.println();
            System.out.println("ROUND " + i);
            System.out.println("i'm thinking of a fish.");
            System.out.print("is it ahi, opah, mahimahi, or ono? ");
            input = sc.nextLine().toUpperCase();
            /*
             * EXTRA CREDIT: input validation
             * takes inspiration from lab 1's input validation
             */
            while (!fishList.contains(input.toUpperCase())) // while the arraylist does NOT have a matching element as input, then...
            {
                System.out.print("please input a valid answer! "); // retry
                /* 
                 * NOTE: input is uppercase'd to become valid input
                 * if left lowercase, it will count as invalid
                */
                input = sc.nextLine().toUpperCase();
            }
            if (input.toUpperCase().equals(fish))
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
        // end of game / conclusion
        System.out.println(); // whitespace
        System.out.println("GAME OVER! you got " + correct + " total correct guesses!");
        System.out.println("goodbye!");
        System.out.println(); // whitespace
        sc.close(); // close scanner to prevent any problems
    }
}
