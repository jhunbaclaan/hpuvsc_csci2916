/*
 * a program that intends to:
 1. take an input from user and store it in a string
 2. encrypt that string based on a shift "key" (also from user input)
 3. maintains case sensitivity + special characters
 4. displays the encrypted message to the user
 * created by: jhun baclaan
 * d.o.c: jan 27, 2023
 */
package week3;

import java.util.*;
public class lab3_1272023 {
    public static void  main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String userInput;
        char character;
        char newCharacter;
        int key, remainder;

        // user input
        System.out.print("what message would you like to encrypt? ");
        userInput = sc.nextLine();
        System.out.print("now, how much would you like to shift that message? ");
        key = sc.nextInt();

        // for loop that iterates through the entire string
        for (int i = 0; i < userInput.length(); i++)
        {
            // character from every letter of the string
            character = userInput.charAt(i);
            if ((int) character >= 65 && (int) character <= 90) // 'Z' loop back to 'A' [note to self: KEEP THE <= OPERATOR]
            {
                /*
                 * char newCharacter is defined by:
                 1. taking the character
                 2. subtracting by 'A' (26)
                 3. adding the key
                 4. modulus by 26 (this prevents inconsistency)
                 5. adding up the entire value of 2-4 by 'A'
                 */
                newCharacter = (char) (((character - 'A' + key) % 26) + 'A');
                if ((int) newCharacter > 90)
                {
                    remainder = (int)(newCharacter - 'A'); // remainder so the key doesnt overshoot the shift
                    System.out.print(newCharacter - remainder);
                }
                else
                {
                    System.out.print((char) (newCharacter));
                }
            }
            else if ((int) character >= 97 && (int) character <= 122) // 'z' loop back to 'a'
            {
                /*
                 * functionally similar to the one for the uppercase letters
                 */
                newCharacter = (char) (((character - 'a' + key) % 26) + 'a');
                if ((int) newCharacter >= 122)
                {
                    remainder = (int)(newCharacter - 'a');
                    System.out.print(newCharacter - remainder);
                }
                else
                {
                    System.out.print((char) (newCharacter));
                }
            }
            else // protects special characters from encryption
            {
                System.out.print((char) (character));
            }
        }
        // close scanner and exit program
        sc.close();
        System.exit(0);
    }
}
