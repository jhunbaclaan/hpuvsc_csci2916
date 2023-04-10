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
public class Substance 
{
    private int temperature;
    // constructors
    public Substance()
    {
        temperature = 0;
    }
    public Substance(int t)
    {
        this.temperature = t;
    }
    // setters
    public void setTemperature(int t)
    {
        temperature = t;
    }
    // getters
    public int getTemperature()
    {
        return temperature;
    }

    // boolean methods
    // ethyl
    public boolean isEthylFreezing()
    {
        if (temperature <= -173)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isEthylBoiling()
    {
        if (temperature >= 172)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // oxygen
    public boolean isOxygenFreezing()
    {
        if (temperature <= -362)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isOxygenBoiling()
    {
        if (temperature >= 306)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // water
    public boolean isWaterFreezing()
    {
        if (temperature <= 32)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public boolean isWaterBoiling()
    {
        if (temperature >= 212)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
