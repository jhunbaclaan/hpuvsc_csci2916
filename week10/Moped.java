package week10;
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

public class Moped {
    private int year, speed;
    private String make;

    public Moped(String m, int y)
    {
        this.make = m;
        this.year = y;
        this.speed = 0;
    }

    public Moped() // just filled with generic values
    {
        this.make = "Yamaha";
        this.year = 2021;
        this.speed = 0;
    }

    // setters
    public void setMake(String m)
    {
        make = m;
    }

    public void setYear(int y)
    {
        year = y;
    }

    public void setSpeed(int s)
    {
        speed = s;
    }

    // getters
    public String getMake()
    {
        return make;
    }

    public int getYear()
    {
        return year;
    }

    public int getSpeed()
    {
        return speed;
    }

    // accelerate + brake method
    public int accelerate()
    {
        int newSpeed = getSpeed() + 5; // creates a new int from the calculation
        setSpeed(newSpeed); // updates speed
        return newSpeed;
    }

    public int brake()
    {
        // checks if speed is not 0
        if (getSpeed() >= 5)
        {
            int newSpeed = getSpeed() - 5;
            setSpeed(newSpeed);
            return newSpeed;
        }
        else
        {
            System.out.println("Your moped is already at 0 MPH."); // might change this for clarification but idk
            return getSpeed();
        }
    }

    // toString method
    public String toString()
    {
        return "A " + getYear() + " " + getMake() + " going " + getSpeed() + " miles per hour.";
    }
}
