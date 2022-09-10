package Unit5.Distance;

public class Distance
{
    private int xOne,yOne,xTwo,yTwo;
    private double distance;

    public Distance()
    {
    }

    public Distance(int x1, int y1, int x2, int y2)
    {
        xOne = x1;
        yOne = y1;
        xTwo = x2;
        yTwo = y2;
    }

    public void setCoordinates(int x1, int y1, int x2, int y2)
    {
        xOne = x1;
        yOne = y1;
        xTwo = x2;
        yTwo = y2;
    }

    public void calcDistance()
    {
        // do the calculation here
        double firstSeg = Math.pow(xTwo - xOne, 2);
        double secondSeg = Math.pow(yTwo - yOne, 2);
        distance = Math.sqrt(firstSeg + secondSeg);
    }

    public double getDistance()
    {
        return distance;
    }

    public String toString()
    {
        // complete string output
        return "" + distance;
    }
}

