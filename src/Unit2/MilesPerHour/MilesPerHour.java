package Unit2.MilesPerHour;

import java.util.*;
import java.lang.*;
public class MilesPerHour
{
    // do not change the types of these variables
    private int distance, hours, minutes;
    private double mph;

    public MilesPerHour()
    {
        setNums(0,0,0);
        mph=0.0;
    }

    public MilesPerHour(int dist, int hrs, int mins)
    {
        this.distance = dist;
        this.hours = hrs;
        this.minutes = mins;
    }

    public void setNums(int dist, int hrs, int mins)
    {

    }

    public void calcMPH()
    {
        double milesPerHour = (double)distance/(hours + (double)minutes/60);
        this.mph = milesPerHour;

    }

    public String toString()
    {
        String finalMPH = String.valueOf(Math.round(mph));
        return finalMPH;
    }
}
