package week12;
/*
 * a program that intends to...
 * make two arrays, one for candy types and one for their costs
 * use methods to:
 1. outputs all food items
 2. outputs all food items and their costs
 3. returns the total cost
 4. returns the average cost
 5. randomly picks a candy
 6. extra credit -- output the highest candy and lowest candy by price
 * created by: jhun baclaan
 * d.o.c: 3/31/2023
 */
import java.util.*;
public class lab11_3312023 {
    public static void main(String[] args)
    {
        String[] candy = {"Gummy Bears", "Sour Gummy Worms", "Reeses Cups", "Kit-Kat", "Starburst"};
        double[] cost = {0.31,0.56,0.44,0.40, 0.34}; // note that prices are based on individual packs of "fun-size" candy
        System.out.println("My favorite Easter Candy:");
        printCandy(candy);

        System.out.println(); // whitespace
        System.out.println("Favorite Easter Candy and Cost");
        printAll(candy, cost);

        System.out.println(); // whitepace
        System.out.println("If I were to buy all of the Easter Candy, it would cost me $" + totalCost(cost));
        System.out.println("The average cost of the Easter candy: " + averageCost(cost));
        System.out.println("Selecting a random Easter candy: " + randomCandItem(candy));

        System.out.println(); // whitespace
        highestValue(candy, cost);
        lowestValue(candy, cost);

    }

    public static void printCandy(String[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
    public static void printAll(String[] food, double[] cost)
    {
        for (int i = 0; i < food.length; i++)
        {
            System.out.println(food[i] + ":  " + cost[i]);
        }
    }
    public static double totalCost(double[] array)
    {
        double total = 0;
        for (int i = 0; i < array.length; i++)
        {
            total += array[i];
        }
        return total;
    }
    /*
     * averageCost is just finding the average
     * although you only have to divide total by 5, it's safer to use array.length
     */
    public static double averageCost(double[] array)
    {
        double total = 0;
        for (int i = 0; i < array.length; i++)
        {
            total += array[i];
        }
        return (total / array.length);
    }
    /*
     * used the random class to select an item
     * creating an index using nextInt
     * array.length is used as the bound for nextInt, it ONLY chooses from those array elements
     */
    public static String randomCandItem(String[] array)
    {
        Random rand = new Random();
        int index = rand.nextInt(array.length);
        return array[index];
    }

    /*
     * extra credit
     * using for loops, we can find the largest price and match it to the candy
     * this is achieved via reassignment, where
     * if cost[i] is greater than the double max, max is reassigned to the value of cost[i]
     * at the same time, the string item will be reassigned to the corresponding value
     * when iteration is done, then return both values
     */
    public static void highestValue(String[] food, double[] cost)
    {
        String item = food[0];
        double max = cost[0];
        for (int i = 0; i < cost.length; i++)
        {
            if (max < cost[i])
            {
                max = cost[i];
                item = food[i];
            }
        }
        System.out.println("Highest value candy: " + item);
    }
    // lowest value method, same as above but modified a little
    public static void lowestValue(String[] food, double[] cost)
    {
        String item = food[0];
        double min = cost[0];
        for (int i = 0; i < cost.length; i++)
        {
            if (min > cost[i])
            {
                min = cost[i];
                item = food[i];
            }
        }
        System.out.println("Lowest value candy: " + item);
    }
}
