package week11;
/*
 Substance
 - temperature : int
+ setTemperature(int t) : void
+ getTemperature() : int
+ isEthylFreezing(int t) : boolean
+ isEthylBoiling(int t) : boolean
+ isOxygenFreezing(int t) : boolean
+ isOxygenBoiling(int t) : boolean
+ isWaterFreezing(int t) : boolean
+ isWaterBoiling(int t) : boolean 
 */
import java.util.*;
public class lab10_3242023
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int temperature;
        int nothingCounter = 0; // see lines 78 - 83 for documentation
        while (true)
        {
            try{
                System.out.print("Enter a temperature (whole integer value only): ");
                temperature = sc.nextInt();
                sc.nextLine();
                break;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please enter a valid temperature!");
                sc.nextLine();
            }
        }
        sc.close();
        Substance substance = new Substance();
        substance.setTemperature(temperature);
        //System.out.println(substance.getTemperature()); // testing
        // printing out all of the substances that freeze/boil
        if (substance.isEthylFreezing())
        {
            System.out.println("Ethyl alcohol will freeze.");
        }
        else
        {
            nothingCounter++;
        }
        if (substance.isEthylBoiling())
        {
            System.out.println("Ethyl alcohol will boil.");
        }
        else
        {
            nothingCounter++;
        }
        if (substance.isOxygenFreezing())
        {
            System.out.println("Oxygen will freeze.");
        }
        else
        {
            nothingCounter++;
        }
        if (substance.isOxygenBoiling())
        {
            System.out.println("Oxygen will boil.");
        }
        else
        {
            nothingCounter++;
        }
        if (substance.isWaterFreezing())
        {
            System.out.println("Water will freeze.");
        }
        else
        {
            nothingCounter++;
        }
        if (substance.isWaterBoiling())
        {
            System.out.println("Water will boil.");
        }
        else
        {
            nothingCounter++;
        }
        /*
         * a unique print statement that uses the "nothingCounter"
         * the nothingCounter adds up every time a substance doesn't freeze or boil
         * if the nothingCounter reaches 6, then the unique statement is printed
         * this is just to add some flavor text since certain temperatures end the run without saying anything
         */
        if (nothingCounter == 6)
        {
            System.out.println("Water, oxygen, and ethyl alcohol will not boil or freeze at this temperature.");
        }
    }
}