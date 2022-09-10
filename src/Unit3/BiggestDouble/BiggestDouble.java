package Unit3.BiggestDouble;


public class BiggestDouble
{
    private double one,two,three,four;

    public BiggestDouble()
    {
        setDoubles(0,0,0,0);
    }

    public void setDoubles(double a, double b, double c, double d)
    {
        one = a;
        two = b;
        three = c;
        four = d;
    }

    public double getBiggest()
    {
        double max = one;

        if (two > max){
            max = two;
        }

        if(three > max){
            max = three;
        }

        if (four > max){
            max = four;
        }
        return max;
    }

    public String toString()
    {
        return one + " " + two + " " + three + " " + four;
    }

}
